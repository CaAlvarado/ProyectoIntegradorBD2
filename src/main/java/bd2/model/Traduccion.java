package bd2.model;

import java.util.Date;

/** Esta es la clase Traducci�n, la cual conoce el texto, el idioma en la que est� escrita y el p�rrafo traducido.*/
public class Traduccion extends Tarea {
	
	
	
	private String texto;
	private Idioma idioma;
	private Parrafo parrafo;
	
	/** Constructor que recibe por par�metro una fecha, una descripci�n, el texto de la traducci�n, el p�rrafo siendo traducido
	 * y el idioma de la traducci�n.*/
	public Traduccion(Date fecha, String descripcion, Boolean completa, String texto, Parrafo parrafo, Idioma idioma){
		super(fecha, descripcion, completa);
		this.texto=texto;
		this.idioma=idioma;
		this.parrafo=parrafo;
	}

	public Traduccion(){
		super();
	}
	
	/** M�todo que retorna el idioma original en que estaba escrito el p�rrafo traducido.*/
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
