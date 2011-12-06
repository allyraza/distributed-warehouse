package br.furb.diswah.view;

import javax.swing.JTextField;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.model.SaleProduct;
import br.furb.diswah.register.SaleProductRegisterClient;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SalesProductsView extends AbstractInternalPanel<SaleProduct> {

	private JTextField id;
	private JTextField name;
	private JTextField address;
	
	/**
	 * 
	 */
	public SalesProductsView() {
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
	private void showData() {
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.sales.host"));
		BasicTransport bt = TransportFactory.createCommunication(properties, TransportMethod.RPC);
		try {
			SaleProductRegisterClient cr = bt.requestInterface(SaleProductRegisterClient.class, new Object[]{});
			refreshData(cr.list());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getMessagesProperty() {
		return "saleproduct";
	}

	@Override
	protected Class<SaleProduct> getEntityClass() {
		return SaleProduct.class;
	}

}