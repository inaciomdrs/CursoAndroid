package br.ufrn.sistemamobile;

import br.ufrn.example.sistemamobile.BuscaActivity;
import br.ufrn.example.sistemamobile.CadastroActivity;
import br.ufrn.example.sistemamobile.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
<<<<<<< HEAD
import android.view.View;

public class MainActivity extends Activity {

=======
import android.widget.Button;

public class MainActivity extends Activity {

	Button b = new Button(this);
>>>>>>> 23d4f664f2fe3a655ae8f2611c5314e4d86a6e5e
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void abrirOS(View v){
		Intent i = new Intent(this,CadastroActivity.class);
		startActivity(i);
	}
	
	public void buscaOS(View v){
		Intent i = new Intent(this,BuscaActivity.class);
		startActivity(i);
	}

}
