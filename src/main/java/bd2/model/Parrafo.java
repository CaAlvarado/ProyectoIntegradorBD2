package bd2.model;

import java.util.*;

public class Parrafo {
	
	/** Esta es la clase Parrafo, la cual conoce el texto del p�rrafo y el Documento al que el p�rrafo pertenece.*/
	
	private String texto;
	private Documento documento;
	
	/** Contructor de P�rrafo, el cu�l recibe como par�metro un texto y el documento al que el p�rrafo pertenece.*/
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
