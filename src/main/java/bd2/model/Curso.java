package bd2.model;

import java.util.Collection;
import java.util.LinkedList;

public class Curso {
	private String nombre;
	private int nivel;
	private Collection<Leccion> lecciones= new LinkedList<Leccion>();
	private Idioma idioma;
	
	public Curso(String nombre, Idioma idioma, int nivel){
		this.nombre=nombre;
		this.idioma=idioma;
		this.nivel=nivel;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getNivel() {
		return nivel;
	}
	public Collection<Leccion> getLecciones() {
		return lecciones;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	
	public void agregarLeccion(Leccion leccion){
		this.lecciones.add(leccion);
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
}
