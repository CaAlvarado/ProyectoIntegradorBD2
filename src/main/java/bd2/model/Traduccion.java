package bd2.model;

import java.util.Date;

public class Traduccion extends Tarea {
	
	/** Esta es la clase Traducción, la cual conoce el texto, el idioma en la que está escrita y el párrafo traducido.*/
	
	private String texto;
	private Idioma idioma;
	private Parrafo parrafo;
	
	/** Constructor que recibe por parámetro una fecha, una descripción, el texto de la traducción, el párrafo siendo traducido
	 * y el idioma de la traducción.*/
	public Traduccion(Date fecha, String descripcion, Boolean completa, String texto, Parrafo parrafo, Idioma idioma){
		super(fecha, descripcion, completa);
		this.texto=texto;
		this.idioma=idioma;
		this.parrafo=parrafo;
	}
	
	/** Método que retorna el idioma original en que estaba escrito el párrafo traducido.*/
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
	
	
	
}
