package br.furb.diswah.view;

import java.util.List;

import javax.swing.JTextField;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.model.Classification;
import br.furb.diswah.register.ClassificationRegister;
import br.furb.diswah.register.ClassificationRegisterHelper;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;
import br.furb.diswah.util.Utils;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClassificationView extends AbstractInternalPanel<Classification> {

	private JTextField id;
	private JTextField code;
	private JTextField name;
	private JTextField description;
	
	/**
	 * 
	 */
	public ClassificationView() {
		super();
		showData();
	}

	@Override
	protected void createComponents() {
		id = new JTextField();
		id.setEditable(false);
		id.setFocusable(false);
		addComponent(id, "growx, wrap", "id");
		
		code = new JTextField();
		addComponent(code, "growx, wrap", "name");
		
		name = new JTextField();
		addComponent(name, "growx, wrap", "name");
		
		description = new JTextField();
		addComponent(description, "growx, wrap", "address");
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void showData() {
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.corba.host"));
		BasicTransport bt = TransportFactory.createCommunication(properties, TransportMethod.CORBA);
		try {
			ClassificationRegister cr = bt.requestInterface(ClassificationRegister.class, new Object[]{ClassificationRegisterHelper.getInstance()});
			refreshData(Utils.deserializeObject(List.class, cr.list()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getMessagesProperty() {
		return "classification";
	}

	@Override
	protected Class<Classification> getEntityClass() {
		return Classification.class;
	}

	@Override
	protected void save() {
		Classification classification = new Classification();
		classification.setCode(Long.valueOf(code.getText()));
		classification.setName(name.getText());
		classification.setDescription(description.getText());
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.corba.host"));
		BasicTransport bt = TransportFactory.createCommunication(properties, TransportMethod.CORBA);
		try {
			ClassificationRegister cr = bt.requestInterface(ClassificationRegister.class, new Object[]{ClassificationRegisterHelper.getInstance()});
			cr.save(Utils.serializeObject(classification));
			refreshData(Utils.deserializeObject(List.class, cr.list()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void clear() {
		id.setText("");
		code.setText("");
		name.setText("");
		description.setText("");
	}
	
}