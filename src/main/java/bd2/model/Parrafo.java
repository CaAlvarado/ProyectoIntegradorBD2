package bd2.model;

import java.util.*;

public class Parrafo {
	
	/** Esta es la clase Parrafo, la cual conoce el texto del párrafo y el Documento al que el párrafo pertenece.*/
	
	private String texto;
	private Documento documento;
	
	/** Contructor de Párrafo, el cuál recibe como parámetro un texto y el documento al que el párrafo pertenece.*/
	public Parrafo(String texto, Documento documento){
		this.texto=texto;
		this.documento=documento;
	}
	
	public String getTexto(){
		return this.texto;
	}
	
	public void setTexto(String texto){
		this.texto=texto;
	}
	
	public Documento getDocumento(){
		return this.documento;
	}
	
	public void setDocumento(Documento documento){
		this.documento=documento;
	}
}
