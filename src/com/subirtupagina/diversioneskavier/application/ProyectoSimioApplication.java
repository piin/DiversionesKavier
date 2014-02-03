package com.subirtupagina.diversioneskavier.application;

import android.app.Application;
import android.widget.ArrayAdapter;

import com.subirtupagina.diversioneskavier.modelo.Publicacion;
import com.subirtupagina.diversioneskavier.utils.AsyncConector;

public class ProyectoSimioApplication extends Application {
	//Url del archivo XML
	private final static String URL = "http://promoandroid.com/kavier.xml";

	public void updatePublicaciones(ArrayAdapter<Publicacion> lvAdapter) {

		AsyncConector conector = new AsyncConector(lvAdapter, URL);
		conector.execute();
	}

}
