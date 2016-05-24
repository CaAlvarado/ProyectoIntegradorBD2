package bd2.model;

import java.util.*;

/** Esta es la clase Parrafo, la cual conoce el texto del p�rrafo y el Documento al que el p�rrafo pertenece.*/
public class Parrafo {
	
	
	private long id = 1L;
	private String texto;
	private Documento documento;
	
	/** Contructor de P�rrafo, el cu�l recibe como par�metro un texto y el documento al que el p�rrafo pertenece.*/
	public Parrafo(String texto, Documento documento){
		this.texto=texto;
		this.documento=documento;
	}
	
	public Parrafo(){
		
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
