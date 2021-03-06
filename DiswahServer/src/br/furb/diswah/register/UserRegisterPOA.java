package br.furb.diswah.register;

/**
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class UserRegisterPOA extends org.omg.PortableServer.Servant implements UserRegisterOperations, org.omg.CORBA.portable.InvokeHandler {

	private static java.util.Hashtable _methods = new java.util.Hashtable();
	
	static {
		_methods.put("save", new java.lang.Integer(0));
		_methods.put("find", new java.lang.Integer(1));
		_methods.put("list", new java.lang.Integer(2));
	}

	public org.omg.CORBA.portable.OutputStream _invoke(String $method,
			org.omg.CORBA.portable.InputStream in,
			org.omg.CORBA.portable.ResponseHandler $rh) {
		org.omg.CORBA.portable.OutputStream out = null;
		java.lang.Integer __method = (java.lang.Integer) _methods.get($method);
		if (__method == null)
			throw new org.omg.CORBA.BAD_OPERATION(0,
					org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

		switch (__method.intValue()) {
		case 0: // register/UserRegister/save
		{
			String p1 = in.read_string();
			String $result = null;
			$result = this.save(p1);
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		case 1: // register/UserRegister/find
		{
			int p1 = in.read_long();
			String $result = null;
			$result = this.find(p1);
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		case 2: // register/UserRegister/list
		{
			String $result = null;
			$result = this.list();
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		default:
			throw new org.omg.CORBA.BAD_OPERATION(0,
					org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
		}

		return out;
	} // _invoke

	// Type-specific CORBA::Object operations
	private static String[] __ids = { "IDL:register/UserRegister:1.0" };

	public String[] _all_interfaces(org.omg.PortableServer.POA poa,
			byte[] objectId) {
		return (String[]) __ids.clone();
	}

	/**
	 * @return register
	 */
	public UserRegister _this() {
		return UserRegisterHelper.getInstance().narrow(super._this_object());
	}

	/**
	 * @param orb
	 * @return register
	 */
	public UserRegister _this(org.omg.CORBA.ORB orb) {
		return UserRegisterHelper.getInstance().narrow(super._this_object(orb));
	}

}