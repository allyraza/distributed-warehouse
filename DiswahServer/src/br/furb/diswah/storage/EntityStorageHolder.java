package br.furb.diswah.storage;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.Streamable;

import br.furb.diswah.storage.corba.EntityStorage;
import br.furb.diswah.storage.corba.EntityStorageHelper;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public final class EntityStorageHolder implements Streamable {
	
	public EntityStorage value = null;

	public EntityStorageHolder() {
	}

	public EntityStorageHolder(EntityStorage initialValue) {
		value = initialValue;
	}

	public void _read(InputStream i) {
		value = EntityStorageHelper.getInstance().read(i);
	}

	public void _write(OutputStream o) {
		EntityStorageHelper.getInstance().write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return EntityStorageHelper.getInstance().type();
	}

}