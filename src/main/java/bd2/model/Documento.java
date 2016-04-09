package bd2.model;

import java.util.*;

public class Documento {
	
	/** Esta es la clase Documento, la cual conoce su nombre, su complejidad, el idioma en el que está escrito y la colección de párrafos que lo conforman.*/
	
	private String nombre;
	private Integer complejidad;
	private Idioma idioma;
	private Collection<Parrafo> parrafos = new LinkedList<Parrafo>();
	
	
	/** Constructor de la clase que recibe por parámetro un nombre, una complejidad y el idioma en que el Documento está escrito.*/
	public Documento(String nombre, Integer complejidad, Idioma idioma){
		this.nombre=nombre;
		this.complejidad=complejidad;
		this.idioma=idioma;
	}
	
	/** Constructor de la clase que recibe por parámetro un nombre y el idioma en que el Documento está escrito.*/
	public Documento(String nombre, Idioma idioma){
		this.nombre=nombre;
		this.idioma=idioma;
	}
	
	/** Método de la clase que recibe por parámetro una complejidad, si el parámetro es mayor o igual a 0 o menor o igual a 10, se setea la complejidad. Caso contrario, 
	 * se lanza una excepción.*/
	public void setComplejidad(Integer complejidad) throws Exception{
		if (complejidad<0) {
			throw new Exception ("No se puede usar valores negativos como complejidad de un documento.");
		}
		if (complejidad>10){
			throw new Exception ("No se puede usar valores mayores a 10 como complejidad de un documento.");
		}
		this.complejidad=complejidad;
	}
	
	public Integer getComplejidad(){
		return this.complejidad;
	}
	
	public Idioma getIdioma(){
		return this.idioma;
	}
	
	public void setIdioma(Idioma idioma){
		this.idioma=idioma;
	}
	
	/** Método que crea un párrafo con el texto recibido por parámetro y lo agrega a la colección de párrafos del Documento.*/
	public Parrafo agregarParrafo(String texto){
		Parrafo tempParrafo = new Parrafo(texto,this);
		parrafos.add(tempParrafo);
		return tempParrafo;
	}
	
	public Collection<Parrafo> getParrafos(){
		return this.parrafos;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
}
