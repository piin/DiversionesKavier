package com.subirtupagina.diversioneskavier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


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
	
		
		lvAdapter = new AdapterLVMain(this);
		lvPublicaciones = (ListView) findViewById(R.id.lvPublicaciones);
		lvPublicaciones.setAdapter(lvAdapter);
		lvPublicaciones.setOnItemClickListener(this);
		
		
		
		
		

		
		
		((ProyectoSimioApplication) getApplication())
				.updatePublicaciones(lvAdapter);

	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position,
			long id) {
		// Recuperamos el link de la publicación seleccionada.
		String link = lvAdapter.getItem(position).getLink();				
		//System.out.println(link);
		
		
		
		Intent i = new Intent(this,Secciones.class);
		i.putExtra("urlImagen", link);
		startActivity(i);
		

	}
}
