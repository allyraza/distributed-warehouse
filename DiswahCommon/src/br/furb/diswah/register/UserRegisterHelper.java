package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class UserRegisterHelper {

	private static String _id = "IDL:register/UserRegister:1.0";

	private static org.omg.CORBA.TypeCode __typeCode = null;

	private static UserRegisterHelper instance;
	
	public static UserRegisterHelper getInstance(){
		if(instance == null)
			instance = new UserRegisterHelper();
		
		return instance;
	}
	
	public void insert(org.omg.CORBA.Any a, UserRegister that) {
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public UserRegister extract(org.omg.CORBA.Any a) {
		return read(a.create_input_stream());
	}

	synchronized public org.omg.CORBA.TypeCode type() {
		if (__typeCode == null) {
			__typeCode = org.omg.CORBA.ORB.init().create_interface_tc(id(),
					"UserRegister");
		}
		return __typeCode;
	}

	public String id() {
		return _id;
	}

	public UserRegister read(org.omg.CORBA.portable.InputStream istream) {
		return narrow(istream.read_Object(_UserRegisterStub.class));
	}

	public void write(org.omg.CORBA.portable.OutputStream ostream,
			UserRegister value) {
		ostream.write_Object((org.omg.CORBA.Object) value);
	}

	public UserRegister narrow(org.omg.CORBA.Object obj) {
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

	public UserRegister unchecked_narrow(org.omg.CORBA.Object obj) {
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