package br.furb.diswah.register;

import org.omg.CORBA.Any;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;

import br.furb.diswah.transport.Helper;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClassificationRegisterHelper implements Helper<ClassificationRegister>{
	
	private static String _id = "IDL:register/ClassificationRegister:1.0";

	private static org.omg.CORBA.TypeCode __typeCode = null;
	
	private static ClassificationRegisterHelper instance;
	
	/**
	 * @return instance
	 */
	public static ClassificationRegisterHelper getInstance(){
		if(instance == null)
			instance = new ClassificationRegisterHelper();
		
		return instance;
	}

	public void insert(Any a, ClassificationRegister that) {
		OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public ClassificationRegister extract(Any a) {
		return read(a.create_input_stream());
	}


	public synchronized TypeCode type() {
		if (__typeCode == null) {
			__typeCode = org.omg.CORBA.ORB.init().create_interface_tc(id(),"ClassificationRegister");
		}
		return __typeCode;
	}

	public String id() {
		return _id;
	}

	public ClassificationRegister read(InputStream istream) {
		return narrow(istream.read_Object(_ClassificationRegisterStub.class));
	}

	public void write(OutputStream ostream, ClassificationRegister value) {
		ostream.write_Object((org.omg.CORBA.Object) value);
	}

	public ClassificationRegister narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof ClassificationRegister)
			return (ClassificationRegister) obj;
		else if (!obj._is_a(id()))
			throw new org.omg.CORBA.BAD_PARAM();
		else {
			Delegate delegate = ((ObjectImpl) obj)._get_delegate();
			_ClassificationRegisterStub stub = new _ClassificationRegisterStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

	public ClassificationRegister unchecked_narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof ClassificationRegister)
			return (ClassificationRegister) obj;
		else {
			Delegate delegate = ((ObjectImpl) obj)._get_delegate();
			_ClassificationRegisterStub stub = new _ClassificationRegisterStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}