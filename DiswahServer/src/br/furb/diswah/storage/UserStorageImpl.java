package br.furb.diswah.storage;

import java.rmi.RemoteException;

import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.hibernate.loader.criteria.CriteriaQueryTranslator;
import org.hibernate.sql.JoinType;

import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class UserStorageImpl extends AbstractEntityStorage<User> implements UserStorage {

	/**
	 * @throws RemoteException
	 */
	public UserStorageImpl() throws RemoteException {
		super();
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	public User logUser(String login, String password){
		Session session = HibernateSessionFactory.openSession();
		
		session.createCriteria(getEntityClass()).createCriteria("ds_login", JoinType.NONE);

		ScrollableResults scroll = session.createSQLQuery(String.format("select user from user where ds_login='%s' and ds_password='%s'", 
											 login,password))
										  .addEntity(getEntityClass()).scroll();
		
		return scroll.last() ? null : (User) scroll.get(0);
	}
	
}