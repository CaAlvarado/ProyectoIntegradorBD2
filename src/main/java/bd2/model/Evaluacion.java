package bd2.model;

import java.util.*;

/** Esta es la clase Evaluaci�n, la cu�l contiene un puntaje num�rico y la traducci�n que es evaluada*/

public class Evaluacion extends Tarea {
	
	private Integer puntaje;
	private Traduccion traduccion;
	
	/** M�todo constructor de la clase "Evaluaci�n" que recibe por par�metro una fecha, una descripci�n, 
	 * un booleano que indica completitud de la evaluaci�n y el puntaje de la Evaluaci�n*/
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Integer puntaje){
		super(fecha, descripcion, completa);
		this.puntaje=puntaje;
	}
	
	/** M�todo constructor de la clase "Evaluaci�n" que recibe por par�metro una fecha, una descripci�n, 
	 * un booleano que indica completitud de la evaluaci�n, la traducci�n evaluada y el puntaje de la Evaluaci�n*/
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, int puntaje) {
		super(fecha, descripcion, completa);
		this.traduccion = traduccion;
		this.puntaje=puntaje;
	}
	
	public Evaluacion(){
		super();
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
