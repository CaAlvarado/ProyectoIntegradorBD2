package bd2.model;

import java.util.Date;

public class Traduccion extends Tarea {
	
	private String texto;
	private Idioma idioma;
	private Parrafo parrafo;
	
	public Traduccion(Date fecha, String descripcion, Boolean completa, String texto, Parrafo parrafo, Idioma idioma){
		super(fecha, descripcion, completa);
		this.texto=texto;
		this.idioma=idioma;
		this.parrafo=parrafo;
	}
	
	public Idioma getIdiomaOriginal(){
		return this.parrafo.getDocumento().getIdioma();
	}
	
	public String getTexto(){
		return texto;
	}
	
	public Idioma getIdioma(){
		return idioma;
	}
	
	public Parrafo getParrafo(){
		return parrafo;
	}
	
	public void setTexto(String texto){
		this.texto=texto;
	}
	
	public void setIdioma(Idioma idioma){
		this.idioma=idioma;
	}
	
	public void setParrafo(Parrafo parrafo){
		this.parrafo=parrafo;
	}
	
	public Boolean getCompleta(){
		return this.completa;
	}
	
}
