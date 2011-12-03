package br.furb.diswah.storage.corba;

import org.omg.CORBA.Any;
import org.omg.CORBA.BAD_PARAM;
import org.omg.CORBA.ORB;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;

import br.furb.diswah.transport.corba.Helper;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class EntityStorageHelper implements Helper<EntityStorage> {
	
	private static EntityStorageHelper instance;
	
	public static EntityStorageHelper getInstance(){
		if(instance == null)
			instance = new EntityStorageHelper();
		
		return instance;
	}
	
	private static String _id = "IDL:storage/EntityStorage:1.0";

	public void insert(Any a, EntityStorage that) {
		OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public EntityStorage extract(Any a) {
		return read(a.create_input_stream());
	}

	private TypeCode __typeCode = null;

	synchronized public TypeCode type() {
		if (__typeCode == null) {
			__typeCode = ORB.init().create_interface_tc(id(), "EntityStorage");
		}
		return __typeCode;
	}

	public String id() {
		return _id;
	}

	public EntityStorage read(InputStream istream) {
		return narrow(istream.read_Object(_EntityStorageStub.class));
	}

	public void write(OutputStream ostream, EntityStorage value) {
		ostream.write_Object((org.omg.CORBA.Object) value);
	}

	public EntityStorage narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof EntityStorage)
			return (EntityStorage) obj;
		else if (!obj._is_a(id()))
			throw new BAD_PARAM();
		else {
			Delegate delegate = ((ObjectImpl) obj)._get_delegate();
			_EntityStorageStub stub = new _EntityStorageStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

	public EntityStorage unchecked_narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof EntityStorage)
			return (EntityStorage) obj;
		else {
			Delegate delegate = ((ObjectImpl) obj)._get_delegate();
			_EntityStorageStub stub = new _EntityStorageStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}