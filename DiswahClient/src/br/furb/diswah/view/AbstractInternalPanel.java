package br.furb.diswah.view;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.BorderUIResource.BevelBorderUIResource;

import net.miginfocom.swing.MigLayout;
import br.furb.diswah.model.BasicEntity;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class AbstractInternalPanel extends JPanel{

	private JPanel internalPanel;
	private JTable tbData;
	private DefaultTableModel tableModel;
	
	public AbstractInternalPanel(){
		configPanel();
		createComponents();
		setVisible(true);
	}
	
	protected abstract void createComponents();
	
	protected abstract String getMessagesProperty();

	protected abstract <T extends BasicEntity> Class<T> getEntityClass();
	
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
	
	protected void createTable(){
		tbData = new JTable(new DefaultTableModel(getEntityClass()));
		internalPanel.add(tbData,"span, align center, growy, growx");
	}
	
	protected void refreshData(List<? extends BasicEntity> data){
		tableModel.refresh(data);
	}
	
}