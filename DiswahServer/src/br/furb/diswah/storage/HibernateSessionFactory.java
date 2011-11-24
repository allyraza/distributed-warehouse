package br.furb.diswah.storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public final class HibernateSessionFactory {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	@SuppressWarnings("deprecation")
	public static Session openSession() {
		if(sessionFactory == null){
			//sessionFactory = new Configuration().configure().buildSessionFactory(new ServiceRegistryBuilder().buildServiceRegistry());
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		return session;
	}

	public static void closeSession() {
		session.getTransaction().commit();
		session.close();
	}
	
}