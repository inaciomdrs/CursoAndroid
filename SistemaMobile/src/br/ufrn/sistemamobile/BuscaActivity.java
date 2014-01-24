package br.ufrn.sistemamobile;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import br.ufrn.bd.OS.OS;
import br.ufrn.bd.OS.OSDAO;
import br.ufrn.example.sistemamobile.R;

public class BuscaActivity extends ListActivity {

	private EditText campoBusca;
	private OSDAO db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_busca);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.busca, menu);
		return true;
	}
	
	public void buscarOs(View view){
		campoBusca = (EditText) findViewById(R.id.editText1);
		String campo = campoBusca.getText().toString();
		
		db = new OSDAO(this);
		db.open();
		
		List<OS> resultados = db.buscar(campo); 
		
		db.close();
		
		ArrayAdapter<OS> adapter = new ArrayAdapter<OS>(this,android.R.layout.simple_list_item_1, resultados);
		setListAdapter(adapter);
		
	}

	
}
