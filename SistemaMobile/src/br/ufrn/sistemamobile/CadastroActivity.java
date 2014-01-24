package br.ufrn.sistemamobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import br.ufrn.bd.OS.OS;
import br.ufrn.bd.OS.OSDAO;
import br.ufrn.example.sistemamobile.R;

public class CadastroActivity extends Activity {

	private EditText nomeCliente, endI, endF, status, observacao, numero;
	private OSDAO db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}
	
	public void cadastrarOS(View view){
		this.nomeCliente = (EditText) findViewById(R.id.nomeCli);
		this.endI = (EditText) findViewById(R.id.endSt);
		this.endF = (EditText) findViewById(R.id.endFi);
		this.numero = (EditText) findViewById(R.id.numero);
		this.status = (EditText) findViewById(R.id.status);
		this.observacao = (EditText) findViewById(R.id.obs);
		
		OS nova = new OS();
		
		nova.setNomeCliente(this.nomeCliente.getText().toString());
		nova.setEnderecoColeta(this.endI.getText().toString());
		nova.setEnderecoEntrega(this.endF.getText().toString());
		nova.setObservacao(this.observacao.getText().toString());
		nova.setStatus(this.status.getText().toString());
		nova.setOsID(Long.parseLong(this.numero.getText().toString()));
		
		db = new OSDAO(getApplicationContext());
		db.open();
		db.adicionar(nova);
		db.close();
		
		
	}

}
