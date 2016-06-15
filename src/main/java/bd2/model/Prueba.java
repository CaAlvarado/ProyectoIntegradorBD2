package bd2.model;

/** Esta es la clase prueba, que conoce la leccion que se esta evaluando y el puntaje de dicha prueba */
public class Prueba {
	private long id = 1L;
	private Integer puntaje;
	private Leccion leccion;
	
	/** Este constructor asigna a la leccion del objeto a crearse la leccion que llega como parametro
	 * En cuanto al puntaje, debido a que tiene que ser entre 1 y 100, se llama al metodo #setPuntaje para asignar el puntaje que llega como segundo parametro
	 * Este constructor puede tirar una excepcion si #setPuntaje lo hace
	 */
	public Prueba(Leccion leccion, Integer puntaje) throws Exception{
		this.leccion=leccion;
		this.setPuntaje(puntaje);
	}

	public Prueba(){
		
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	/** Este metodo recibre un numero de puntaje como parametro y primero chequea si es negativo (menor a 0) o mayor a 100
	 * Si uno de los dos if evalua falso, el metodo tira una excepcion con el mensaje que aparece en el if donde ocurrio la misma
	 * Si ambos if evaluan verdadero, se asigna el puntaje al objeto prueba creado
	 */
	public void setPuntaje(Integer puntaje) throws Exception {
		if (puntaje<0) {
			throw new Exception ("No se puede usar valores negativos como puntaje de una prueba.");
		}
		if (puntaje>100){
			throw new Exception ("No se puede usar valores mayores a 100 como puntaje de una prueba.");
		}
		this.puntaje=puntaje;
	}

	public Leccion getLeccion() {
		return leccion;
	}

	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}
	
	/** Este metodo evalua si el puntaje es mayor o igual a 60 y returna true o false segun que evaluo el if */
	public Boolean aprobada(){
		if (this.getPuntaje() >= 60){
			return true;
		}
		else{
			return false;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
