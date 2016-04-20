package bd2.model;
import java.util.Collection;
import java.util.LinkedList;

/** Esta es la clase sitio, que posee tres colecciones: usuarios, cursos y documentos */
public class Sitio {
	private long id = 1L;
	private Collection<Usuario> usuarios= new LinkedList<Usuario>();
	private Collection<Curso> cursos= new LinkedList<Curso>();
	private Collection<Documento> documentos= new LinkedList<Documento>();
	
	public Sitio(){
		
	}
	
	public Collection<Usuario> getUsuarios() {
		return this.usuarios;
	}
	public Collection<Curso> getCursos() {
		return this.cursos;
	}
	public Collection<Documento> getDocumentos() {
		return this.documentos;
	}
	
	public void registrarUsuario(Usuario usuario){
		this.usuarios.add(usuario);
	}
	
	public void agregarCurso(Curso curso){
		this.cursos.add(curso);
	}
	
	public void agregarDocumento(Documento documento){
		this.documentos.add(documento);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
