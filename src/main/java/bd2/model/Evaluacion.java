package bd2.model;

import java.util.*;

/** Esta es la clase Evaluación, la cuál contiene un puntaje numérico y la traducción que es evaluada*/

public class Evaluacion extends Tarea {
	
	private Integer puntaje;
	private Traduccion traduccion;
	
	/** Método constructor de la clase "Evaluación" que recibe por parámetro una fecha, una descripción, 
	 * un booleano que indica completitud de la evaluación y el puntaje de la Evaluación*/
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Integer puntaje){
		super(fecha, descripcion, completa);
		this.puntaje=puntaje;
	}
	
	/** Método constructor de la clase "Evaluación" que recibe por parámetro una fecha, una descripción, 
	 * un booleano que indica completitud de la evaluación, la traducción evaluada y el puntaje de la Evaluación*/
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, int puntaje) {
		super(fecha, descripcion, completa);
		this.traduccion = traduccion;
		this.puntaje=puntaje;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public void setPuntaje(Integer puntaje) throws Exception{
		this.puntaje=puntaje;
	}
	
	public Traduccion getTraduccion(){
		return this.traduccion;
	}
	
	public void setTraduccion(Traduccion traduccion){
		this.traduccion=traduccion;
	}
	

}
