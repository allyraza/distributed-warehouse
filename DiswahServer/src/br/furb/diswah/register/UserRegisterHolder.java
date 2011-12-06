package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public final class UserRegisterHolder implements org.omg.CORBA.portable.Streamable {
	
	public UserRegister value = null;

	public UserRegisterHolder() {
	}

	public UserRegisterHolder(UserRegister initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = UserRegisterHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		UserRegisterHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return UserRegisterHelper.type();
	}

}