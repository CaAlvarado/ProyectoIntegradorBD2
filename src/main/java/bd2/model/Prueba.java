package bd2.model;

public class Prueba {
	private Integer puntaje;
	private Leccion leccion;
	
	public Prueba(Leccion leccion, Integer puntaje){
		this.leccion=leccion;
		this.puntaje=puntaje;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public Leccion getLeccion() {
		return leccion;
	}

	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}
	
	public Boolean aprobada(){
		if (this.puntaje >= 60){
			return true;
		}
		else{
			return false;
		}
	}
}
