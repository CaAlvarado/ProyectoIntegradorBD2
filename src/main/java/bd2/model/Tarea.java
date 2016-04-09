package bd2.model;

import java.util.*;

public class Tarea {
	
	/** Esta es la clase Tarea, la cual conoce su fecham una descripción y un booleano que indica si está completa o no.*/
	
	Date fecha;
	String descripcion;
	Boolean completa;
	
	/** Constructor que recibe una fecha, una descripción y un booleano que indica si la tarea está completa.*/
	public Tarea (Date fecha, String descripcion, Boolean completa){
		this.fecha=fecha;
		this.descripcion=descripcion;
		this.completa=completa;
	}
	
	public void completar(){
		this.completa=true;
	}
	
	public Date getFecha(){
		return this.fecha;
	}
	
	public void setFecha(Date fecha){
		this.fecha=fecha;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	
	public Boolean getCompleta(){
		return this.completa;
	}
}
