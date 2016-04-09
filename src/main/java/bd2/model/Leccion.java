package bd2.model;

/** Esta es la clase coleccion, la cual posee un nombre */
public class Leccion {
	private String nombre;

	/** Este constructor asigna al objeto leccion que se crea el nombre que llega por parametro */
	public Leccion(String nombre){
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
