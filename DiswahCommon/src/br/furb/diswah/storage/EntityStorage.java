package br.furb.diswah.storage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.furb.diswah.model.BasicEntity;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface EntityStorage<T extends BasicEntity> extends Remote{

	void validate(T value) throws RemoteException;
	
	T find(Long id) throws RemoteException;
	
	T save(T value) throws RemoteException;
	
	List<T> saveAll(List<T> values) throws RemoteException;

	List<T> list() throws RemoteException;
	
	T delete(T value) throws RemoteException;
	
}