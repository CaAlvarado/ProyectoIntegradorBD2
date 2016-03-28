package bd2.model;

import java.util.*;

public class Parrafo {
	
	private String texto;
	private Documento documento;
	
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
