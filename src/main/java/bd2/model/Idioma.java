package bd2.model;

// Esta es la clase idioma, que posee un nombre y un diccionario de palabras y definiciones
public class Idioma {
	private String nombre;
	private Diccionario diccionario;
	
	// Este constructor asigna un string que llega por parametro, que es el nombre del idioma, 
	// y tambien crea un diccionario nuevo vacio pasandose el idioma mismo como primer parametro para el constructor de diccionario
	public Idioma(String idioma){
		this.nombre=idioma;
		this.diccionario= new Diccionario(this, "");
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Diccionario getDiccionario() {
		return diccionario;
	}
	public void setDiccionario(Diccionario diccionario) {
		this.diccionario = diccionario;
	}
	
	
}
