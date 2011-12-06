package br.furb.diswah.view;

import java.util.List;

import javax.swing.JTextField;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.model.Product;
import br.furb.diswah.register.ProductRegister;
import br.furb.diswah.register.ProductRegisterHelper;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;
import br.furb.diswah.util.Utils;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ProductsView extends AbstractInternalPanel<Product> {

	private JTextField id;
	private JTextField name;
	private JTextField address;
	
	/**
	 * 
	 */
	public ProductsView() {
		super();
		showData();
	}

	@Override
	protected void createComponents() {
		id = new JTextField();
		id.setEditable(false);
		id.setFocusable(false);
		addComponent(id, "growx, wrap", "id");
		
		name = new JTextField();
		addComponent(name, "growx, wrap", "name");
		
		address = new JTextField();
		addComponent(address, "growx, wrap", "address");
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void showData() {
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.sales.host"));
		BasicTransport bt = TransportFactory.createCommunication(properties, TransportMethod.CORBA);
		try {
			ProductRegister cr = bt.requestInterface(ProductRegister.class, new Object[]{ProductRegisterHelper.class});
			refreshData(Utils.deserializeObject(List.class, cr.list()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getMessagesProperty() {
		return "product";
	}

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}
	
}