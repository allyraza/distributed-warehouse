package br.furb.diswah.transport;

import org.omg.CORBA.Any;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface Helper<T> {
	
	void insert(Any a, T that);

	T extract(Any a);

	TypeCode type();

	String id();

	T read(InputStream istream);

	void write(OutputStream ostream, T value);

	T narrow(org.omg.CORBA.Object obj);

	T unchecked_narrow(org.omg.CORBA.Object obj);

}