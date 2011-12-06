package br.furb.diswah.view;

import javax.swing.JTextField;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.model.Client;
import br.furb.diswah.register.ClientRegisterClient;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClientsView extends AbstractInternalPanel<Client>{
	
	private JTextField id;
	private JTextField name;
	private JTextField address;
	
	/**
	 * 
	 */
	public ClientsView() {
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
		properties.setHost(PropertiesBundle.getProperty("server.rpc.host"));
		BasicTransport bt = TransportFactory.createCommunication(properties, TransportMethod.RPC);
		try {
			ClientRegisterClient cr = bt.requestInterface(ClientRegisterClient.class, new Object[]{});
			refreshData(cr.list());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getMessagesProperty() {
		return "client";
	}

	@Override
	protected Class<Client> getEntityClass() {
		return Client.class;
	}

	@Override
	protected void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void clear() {
		id.setText("");
		name.setText("");
		address.setText("");
	}

}