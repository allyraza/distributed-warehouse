package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class UserRegisterHelper {
	
	private static String _id = "IDL:register/UserRegister:1.0";

	public static void insert(org.omg.CORBA.Any a, UserRegister that) {
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public static UserRegister extract(org.omg.CORBA.Any a) {
		return read(a.create_input_stream());
	}

	private static org.omg.CORBA.TypeCode __typeCode = null;

	synchronized public static org.omg.CORBA.TypeCode type() {
		if (__typeCode == null) {
			__typeCode = org.omg.CORBA.ORB.init().create_interface_tc(
					UserRegisterHelper.id(), "UserRegister");
		}
		return __typeCode;
	}

	public static String id() {
		return _id;
	}

	public static UserRegister read(org.omg.CORBA.portable.InputStream istream) {
		return narrow(istream.read_Object(_UserRegisterStub.class));
	}

	public static void write(org.omg.CORBA.portable.OutputStream ostream,
			UserRegister value) {
		ostream.write_Object((org.omg.CORBA.Object) value);
	}

	public static UserRegister narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof UserRegister)
			return (UserRegister) obj;
		else if (!obj._is_a(id()))
			throw new org.omg.CORBA.BAD_PARAM();
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			_UserRegisterStub stub = new _UserRegisterStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

	public static UserRegister unchecked_narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof UserRegister)
			return (UserRegister) obj;
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			_UserRegisterStub stub = new _UserRegisterStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}