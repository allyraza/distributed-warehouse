package br.furb.diswah.register;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public final class ProductRegisterHolder implements org.omg.CORBA.portable.Streamable {
	
	public ProductRegister value = null;

	public ProductRegisterHolder() {
	}

	public ProductRegisterHolder(ProductRegister initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = ProductRegisterHelper.getInstance().read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		ProductRegisterHelper.getInstance().write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return ProductRegisterHelper.getInstance().type();
	}

}