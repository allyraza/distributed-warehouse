package br.furb.diswah.transport;

import org.omg.CORBA.Any;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 * @param <T> 
 */
public interface Helper<T> {
	
	/**
	 * @param a
	 * @param that
	 */
	void insert(Any a, T that);

	/**
	 * @param a
	 * @return entity
	 */
	T extract(Any a);

	/**
	 * @return entity
	 */
	TypeCode type();

	/**
	 * @return entity
	 */
	String id();

	/**
	 * @param istream
	 * @return entity
	 */
	T read(InputStream istream);

	/**
	 * @param ostream
	 * @param value
	 */
	void write(OutputStream ostream, T value);

	/**
	 * @param obj 
	 * @return entity
	 */
	T narrow(org.omg.CORBA.Object obj);

	/**
	 * @param obj
	 * @return entity
	 */
	T unchecked_narrow(org.omg.CORBA.Object obj);

}