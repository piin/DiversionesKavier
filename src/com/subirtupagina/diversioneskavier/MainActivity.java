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


import com.proyectosimio.proyectosimio.R;
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
	    //obtiene el estado de red
		ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();

		
		lvAdapter = new AdapterLVMain(this);
		lvPublicaciones = (ListView) findViewById(R.id.lvPublicaciones);
		lvPublicaciones.setAdapter(lvAdapter);
		lvPublicaciones.setOnItemClickListener(this);
		
       	//prueba de conexion a internet
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
		// Recuperamos el link de la publicación seleccionada.
		String link = lvAdapter.getItem(position).getLink();				
		//Inicia segundo activity
		Intent i = new Intent(this,Secciones.class);
		i.putExtra("urlImagen", link);
		startActivity(i);
		

	}
}
