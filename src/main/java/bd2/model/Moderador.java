package bd2.model;

import java.time.LocalDateTime;
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
	
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje){
		if (this.manejaIdioma(traduccion.getIdioma()) && this.manejaIdioma(traduccion.getIdiomaOriginal())){
			Evaluacion evaluacionTemp = new Evaluacion(new Date(), descripcion, true, traduccion, puntaje);
			this.evaluaciones.add(evaluacionTemp);
		} else{
			System.out.println("El moderador no maneja los idiomas necesarios para evaluar la traducción.");
		}
	}
	
	public void agregarIdioma(Idioma idioma){
		this.idiomas.add(idioma);
	}
	
}
