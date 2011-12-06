package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class ClassificationRegisterHelper {
	private static String _id = "IDL:register/ClassificationRegister:1.0";

	public static void insert(org.omg.CORBA.Any a, ClassificationRegister that) {
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public static ClassificationRegister extract(org.omg.CORBA.Any a) {
		return read(a.create_input_stream());
	}

	private static org.omg.CORBA.TypeCode __typeCode = null;

	synchronized public static org.omg.CORBA.TypeCode type() {
		if (__typeCode == null) {
			__typeCode = org.omg.CORBA.ORB.init()
					.create_interface_tc(ClassificationRegisterHelper.id(),
							"ClassificationRegister");
		}
		return __typeCode;
	}

	public static String id() {
		return _id;
	}

	public static ClassificationRegister read(
			org.omg.CORBA.portable.InputStream istream) {
		return narrow(istream.read_Object(_ClassificationRegisterStub.class));
	}

	public static void write(org.omg.CORBA.portable.OutputStream ostream,
			ClassificationRegister value) {
		ostream.write_Object((org.omg.CORBA.Object) value);
	}

	public static ClassificationRegister narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof ClassificationRegister)
			return (ClassificationRegister) obj;
		else if (!obj._is_a(id()))
			throw new org.omg.CORBA.BAD_PARAM();
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			_ClassificationRegisterStub stub = new _ClassificationRegisterStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

	public static ClassificationRegister unchecked_narrow(
			org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof ClassificationRegister)
			return (ClassificationRegister) obj;
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			_ClassificationRegisterStub stub = new _ClassificationRegisterStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}