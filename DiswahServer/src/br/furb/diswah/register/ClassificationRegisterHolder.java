package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public final class ClassificationRegisterHolder implements org.omg.CORBA.portable.Streamable {
	
	public ClassificationRegister value = null;

	public ClassificationRegisterHolder() {
	}

	public ClassificationRegisterHolder(ClassificationRegister initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = ClassificationRegisterHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		ClassificationRegisterHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return ClassificationRegisterHelper.type();
	}

}