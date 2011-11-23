package br.furb.diswah.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.furb.diswah.model.Classification;
import br.furb.diswah.model.Product;
import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class Teste {
	
	public static void main(String[] args) throws Exception {
		Teste t = new Teste();
		t.setUp();
		t.testBasicUsage();
		t.tearDown();
	}

	private SessionFactory sessionFactory;

	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
	}

	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public void testBasicUsage() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//session.save( new User() );
		Classification c = new Classification();
		c.setCode(1l);
		c.setName("QUE MERDA");
		c.setDescription("Chupa meu pau!@!!");
		session.save( c );
		//session.save( new Product() );
		
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from User" ).list();
		for ( User user : (List<User>) result ) {
			System.out.println( "User :" + user.getId() );
		}
        session.getTransaction().commit();
        session.close();
	}
}