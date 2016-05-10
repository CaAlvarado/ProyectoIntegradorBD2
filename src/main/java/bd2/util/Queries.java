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
}
