package br.furb.diswah.view;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import br.furb.diswah.resource.MessageBundle;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SystemFrame extends JFrame {
	
	/**
	 * 
	 */
	public SystemFrame(){
		configFrame();
		createComponents();
	}

	/**
	 * 
	 */
	private void configFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao carregar o look and feel.");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(MessageBundle.getMessage("frame.login.title"));
		setIconImage(new ImageIcon(ClassLoader.getSystemResource("warehouse.png")).getImage());

		setLayout(new MigLayout("insets 10","grow","grow"));
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	/**
	 * 
	 */
	private void createComponents() {
		// TODO Auto-generated method stub
		
	}

}