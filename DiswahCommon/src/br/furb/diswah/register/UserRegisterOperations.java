package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface UserRegisterOperations {

	/**
	 * @param p1
	 * @return str
	 */
	String save(String p1);
	
	/**
	 * @param p1
	 * @return str
	 */
	String find(int p1);

	/**
	 * @return str
	 */
	String list();

}