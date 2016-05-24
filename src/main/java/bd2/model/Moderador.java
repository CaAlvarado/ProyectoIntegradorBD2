package bd2.model;


import java.util.*;

/** Esta es la clase Moderador, la cu�l es subclase de la clase Usuario y conoce a los idiomas que maneja el Moderador
 * y las evaluaciones realizadas por �l.*/
public class Moderador extends Usuario {
	
	
	private long id = 1L;
	private Collection<Idioma> idiomas = new LinkedList<Idioma>();
	private Collection<Evaluacion> evaluaciones = new LinkedList<Evaluacion>();
	
	/** Constructor de Moderador que recibe por par�metro un email, el nombre del moderador y la fecha de creaci�n.*/
	public Moderador(String email, String nombre, Date fechaDeCreacion){
		super(email, nombre, fechaDeCreacion);
	}

	/** M�todo que retorna la reputaci�n del Moderador, la cu�l se corresponde con la cantidad de evaluaciones realizadas
	 * por el Moderador.*/
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
	
	/** M�todo que retorna si el moderador maneja el idioma recibido por par�metro.*/
	public boolean manejaIdioma(Idioma idioma){
		return this.idiomas.contains(idioma);
	}
	
	/** M�todo que eval�a una traducci�n, recibiendo por par�metro la traducci�n, la descripci�n y el puntaje
	 * asignado a la traducci�n. Para que se pueda evaluar una traducci�n, el moderador debe manejar tanto el idioma
	 * original del p�rrafo siendo traducido como el idioma en el que est� escrita la traducci�n. Si el moderador
	 * no maneja alguno de los dos idiomas, entonces se levanta una excepci�n.*/
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) throws Exception{
		if (this.manejaIdioma(traduccion.getIdioma()) && this.manejaIdioma(traduccion.getIdiomaOriginal())){
			Evaluacion evaluacionTemp = new Evaluacion(new Date(), descripcion, true, traduccion, puntaje);
			this.evaluaciones.add(evaluacionTemp);
		} else{
			throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		}
	}
	
	/** M�todo que agrega el idioam recibido por par�metro a los idiomas que maneja el Moderador.*/
	public void agregarIdioma(Idioma idioma){
		this.idiomas.add(idioma);
	}
	
	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
}
