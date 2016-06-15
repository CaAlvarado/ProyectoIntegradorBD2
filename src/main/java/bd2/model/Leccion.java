package bd2.model;

/** Esta es la clase coleccion, la cual posee un nombre */
public class Leccion {
	private long id = 1L;
	private String nombre;

	/** Este constructor asigna al objeto leccion que se crea el nombre que llega por parametro */
	public Leccion(String nombre){
		this.nombre=nombre;
	}
	
	public Leccion(){
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
