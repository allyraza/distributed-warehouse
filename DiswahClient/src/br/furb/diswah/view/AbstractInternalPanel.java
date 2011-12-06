package br.furb.diswah.view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class AbstractInternalPanel extends JPanel{

	private JPanel internalPanel;
	
	public AbstractInternalPanel(){
		configPanel();
		createComponents();
		setVisible(true);
	}
	
	protected abstract void createComponents();
	
	public abstract Dimension getSize();
	
	protected abstract String getMessagesProperty();
	
	/**
	 * 
	 */
	private void configPanel() {
		this.setLayout(new MigLayout("insets 30","grow","grow"));
		this.setMinimumSize(getSize());
		this.setPreferredSize(getSize());
		this.setMaximumSize(getSize());

		internalPanel = new JPanel(new MigLayout("insets 15","grow","grow"));
		internalPanel.setBorder(BorderFactory.createEtchedBorder(3));
		
		add(internalPanel);
	}
	
	public void addComponent(JComponent component, String constraints, String label){
		internalPanel.add(new JLabel(label),"");
		internalPanel.add(component,constraints);
	}
	
}