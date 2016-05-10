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
			consultaC(session);
			consultaG(session, "Leuchtturm");
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
	
	private static void consultaC(Session session){
		Transaction tx = null;
		System.out.println("c. Listar los usuarios que hayan iniciado una cursada de Francés de nivel 3 como mínimo");
		
		Query query = session.createQuery("select distinct usuario from "+Usuario.class.getName()+" usuario join usuario.cursadasRealizadas cr where cr.curso.idioma.nombre like 'Francés' and cr.curso.nivel > 2");
		
		
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
		
		Query query = session.createQuery("select traduccion from "+Traduccion.class.getName()+" traduccion join traduccion.parrafo parrafo where parrafo.documento.idioma.nombre like 'Inglés' and traduccion.completa = 1 and traduccion.idioma.nombre like 'Francés'");
		
		
		try {
			tx = session.beginTransaction();
			List<Traduccion> traducciones= query.list();
			tx.commit();
			session.flush();
			for (Traduccion t: traducciones){
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
		
		Query query = session.createQuery("select diccionario from "+Diccionario.class.getName()+" diccionario where exists ( from "+Diccionario.class.getName()+" diccionario join diccionario.definiciones definiciones where definiciones)");
		query.setParameter("palabra", palabra);
		
		
		try {
			tx = session.beginTransaction();
			Diccionario diccionario = (Diccionario) query.uniqueResult();
			tx.commit();
			session.flush();
			System.out.println("El idioma "+diccionario.getIdioma().getNombre()+" define la palabra "+palabra);
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
