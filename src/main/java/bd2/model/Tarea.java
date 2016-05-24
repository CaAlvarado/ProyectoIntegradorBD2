package bd2.model;

import java.util.*;

/** Esta es la clase Tarea, la cual conoce su fecham una descripci�n y un booleano que indica si est� completa o no.*/
public class Tarea {
	
	protected long id = 1L;
	protected Date fecha;
	protected String descripcion;
	protected Boolean completa;
	
	/** Constructor que recibe una fecha, una descripci�n y un booleano que indica si la tarea est� completa.*/
	public Tarea (Date fecha, String descripcion, Boolean completa){
		this.fecha=fecha;
		this.descripcion=descripcion;
		this.completa=completa;
	}
	
	public Tarea(){
		
	}
	
	public void setCompleta(Boolean comp){
		this.completar();
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
