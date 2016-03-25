package bd2.model;

import java.util.HashMap;
import java.util.Map;

public class Diccionario {
	
	private String edicion;
	private Idioma idioma;
	private Map<String,String> definiciones= new HashMap<String,String>();
	
	public Diccionario(Idioma idioma, String edicion){
		this.idioma=idioma;
		this.edicion=edicion;
	}
	
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	
	public void agregarDefinicion(String palabra, String definicion){
		this.getDefiniciones().put(palabra, definicion);
	}
	
	public String definicion(String palabra){
		return this.getDefiniciones().get(palabra);
	}
	public Map<String, String> getDefiniciones() {
		return definiciones;
	}
}
