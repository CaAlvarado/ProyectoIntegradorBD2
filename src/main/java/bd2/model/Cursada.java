package bd2.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public class Cursada {
	private Usuario usuario;
	private Date inicio;
	private Curso curso;
	private Collection<Prueba> pruebas= new LinkedList<Prueba>();
	
	public Cursada(Curso curso, Date inicio, Usuario usuario){
		this.inicio=inicio;
		this.usuario=usuario;
		usuario.agregarCursada(this);;
		this.curso=curso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Collection<Prueba> getPruebas() {
		return pruebas;
	}
	
	public Idioma getIdioma(){
		return this.curso.getIdioma();
	}
	
	public int getNivel(){
		return this.curso.getNivel();
	}
	
	public void agregarPrueba(Prueba prueba){
		this.pruebas.add(prueba);
	}
	
	public Collection<Leccion> leccionesAprobadas(){
		Collection<Leccion> aprobadas= new LinkedList<Leccion>();
		for (Prueba prueba: this.getPruebas()){
			if (prueba.aprobada()){
				aprobadas.add(prueba.getLeccion());
			}
		}
		return aprobadas;
	}
	
	public Boolean finalizada(){
		Collection<Leccion> aprobadas= this.leccionesAprobadas();
		Collection<Leccion> leccionesCurso= this.getCurso().getLecciones();
		for (Leccion leccion: leccionesCurso){
			if (!aprobadas.contains(leccion)){
				return false;
			}
		}
		return true;
	}
}
