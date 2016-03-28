package bd2.model;

import java.util.*;

public class Evaluacion extends Tarea {
	
	private Integer puntaje;
	private Traduccion traduccion;
	
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Integer puntaje){
		super(fecha, descripcion, completa);
		this.puntaje=puntaje;
	}
	
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, int puntaje) {
		super(fecha, descripcion, completa);
		this.traduccion = traduccion;
		this.puntaje = puntaje;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public void setPuntaje(Integer puntaje){
		this.puntaje=puntaje;
	}
	
	public Traduccion getTraduccion(){
		return this.traduccion;
	}
	
	public void setTraduccion(Traduccion traduccion){
		this.traduccion=traduccion;
	}
	

}
