package com.subirtupagina.diversioneskavier.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.proyectosimio.proyectosimio.R;
import com.subirtupagina.diversioneskavier.HolderLVMain;
import com.subirtupagina.diversioneskavier.modelo.Publicacion;

public class AdapterLVMain extends ArrayAdapter<Publicacion> {
	private Context context;

	public AdapterLVMain(Context context) {
		super(context, R.layout.lvpublicaciones_item,
				new ArrayList<Publicacion>());
		this.context = context;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HolderLVMain holder;
		if (convertView == null) {
			holder = new HolderLVMain();

			convertView = LayoutInflater.from(context).inflate(
					R.layout.lvpublicaciones_item, null);

			holder.tvTitulo = (TextView) convertView
					.findViewById(R.id.tvTitulo);

			convertView.setTag(holder);
		}

		holder = (HolderLVMain) convertView.getTag();
			holder.tvTitulo.setText(getItem(position).getTitulo());

		return convertView;
	}

}
