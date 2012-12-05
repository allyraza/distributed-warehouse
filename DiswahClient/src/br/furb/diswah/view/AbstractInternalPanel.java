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
import javax.swing.JTextArea;
import javax.swing.plaf.BorderUIResource.BevelBorderUIResource;

import net.miginfocom.swing.MigLayout;
import br.furb.diswah.model.BasicEntity;
import br.furb.diswah.resource.MessageBundle;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 * @param <T> 
 */
public abstract class AbstractInternalPanel<T extends BasicEntity> extends JPanel implements ActionListener {

	private JPanel internalPanel;
	private JTextArea areaImpressao;
	
	private JButton btSave;
	private JButton btClear;
	
	/**
	 * 
	 */
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
		internalPanel = new JPanel(new MigLayout("insets 15","grow","grow"));
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
		btSave.addActionListener(this);
		
		btClear = new JButton(MessageBundle.getMessage("panel.button.clear"));
		internalPanel.add(btClear,"align right, wrap");
		btClear.addActionListener(this);
	}
	
	protected void createTable(){
		
		areaImpressao = new JTextArea();
		JScrollPane jsp = new JScrollPane(areaImpressao);
		internalPanel.add(jsp,"span, align center, growy, growx");
	}
	
	protected void refreshData(List<T> data){
		
		for (T t : data) {
			areaImpressao.append(t.toString()+"\n");
		}
		
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