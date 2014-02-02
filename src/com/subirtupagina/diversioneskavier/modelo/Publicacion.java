package com.subirtupagina.diversioneskavier.modelo;

public class Publicacion {
	private String titulo, link;

	public Publicacion(String titulo, String link) {
		super();
		this.titulo = titulo;
		this.link = link;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
