package bd2.model;

import java.util.*;

public class Documento {
	
	private String nombre;
	private Integer complejidad;
	private Idioma idioma;
	private Collection<Parrafo> parrafos = new LinkedList<Parrafo>();
	
	public Documento(String nombre, Integer complejidad, Idioma idioma){
		this.nombre=nombre;
		this.complejidad=complejidad;
		this.idioma=idioma;
	}
	
	public Documento(String nombre, Idioma idioma){
		this.nombre=nombre;
		this.idioma=idioma;
	}
	
	public void setComplejidad(Integer complejidad){
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
