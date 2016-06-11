package bd2.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bd2.model.*;

public class Queries {

	private static SessionFactory sesion;
	
	public static void main(String[] args){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");
		sesion = cfg.buildSessionFactory();
		Session session = sesion.openSession();
		try {
			consultaA(session);
			consultaB(session);
			consultaC(session);
			consultaE(session);
			consultaG(session, "Leuchtturm");
			consultaH(session);
			consultaI(session, "Alemán");
		}
		catch (Exception e){
			e.printStackTrace();
			session.close();
		}
		finally{
			session.disconnect();
		}
	}
	
	private static void consultaA(Session session){
		Transaction tx = null;
		System.out.println("a. Listar los nombres de todos los documentos");
		
		Query query= session.createQuery("select d from "+Documento.class.getName()+" d");
		
		try {
			tx = session.beginTransaction();
			List<Documento> documentos = query.list();
			tx.commit();
			session.flush();
			for (Documento d: documentos){
				System.out.println("Documento: "+d.getNombre());
			}
			System.out.println();
		} catch (HibernateException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
		}
	}
	
	private static void consultaB(Session session){
		Transaction tx = null;
		System.out.println("b. Listar los emails de los moderadores que hayan evaluado traducciones al inglés.");
		
		Query query = session.createQuery("select distinct moderador from "+Moderador.class.getName()+" moderador "
				+ "join moderador.evaluaciones evaluaciones "
				+ "join evaluaciones.traduccion traduccion "
				+ "join traduccion.idioma idioma where idioma.nombre='Inglés'");
		
		try {
			tx = session.beginTransaction();
			List<Moderador> moderadores = query.list();
			tx.commit();
			session.flush();
			for (Moderador m:moderadores){
				System.out.println("Email: "+m.getEmail());
			}
			System.out.println();
		}
		catch (HibernateException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
		}
	}
	
	private static void consultaC(Session session){
		Transaction tx = null;
		System.out.println("c. Listar los usuarios que hayan iniciado una cursada de Francés de nivel 3 como mínimo");
		
		Query query = session.createQuery("select distinct usuario from "+Usuario.class.getName()+" usuario "
				+ "join usuario.cursadasRealizadas cr "
				+ "where cr.curso.idioma.nombre like 'Francés' and cr.curso.nivel > 2");
		
		
		try {
			tx = session.beginTransaction();
			List<Usuario> usuarios= query.list();
			tx.commit();
			session.flush();
			for (Usuario u: usuarios){
				System.out.println("Nombre: "+u.getNombre());
			}
			System.out.println();
		}
		catch (HibernateException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
		}
	}
	
	private static void consultaE(Session session){
		Transaction tx = null;
		System.out.println("e. Listar traducciones completas del Inglés al Francés");
		
		Query query = session.createQuery("select traduccion from "+Traduccion.class.getName()+" traduccion "
				+ "where traduccion.idioma.nombre='Francés' and traduccion.parrafo.documento.idioma.nombre='Inglés'");
		
		try {
			tx = session.beginTransaction();
			List<Traduccion> traducciones= query.list();
			tx.commit();
			session.flush();
			for (Traduccion t:traducciones){
				System.out.println("Nombre: "+t.getDescripcion());
			}
			System.out.println();
		}
		catch (HibernateException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
		}
	}
	
	private static void consultaG(Session session, String palabra){
		Transaction tx = null;
		System.out.println("g. Obtener el nombre del idioma que define la palabra enviada como parámetro en su diccionario");
		Query query = session.createQuery("select idioma from "+Idioma.class.getName()+" idioma "
				+ "join idioma.diccionario diccionario "
				+ "join diccionario.definiciones definiciones "
				+ "where index(definiciones)=:palabra ");
		query.setParameter("palabra", palabra);
		
		try {
			tx = session.beginTransaction();
			Idioma idioma = (Idioma) query.uniqueResult();
			tx.commit();
			session.flush();
			System.out.println("El idioma "+idioma.getNombre()+" define la palabra "+palabra);
			System.out.println();
		}
		catch (HibernateException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
		}
	}
	
	private static void consultaH(Session session){
		Transaction tx = null;
		System.out.println("H. Obtener los nombres de los documentos que no tengan ningún párrafo traducido (en ningún idioma).");
		
		Query query = session.createQuery("select distinct documento from "+Documento.class.getName()+" documento join documento.parrafos parrafos where not exists "
				+ " ( select distinct parrafo from "+Parrafo.class.getName()+" parrafo where parrafo.documento=documento and exists "
						+ " ( select traduccion from "+Traduccion.class.getName()+" traduccion where traduccion.parrafo=parrafo))");
		
		try {
			tx = session.beginTransaction();
			List<Documento> documentos = query.list();
			tx.commit();
			session.flush();
			for (Documento d:documentos){
				System.out.println("El documento "+d.getNombre()+" no tiene ninguna traducción");
			}
			System.out.println();
		}
		catch (HibernateException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
		}
	}
	
	private static void consultaI(Session session, String idioma){
		Transaction tx = null;
		System.out.println("i. Obtener los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro");
		
		Query query = session.createQuery(
				"select distinct documento from "+Documento.class.getName()+" documento join documento.parrafos parrafos where exists "
						+ " ( select distinct parrafo from "+Parrafo.class.getName()+" parrafo where parrafo.documento=documento and not exists "
								+ "( select traduccion from "+Traduccion.class.getName()+" traduccion where traduccion.idioma.nombre=:idioma and traduccion.parrafo=parrafo ))");
		query.setParameter("idioma", idioma);
		
		try {
			tx = session.beginTransaction();
			List<Documento> documentos= query.list();
			tx.commit();
			session.flush();
			for (Documento d:documentos){
				System.out.println("El documento "+d.getNombre()+" no está totalmente traducido");
			}
			System.out.println();
		}
		catch (HibernateException e){
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
		}
	}
}
