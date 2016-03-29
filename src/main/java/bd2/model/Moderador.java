package bd2.model;


import java.util.*;

public class Moderador extends Usuario {
	
	private Collection<Idioma> idiomas = new LinkedList<Idioma>();
	private Collection<Evaluacion> evaluaciones = new LinkedList<Evaluacion>();
	
	public Moderador(String email, String nombre, Date fechaDeCreacion){
		super(email, nombre, fechaDeCreacion);
	}

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
	
	public boolean manejaIdioma(Idioma idioma){
		return this.idiomas.contains(idioma);
	}
	
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) throws Exception{
		if (this.manejaIdioma(traduccion.getIdioma()) && this.manejaIdioma(traduccion.getIdiomaOriginal())){
			Evaluacion evaluacionTemp = new Evaluacion(new Date(), descripcion, true, traduccion, puntaje);
			this.evaluaciones.add(evaluacionTemp);
		} else{
			throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		}
	}
	
	public void agregarIdioma(Idioma idioma){
		this.idiomas.add(idioma);
	}
	
}
