package br.furb.diswah.storage.corba;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface EntityStorageOperations {

	String save(String p1);

	String find(int p1);

	String delete(int p1);

	String list();

}