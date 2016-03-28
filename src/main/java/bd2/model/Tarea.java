package bd2.model;

import java.util.*;

public class Tarea {
	Date fecha;
	String descripcion;
	Boolean completa;
	
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
}
