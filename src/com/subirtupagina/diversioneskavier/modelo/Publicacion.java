package com.subirtupagina.diversioneskavier.modelo;

public class Publicacion {
	private String titulo, link, description;

	public Publicacion(String titulo, String link, String description) {
		super();
		this.titulo = titulo;
		this.link = link;
		this.description = description;
		
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
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}

	
}
