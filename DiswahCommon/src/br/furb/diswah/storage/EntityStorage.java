package br.furb.diswah.storage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.furb.diswah.model.BasicEntity;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 * @param <T> 
 */
public interface EntityStorage<T extends BasicEntity> extends Remote{

	/**
	 * @param value
	 * @throws RemoteException
	 */
	void validate(T value) throws RemoteException;
	
	/**
	 * @param id
	 * @return entity
	 * @throws RemoteException
	 */
	T find(Long id) throws RemoteException;
	
	/**
	 * @param value
	 * @return entity
	 * @throws RemoteException
	 */
	T save(T value) throws RemoteException;
	
	/**
	 * @param values
	 * @return entity
	 * @throws RemoteException
	 */
	List<T> saveAll(List<T> values) throws RemoteException;

	/**
	 * @return entity
	 * @throws RemoteException
	 */
	List<T> list() throws RemoteException;
	
	/**
	 * @param value
	 * @return entity
	 * @throws RemoteException
	 */
	T delete(T value) throws RemoteException;
	
}