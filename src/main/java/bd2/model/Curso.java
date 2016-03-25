package bd2.model;

import java.util.Collection;
import java.util.LinkedList;

public class Curso {
	private String nombre;
	private Integer nivel;
	private Collection<Leccion> lecciones= new LinkedList<Leccion>();
	private Idioma idioma;
	
	public String getNombre() {
		return nombre;
	}
	public Integer getNivel() {
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
