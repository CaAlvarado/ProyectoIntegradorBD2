package bd2.model;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

// Esta es la clase cursada que conoce a sus alumnos, fecha de inicio, 
// a que curso pertenece, y que pruebas se realizaron en ella
public class Cursada {													
	private Usuario usuario;											
	private Date inicio;
	private Curso curso;
	private Collection<Prueba> pruebas= new LinkedList<Prueba>();
	
	// Este constructor se encarga de asignar los parametros curso, inicio y usuario a las correspondientes variables de instancia al objeto que se crea, 
	// asi como tambien le asigna al objeto usuario que paso por parametro la cursada que se esta creando
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
	
	// Este metodo recupera el idioma del curso al que pertenece esta cursada
	public Idioma getIdioma(){
		return this.curso.getIdioma();
	}
	
	// Este metodo recupera el nivel del curso al que pertenece esta cursada
	public int getNivel(){
		return this.curso.getNivel();
	}
	
	public void agregarPrueba(Prueba prueba){
		this.pruebas.add(prueba);
	}
	
	// Este metodo (que retorna una coleccion de lecciones) se encarga de buscar en la coleccion de pruebas de esta cursada las que fueron aprobadas, 
	// y guarda la leccion de cada prueba aprobada en la coleccion a retornar
	public Collection<Leccion> leccionesAprobadas(){
		Collection<Leccion> aprobadas= new LinkedList<Leccion>();
		for (Prueba prueba: this.getPruebas()){
			if (prueba.aprobada()){
				aprobadas.add(prueba.getLeccion());
			}
		}
		return aprobadas;
	}
	
	// Este metodo toma las lecciones aprobadas en la cursada, y las lecciones totales del curso de la cursada, recorriendo dicha coleccion de lecciones 
	// y preguntando si estan incluidas en la coleccion de lecciones aprobadas
	// Si todas las lecciones del curso correspondiente estan en la coleccion de aprobadas retorna true, caso contrario retorna false
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
