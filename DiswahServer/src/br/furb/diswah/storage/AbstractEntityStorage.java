package br.furb.diswah.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;

import br.furb.diswah.exception.ValidationException;
import br.furb.diswah.model.BasicEntity;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEntityStorage<T extends BasicEntity> extends UnicastRemoteObject implements EntityStorage<T>{

	/**
	 * @throws RemoteException
	 */
	protected AbstractEntityStorage() throws RemoteException {
		super();
	}

	@Override
	public void validate(T value) throws ValidationException {
	}

	@Override
	public T find(Long id) {
		Session session = HibernateSessionFactory.openSession();
		T value = (T) session.createQuery("from " + getEntityClass().getCanonicalName() + " obj where obj.id="+id).uniqueResult();
		HibernateSessionFactory.closeSession();
		return value;
	}

	@Override
	public T save(T value) {
		Session session = HibernateSessionFactory.openSession();
		session.save(value);
		HibernateSessionFactory.closeSession();
		return value;
	}

	@Override
	public List<T> saveAll(List<T> values) {
		for(T t : values)
			save(t);
		
		return values;
	}

	@Override
	public List<T> list() {
		Session session = HibernateSessionFactory.openSession();
		List<T> list = session.createQuery("from " + getEntityClass().getCanonicalName()).list();
		HibernateSessionFactory.closeSession();
		return list;
	}
	
	@Override
	public T delete(T value) {
		Session session = HibernateSessionFactory.openSession();
		session.delete(value);
		HibernateSessionFactory.closeSession();
		return value;	
	}
	
	protected abstract Class<T> getEntityClass();

}