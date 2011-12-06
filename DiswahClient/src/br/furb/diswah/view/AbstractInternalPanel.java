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
		this.setLayout(new MigLayout("insets 10","grow","grow"));
		this.setMinimumSize(getSize());
		this.setPreferredSize(getSize());
		this.setMaximumSize(getSize());
		this.setBorder(BorderFactory.createEtchedBorder());
	}
	
	public void addComponent(JComponent component, String constraints, String label){
		this.add(new JLabel(label),"");
		this.add(component,constraints);
	}
	
}