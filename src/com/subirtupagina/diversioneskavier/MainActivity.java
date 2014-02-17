package com.subirtupagina.diversioneskavier;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.subirtupagina.diversioneskavier.adapters.AdapterLVMain;
import com.subirtupagina.diversioneskavier.application.ProyectoSimioApplication;

public class MainActivity extends Activity implements OnItemClickListener {
	private ListView lvPublicaciones;
	private AdapterLVMain lvAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// delete bar title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.activity_main);
		
	
		lvAdapter = new AdapterLVMain(this);
		lvPublicaciones = (ListView) findViewById(R.id.lvPublicaciones);
		lvPublicaciones.setAdapter(lvAdapter);
		lvPublicaciones.setOnItemClickListener(this);
       	//prueba de conexion a internet
		pruebaInternet();

	}
	public void hangmanActivity(View view){
		Intent intent = new Intent(this,Intro.class);
		startActivity(intent);
	}
	private void pruebaInternet() {
	
		ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if( netInfo != null && netInfo.isConnectedOrConnecting()){      		
			((ProyectoSimioApplication) getApplication())
					.updatePublicaciones(lvAdapter);
	       	}else {
	       		Toast toast1 = Toast.makeText(getApplicationContext(), "No tienes acceso a Internet", Toast.LENGTH_LONG); 
	       	        toast1.show();
			}
		
	}
	
	

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position,
			long id) {
		// Recuperamos el link y la imagen de la publicación seleccionada.
		String link = lvAdapter.getItem(position).getLink();	
		String descripcion = lvAdapter.getItem(position).getDescription();
				
		//Inicia segundo activity
		Intent i = new Intent(this,Secciones.class);
		i.putExtra("urlImagen", link);
		i.putExtra("url", descripcion);
		startActivity(i);
		

	}
}
