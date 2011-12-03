package br.furb.diswah.storage.corba;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.Delegate;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.ObjectImpl;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;


/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class _EntityStorageStub extends ObjectImpl implements EntityStorage {

	public String save(String p1) {
		InputStream $in = null;
		try {
			OutputStream $out = _request("save", true);
			$out.write_string(p1);
			$in = _invoke($out);
			String $result = $in.read_string();
			return $result;
		} catch (ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (RemarshalException $rm) {
			return save(p1);
		} finally {
			_releaseReply($in);
		}
	}

	public String find(int p1) {
		InputStream $in = null;
		try {
			OutputStream $out = _request("find", true);
			$out.write_long(p1);
			$in = _invoke($out);
			String $result = $in.read_string();
			return $result;
		} catch (ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (RemarshalException $rm) {
			return find(p1);
		} finally {
			_releaseReply($in);
		}
	}

	public String delete(int p1) {
		InputStream $in = null;
		try {
			OutputStream $out = _request("delete", true);
			$out.write_long(p1);
			$in = _invoke($out);
			String $result = $in.read_string();
			return $result;
		} catch (ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (RemarshalException $rm) {
			return delete(p1);
		} finally {
			_releaseReply($in);
		}
	}

	public String list() {
		InputStream $in = null;
		try {
			OutputStream $out = _request("list", true);
			$in = _invoke($out);
			String $result = $in.read_string();
			return $result;
		} catch (ApplicationException $ex) {
			$in = $ex.getInputStream();
			String _id = $ex.getId();
			throw new org.omg.CORBA.MARSHAL(_id);
		} catch (RemarshalException $rm) {
			return list();
		} finally {
			_releaseReply($in);
		}
	}

	private static String[] __ids = { "IDL:storage/EntityStorage:1.0" };

	public String[] _ids() {
		return (String[]) __ids.clone();
	}

	private void readObject(ObjectInputStream s) throws IOException {
		String str = s.readUTF();
		String[] args = null;
		java.util.Properties props = null;
		ORB orb = ORB.init(args, props);
		try {
			org.omg.CORBA.Object obj = orb.string_to_object(str);
			Delegate delegate = ((ObjectImpl) obj)._get_delegate();
			_set_delegate(delegate);
		} finally {
			orb.destroy();
		}
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		String[] args = null;
		java.util.Properties props = null;
		ORB orb = ORB.init(args, props);
		try {
			String str = orb.object_to_string(this);
			s.writeUTF(str);
		} finally {
			orb.destroy();
		}
	}

}