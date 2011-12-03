package br.furb.diswah.storage;

import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.CompletionStatus;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.PortableServer.Servant;

import br.furb.diswah.storage.corba.EntityStorage;
import br.furb.diswah.storage.corba.EntityStorageHelper;
import br.furb.diswah.storage.corba.EntityStorageOperations;


/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class EntityStoragePOA extends Servant implements EntityStorageOperations, InvokeHandler {

	private static java.util.Hashtable _methods = new java.util.Hashtable();
	static {
		_methods.put("save", new Integer(0));
		_methods.put("find", new Integer(1));
		_methods.put("delete", new Integer(2));
		_methods.put("list", new Integer(3));
	}

	public OutputStream _invoke(String $method, InputStream in, ResponseHandler $rh) {
		OutputStream out = null;
		Integer __method = (Integer) _methods.get($method);
		if (__method == null)
			throw new BAD_OPERATION(0, CompletionStatus.COMPLETED_MAYBE);

		switch (__method.intValue()) {
		case 0: // storage/EntityStorage/save
		{
			String p1 = in.read_string();
			String $result = null;
			$result = this.save(p1);
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		case 1: // storage/EntityStorage/find
		{
			int p1 = in.read_long();
			String $result = null;
			$result = this.find(p1);
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		case 2: // storage/EntityStorage/delete
		{
			int p1 = in.read_long();
			String $result = null;
			$result = this.delete(p1);
			out = $rh.createReply();
			out.write_string($result);
			break;
		}

		case 3: // storage/EntityStorage/list
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
	private static String[] __ids = { "IDL:storage/EntityStorage:1.0" };

	public String[] _all_interfaces(org.omg.PortableServer.POA poa,
			byte[] objectId) {
		return (String[]) __ids.clone();
	}

	public EntityStorage _this() {
		return EntityStorageHelper.getInstance().narrow(super._this_object());
	}

	public EntityStorage _this(org.omg.CORBA.ORB orb) {
		return EntityStorageHelper.getInstance().narrow(super._this_object(orb));
	}

} // class EntityStoragePOA
