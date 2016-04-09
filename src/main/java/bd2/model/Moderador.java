package bd2.model;


import java.util.*;

public class Moderador extends Usuario {
	
	/** Esta es la clase Moderador, la cuál es subclase de la clase Usuario y conoce a los idiomas que maneja el Moderador
	 * y las evaluaciones realizadas por él.*/
	
	private Collection<Idioma> idiomas = new LinkedList<Idioma>();
	private Collection<Evaluacion> evaluaciones = new LinkedList<Evaluacion>();
	
	/** Constructor de Moderador que recibe por parámetro un email, el nombre del moderador y la fecha de creación.*/
	public Moderador(String email, String nombre, Date fechaDeCreacion){
		super(email, nombre, fechaDeCreacion);
	}

	/** Método que retorna la reputación del Moderador, la cuál se corresponde con la cantidad de evaluaciones realizadas
	 * por el Moderador.*/
	public int reputacion(){
		return this.evaluaciones.size();
	}
	
	public void setEvaluaciones(Collection<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	
	public Collection<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public Collection<Idioma> getIdiomas() {
		return idiomas;
	}
	

	public void setIdiomas(Collection<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
	
	/** Método que retorna si el moderador maneja el idioma recibido por parámetro.*/
	public boolean manejaIdioma(Idioma idioma){
		return this.idiomas.contains(idioma);
	}
	
	/** Método que retorna si el moderador maneja el idioma recibido por parámetro.*/
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) throws Exception{
		if (this.manejaIdioma(traduccion.getIdioma()) && this.manejaIdioma(traduccion.getIdiomaOriginal())){
			Evaluacion evaluacionTemp = new Evaluacion(new Date(), descripcion, true, traduccion, puntaje);
			this.evaluaciones.add(evaluacionTemp);
		} else{
			throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		}
	}
	
	/** Método que agrega el idioam recibido por parámetro a los idiomas que maneja el Moderador.*/
	public void agregarIdioma(Idioma idioma){
		this.idiomas.add(idioma);
	}
	
}
