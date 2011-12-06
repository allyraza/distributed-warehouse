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
	private JTextField sale;
	private JTextField product;
	
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
		
		sale = new JTextField();
		addComponent(sale, "growx, wrap", "name");
		
		product = new JTextField();
		addComponent(product, "growx, wrap", "address");
	}

	/**
	 * 
	 */
	private void showData() {
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.rpc.host"));
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

	@Override
	protected void save() {
		SaleProduct saleProduct = new SaleProduct();
		saleProduct.setProduct(Long.valueOf(product.getText()));
		saleProduct.setSale(Long.valueOf(sale.getText()));
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.rpc.host"));
		BasicTransport bt = TransportFactory.createCommunication(properties, TransportMethod.RPC);
		try {
			SaleProductRegisterClient cr = bt.requestInterface(SaleProductRegisterClient.class, new Object[]{});
			cr.save(saleProduct);
			refreshData(cr.list());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void clear() {
		id.setText("");
		sale.setText("");
		product.setText("");
	}

}