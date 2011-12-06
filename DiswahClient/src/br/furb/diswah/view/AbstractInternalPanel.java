package br.furb.diswah.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.BorderUIResource.BevelBorderUIResource;

import net.miginfocom.swing.MigLayout;
import br.furb.diswah.model.BasicEntity;
import br.furb.diswah.resource.MessageBundle;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class AbstractInternalPanel<T extends BasicEntity> extends JPanel implements ActionListener {

	private JPanel internalPanel;
	private JTable tbData;
	private DefaultTableModel tableModel;
	
	private JButton btSave;
	private JButton btClear;
	
	public AbstractInternalPanel(){
		configPanel();
		createComponents();
		createButtons();
		createTable();
		setVisible(true);
	}
	
	protected abstract void createComponents();
	
	protected abstract String getMessagesProperty();

	protected abstract Class<T> getEntityClass();
	
	/**
	 * 
	 */
	private void configPanel() {
		this.setLayout(new MigLayout("insets 30","grow","grow"));
		internalPanel = new JPanel(new MigLayout("debug, insets 15","grow","grow"));
		internalPanel.setBorder(BorderFactory.createBevelBorder(BevelBorderUIResource.LOWERED));
		add(internalPanel,"grow");
	}
	
	protected void addComponent(JComponent component, String constraints, String label){
		internalPanel.add(new JLabel("panel.label."+getMessagesProperty()+"."+label),"align right, shrink");
		internalPanel.add(component,constraints);
	}
	
	private void createButtons(){
		btSave = new JButton(MessageBundle.getMessage("panel.button.save"));
		internalPanel.add(btSave,"align left");
		
		btClear = new JButton(MessageBundle.getMessage("panel.button.clear"));
		internalPanel.add(btSave,"align right, wrap");
	}
	
	protected void createTable(){
		tbData = new JTable(new DefaultTableModel(getEntityClass()));
		tableModel = new DefaultTableModel(getEntityClass());
		tbData.setModel(tableModel);
		JScrollPane jsp = new JScrollPane(tbData);
		internalPanel.add(jsp,"span, align center, growy, growx");
	}
	
	protected void refreshData(List<T> data){
		tableModel.refresh(data);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btSave) {
			save();
		} else if(event.getSource() == btClear){
			save();
		}
	}

	/**
	 * 
	 */
	protected abstract void save();

	/**
	 * 
	 */
	protected abstract void clear();
	
}