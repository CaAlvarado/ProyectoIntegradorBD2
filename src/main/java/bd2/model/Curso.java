package bd2.model;

import java.util.Collection;
import java.util.LinkedList;

/** Esta es la clase curso, que conoce su nombre, nivel, el idioma que se ense�a y las lecciones que le corresponden */	
public class Curso {	
	private long id = 1L;
	private String nombre;
	private int nivel;
	private Collection<Leccion> lecciones= new LinkedList<Leccion>();
	private Idioma idioma;
	
	/** Este constructor se encarga de asignar los parametros nombre, idioma y nivel a las variables de instancia del objeto que se crea */
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
