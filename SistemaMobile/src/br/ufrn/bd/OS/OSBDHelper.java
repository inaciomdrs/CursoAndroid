package br.ufrn.bd.OS;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.ufrn.bd.OS.OSContract.OSEntry;

public class OSBDHelper extends SQLiteOpenHelper {

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "sistema_mobile.db";
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	
	private static final String COMMA_SEP = ",";
	
	private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + OSEntry.TABLE_OS + " ( " +
							OSEntry.COLUMN_OS_ID + INTEGER_TYPE + " PRIMARY_KEY " + COMMA_SEP + 
							OSEntry.COLUMN_NOME_CLIENTE + TEXT_TYPE + COMMA_SEP + 
							OSEntry.COLUMN_ENDERECO_ENTREGA + TEXT_TYPE + COMMA_SEP +
							OSEntry.COLUMN_ENDERECO_COLETA + TEXT_TYPE + COMMA_SEP +
							OSEntry.COLUMN_OBSERVACAO + TEXT_TYPE + COMMA_SEP +
							OSEntry.COLUMN_STATUS + TEXT_TYPE + "(1)" + " )";
	
	private static final String SQL_DELETE_ENTRIES =
			"DROP TABLE IF EXISTS " + OSEntry.TABLE_OS;
		
	public OSBDHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL(SQL_DELETE_ENTRIES);
		onCreate(db);
	}
	

}
