package br.furb.diswah.register;

/**
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
public final class ClassificationRegisterHolder implements org.omg.CORBA.portable.Streamable {
	
	/**
	 * 
	 */
	public ClassificationRegister value = null;

	/**
	 * 
	 */
	public ClassificationRegisterHolder() {
	}

	/**
	 * @param initialValue
	 */
	public ClassificationRegisterHolder(ClassificationRegister initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = ClassificationRegisterHelper.getInstance().read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		ClassificationRegisterHelper.getInstance().write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return ClassificationRegisterHelper.getInstance().type();
	}

}