package br.furb.diswah.view;

import javax.swing.JTextField;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.model.Sale;
import br.furb.diswah.register.SaleRegisterClient;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SalesView extends AbstractInternalPanel<Sale> {
	
	private JTextField id;
	private JTextField name;
	private JTextField address;
	
	/**
	 * 
	 */
	public SalesView() {
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
			SaleRegisterClient cr = bt.requestInterface(SaleRegisterClient.class, new Object[]{});
			refreshData(cr.list());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getMessagesProperty() {
		return "sale";
	}

	/* (non-Javadoc)
	 * @see br.furb.diswah.view.AbstractInternalPanel#getEntityClass()
	 */
	@Override
	protected Class<Sale> getEntityClass() {
		return Sale.class;
	}
	
}