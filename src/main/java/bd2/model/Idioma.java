package bd2.model;

public class Idioma {
	private String nombre;
	private Diccionario diccionario;
	
	public Idioma(String idioma){
		this.nombre=idioma;
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
