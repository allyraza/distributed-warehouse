package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ProductRegisterHelper {
	
	private static String _id = "IDL:register/ProductRegister:1.0";

	private static org.omg.CORBA.TypeCode __typeCode = null;
	
	private static ProductRegisterHelper instance;
	
	public static ProductRegisterHelper getInstance(){
		if(instance == null)
			instance = new ProductRegisterHelper();
		
		return instance;
	}
	
	public void insert(org.omg.CORBA.Any a, ProductRegister that) {
		org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
		a.type(type());
		write(out, that);
		a.read_value(out.create_input_stream(), type());
	}

	public ProductRegister extract(org.omg.CORBA.Any a) {
		return read(a.create_input_stream());
	}

	synchronized public org.omg.CORBA.TypeCode type() {
		if (__typeCode == null) {
			__typeCode = org.omg.CORBA.ORB.init().create_interface_tc(id(), "ProductRegister");
		}
		return __typeCode;
	}

	public String id() {
		return _id;
	}

	public ProductRegister read(
			org.omg.CORBA.portable.InputStream istream) {
		return narrow(istream.read_Object(_ProductRegisterStub.class));
	}

	public void write(org.omg.CORBA.portable.OutputStream ostream,
			ProductRegister value) {
		ostream.write_Object((org.omg.CORBA.Object) value);
	}

	public ProductRegister narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof ProductRegister)
			return (ProductRegister) obj;
		else if (!obj._is_a(id()))
			throw new org.omg.CORBA.BAD_PARAM();
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			_ProductRegisterStub stub = new _ProductRegisterStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

	public ProductRegister unchecked_narrow(org.omg.CORBA.Object obj) {
		if (obj == null)
			return null;
		else if (obj instanceof ProductRegister)
			return (ProductRegister) obj;
		else {
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			_ProductRegisterStub stub = new _ProductRegisterStub();
			stub._set_delegate(delegate);
			return stub;
		}
	}

}