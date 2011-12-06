package br.furb.diswah.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.BorderUIResource.BevelBorderUIResource;

import com.sun.java.swing.plaf.motif.MotifBorders.BevelBorder;

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
	
	protected abstract String getMessagesProperty();
	
	/**
	 * 
	 */
	private void configPanel() {
		this.setLayout(new MigLayout("insets 30","grow","grow"));
		internalPanel = new JPanel(new MigLayout("debug, insets 15","grow","grow"));
		internalPanel.setBorder(BorderFactory.createBevelBorder(BevelBorderUIResource.LOWERED));
		add(internalPanel,"grow");
	}
	
	public void addComponent(JComponent component, String constraints, String label){
		internalPanel.add(new JLabel(label),"");
		internalPanel.add(component,constraints);
	}
	
}