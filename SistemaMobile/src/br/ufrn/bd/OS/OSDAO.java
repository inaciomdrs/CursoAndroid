package br.ufrn.bd.OS;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import br.ufrn.bd.OS.OSContract.OSEntry;

public class OSDAO {
	private SQLiteDatabase db;
	private OSBDHelper dbHelper;
	
	private String[] allcolumns = {
			OSEntry.COLUMN_ENDERECO_COLETA, OSEntry.COLUMN_ENDERECO_ENTREGA,
			OSEntry.COLUMN_NOME_CLIENTE, OSEntry.COLUMN_OBSERVACAO,
			OSEntry.COLUMN_OS_ID, OSEntry.COLUMN_STATUS
	};
	
	public OSDAO(Context context){
		dbHelper = new OSBDHelper(context);
	}
	
	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public OS adicionar(OS os){
		ContentValues values = new ContentValues();
		
		values.put(OSEntry.COLUMN_ENDERECO_COLETA, os.getEnderecoColeta());
		values.put(OSEntry.COLUMN_ENDERECO_ENTREGA, os.getEnderecoEntrega());
		values.put(OSEntry.COLUMN_NOME_CLIENTE, os.getNomeCliente());
		values.put(OSEntry.COLUMN_OBSERVACAO, os.getObservacao());
		values.put(OSEntry.COLUMN_OS_ID, os.getOsID());
		values.put(OSEntry.COLUMN_STATUS, os.getStatus());
		
		long insertID = db.insert(OSEntry.TABLE_OS, null, values);
		
		Cursor cursor = db.query(OSEntry.TABLE_OS, allcolumns, 
				OSEntry.COLUMN_OS_ID + " = " + insertID, null, null, null, null);
		cursor.moveToFirst();
		
		OS ordem = cursorToOS(cursor);
		
		cursor.close();
		
		return ordem;
		
	}
	
	public void excluir(OS os){
		long id = os.getOsID();
		db.delete(OSEntry.TABLE_OS, OSEntry.COLUMN_OS_ID + " = " + id, null);
	}
	
	public List<OS> listarTodos(){
		List<OS> Ordens = new ArrayList<OS>();
		
		Cursor cursor = db.query(OSEntry.TABLE_OS,
				allcolumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			OS ordem = cursorToOS(cursor);
			Ordens.add(ordem);
			cursor.moveToNext();
		}
		cursor.close();
		
		return Ordens;
	}
	
	public List<OS> buscar(String valor){
		String[] results = {OSEntry.COLUMN_OS_ID, OSEntry.COLUMN_NOME_CLIENTE,OSEntry.COLUMN_STATUS}; 
		
		Cursor cursor = db.query(OSEntry.TABLE_OS,results,OSEntry.COLUMN_OS_ID + " = " + valor + " OR " + 
									OSEntry.COLUMN_NOME_CLIENTE + " LIKE %" + valor + "%", 
								 null, null, null, null);
		cursor.moveToFirst();
		
		ArrayList<OS> ordens = new ArrayList<OS>(); 
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			OS ordem = cursorToOS(cursor);
			ordens.add(ordem);
			cursor.moveToNext();
		}
		
		cursor.close();
		
		return ordens;
	}
	
	public OS cursorToOS(Cursor cursor){
		OS os = new OS();
		os.setOsID(cursor.getLong(0));
		os.setNomeCliente(cursor.getString(1));
		os.setEnderecoEntrega(cursor.getString(2));
		os.setEnderecoColeta(cursor.getString(3));
		os.setObservacao(cursor.getString(4));
		os.setStatus(cursor.getString(5));
		return os;
	}

}
