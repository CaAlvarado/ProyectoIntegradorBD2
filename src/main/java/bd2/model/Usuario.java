package bd2.model;

import java.util.*;

/** Esta es la clase Usuario, la cual conoce su email, su nombre, la fecha de creaci�n,
 * las cursadas que realiz� y las traducciones que realiz�.*/
public class Usuario {
	
	private long id = 1L;
	private String email;
	private String nombre;
	private Date fechaDeCreacion;
	private Collection<Cursada> cursadasRealizadas = new LinkedList<Cursada>();
	private Collection<Traduccion> traducciones = new LinkedList<Traduccion>();
	
	public Usuario(){
		
	}
	
	/** Constructor de la clase que recibe por par�metro un email, un nombre y una fecha de creaci�n.*/
	public Usuario(String email, String nombre, Date fechaDeCreacion){
		this.email = email;
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	/** M�todo que retorna el nivel m�ximo entre las cursadas aprobadas por el usuario del idioma recibido por par�metro.*/	
	public int nivel(Idioma idioma){
		int nivMax=-1;
		for (Cursada cursadaAct : this.cursadasAprobadas(idioma)){
			if (cursadaAct.getNivel()>nivMax){
				nivMax=cursadaAct.getNivel();
			}
		}
		if (nivMax==-1){
			return 0;
		} else {
			return nivMax;
		}
	}
	
	/** M�todo que retorna todas las cursadas aprobadas por el usuario del idioma recibido por par�metro. Para esto,
	 * se selecciona de la colecci�n de cursadas realizadas las cursadas del idioma que es recibido por par�metro que fueron 
	 * finalizadas */	
	public Collection<Cursada> cursadasAprobadas(Idioma idioma){
		Collection<Cursada> CAprobadas = new LinkedList<Cursada>();
		for (Cursada cursadaAct : this.cursadasRealizadas){
			if(cursadaAct.finalizada() && cursadaAct.getIdioma().equals(idioma)){
				CAprobadas.add(cursadaAct);
			}
		}
		return CAprobadas;
	}
	
	public void agregarCursada(Cursada cursada){
		this.cursadasRealizadas.add(cursada);
	}
	
	public void agregarTraduccion(Traduccion traduccion){
		this.traducciones.add(traduccion);
	}
	
	public Collection<Cursada> getCursadasRealizadas(){
		return this.cursadasRealizadas;
	}
	
	public Collection<Traduccion> getTraducciones(){
		return this.traducciones;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public void setFechaDeCreacion(Date fechaDeCreacion){
		this.fechaDeCreacion=fechaDeCreacion;
	}
	
	public void setCursadasRealizadas(Collection<Cursada> cursadasRealizadas){
		this.cursadasRealizadas=cursadasRealizadas;
	}
	
	public void setTraducciones(Collection<Traduccion> traducciones){
		this.traducciones=traducciones;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	
	public Date getFechaDeCreacion(){
		return this.fechaDeCreacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
