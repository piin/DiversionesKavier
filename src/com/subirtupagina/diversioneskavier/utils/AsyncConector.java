package com.subirtupagina.diversioneskavier.utils;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import com.subirtupagina.diversioneskavier.modelo.Publicacion;

public class AsyncConector extends AsyncTask<Void, Void, Void> {
	private ArrayList<Publicacion> publicaciones;
	private ArrayAdapter<Publicacion> adapter;
	private String url;

	public AsyncConector(ArrayAdapter<Publicacion> adapter, String url) {
		this.adapter = adapter;
		this.url = url;

	}

	@Override
	protected Void doInBackground(Void... params) {
		ConectorHttpXML conector = new ConectorHttpXML(url);

		try {
			// Recogemos todas las publicaciones de Internet.
			publicaciones = conector.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// Añadimos todas las publicaciones al Adapter.
		for (Publicacion tmp : publicaciones)
			adapter.add(tmp);

		// Indicamos al Adapter que ha cambiado su contenido, para que actualice
		// a su vez los datos mostrados en el ListView.
		adapter.notifyDataSetChanged();
		super.onPostExecute(result);
	}

}
