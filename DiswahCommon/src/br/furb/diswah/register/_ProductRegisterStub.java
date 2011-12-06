package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class _ProductRegisterStub extends org.omg.CORBA.portable.ObjectImpl implements ProductRegister {

	public String save(String p1) {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request("save", true);
			$out.write_string(p1);
			$in = _invoke($out);
			String $result = $in.read_string();
			return $result;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			return save(p1);
		} finally {
			_releaseReply($in);
		}
	} // save

	public String find(int p1) {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request("find", true);
			$out.write_long(p1);
			$in = _invoke($out);
			String $result = $in.read_string();
			return $result;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			return find(p1);
		} finally {
			_releaseReply($in);
		}
	} // find

	public String list() {
		org.omg.CORBA.portable.InputStream $in = null;
		try {
			org.omg.CORBA.portable.OutputStream $out = _request("list", true);
			$in = _invoke($out);
			String $result = $in.read_string();
			return $result;
		} catch (org.omg.CORBA.portable.ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (org.omg.CORBA.portable.RemarshalException $rm) {
			return list();
		} finally {
			_releaseReply($in);
		}
	} // list

	// Type-specific CORBA::Object operations
	private static String[] __ids = { "IDL:register/ProductRegister:1.0" };

	public String[] _ids() {
		return (String[]) __ids.clone();
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException {
		String str = s.readUTF();
		String[] args = null;
		java.util.Properties props = null;
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
		try {
			org.omg.CORBA.Object obj = orb.string_to_object(str);
			org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)
					._get_delegate();
			_set_delegate(delegate);
		} finally {
			orb.destroy();
		}
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		String[] args = null;
		java.util.Properties props = null;
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
		try {
			String str = orb.object_to_string(this);
			s.writeUTF(str);
		} finally {
			orb.destroy();
		}
	}

}