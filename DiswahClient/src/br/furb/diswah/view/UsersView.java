package br.furb.diswah.view;

import java.util.List;

import javax.swing.JTextField;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.model.User;
import br.furb.diswah.register.UserRegister;
import br.furb.diswah.register.UserRegisterHelper;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;
import br.furb.diswah.util.Utils;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class UsersView extends AbstractInternalPanel<User>  {

	private JTextField id;
	private JTextField name;
	private JTextField address;
	
	/**
	 * 
	 */
	public UsersView() {
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
			UserRegister cr = bt.requestInterface(UserRegister.class, new Object[]{UserRegisterHelper.class});
			refreshData(Utils.deserializeObject(List.class, cr.list()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getMessagesProperty() {
		return "user";
	}

	/* (non-Javadoc)
	 * @see br.furb.diswah.view.AbstractInternalPanel#getEntityClass()
	 */
	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}