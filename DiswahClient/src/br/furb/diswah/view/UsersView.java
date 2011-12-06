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
@SuppressWarnings("unchecked")
public class UsersView extends AbstractInternalPanel<User>  {

	private JTextField id;
	private JTextField login;
	private JTextField password;
	private JTextField email;
	
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
		
		login = new JTextField();
		addComponent(login, "growx, wrap", "address");
		
		password = new JTextField();
		addComponent(password, "growx, wrap", "name");

		email = new JTextField();
		addComponent(email, "growx, wrap", "address");
	}

	/**
	 * 
	 */
	private void showData() {
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.corba.host"));
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

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	protected void save() {
		User user = new User();
		user.setLogin(login.getText());
		user.setPassword(password.getText());
		user.setEmail(email.getText());
		
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.corba.host"));
		BasicTransport bt = TransportFactory.createCommunication(properties, TransportMethod.CORBA);
		try {
			UserRegister cr = bt.requestInterface(UserRegister.class, new Object[]{UserRegisterHelper.class});
			cr.save(Utils.serializeObject(user));
			refreshData(Utils.deserializeObject(List.class, cr.list()));
			clear();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void clear() {
		id.setText("");
		login.setText("");
		password.setText("");
		email.setText("");
	}

}