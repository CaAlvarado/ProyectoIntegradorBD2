package bd2.model;

import java.util.LinkedHashMap;
import java.util.Map;

/** Esta es la clase diccionario, que conoce la edicion que lo realizo, el idioma de su contenido, 
 * y todas las palabras que posee junto con sus respectivas definiciones
 */
public class Diccionario {	
	private long id = 1L;
	private String edicion;
	private Idioma idioma;
	/** Se usa una estructura de mapa que mapea claves (las palabras) con sus valores (definiciones) */
	private Map<String,String> definiciones= new LinkedHashMap<String,String>();	
	
	/** Este constructor asigna los parametros idioma y edicion a las variables de instancia del objeto que se crea */
	public Diccionario(Idioma idioma, String edicion){
		this.idioma=idioma;
		this.edicion=edicion;
	}
	
	public Diccionario(){
		
	}
	
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	
	/** Este metodo recibe dos parametros: palabra y definicion
	 * Usando el metodo #put de la clase LinkedHashMap se inserta la definicion en el mapa teniendo junto con su clave, que es la palabra a la que define
	 */
	public void agregarDefinicion(String palabra, String definicion){
		this.getDefiniciones().put(palabra, definicion);
	}
	
	/** Este metodo retorna la definicion de la palabra que recibe como parametro
	 * Dicha definicion se recupera con el metodo #get de la clase LinkedHashMap pasandole por parametro la palabra que llego como parametro
	 */
	public String definicion(String palabra){
		return this.getDefiniciones().get(palabra);
	}
	public Map<String, String> getDefiniciones() {
		return definiciones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
