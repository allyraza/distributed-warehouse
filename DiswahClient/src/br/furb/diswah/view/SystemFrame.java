package br.furb.diswah.view;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		setTitle(MessageBundle.getMessage("frame.system.title"));
		setIconImage(new ImageIcon(ClassLoader.getSystemResource("warehouse.png")).getImage());

		setLayout(new MigLayout("insets 10","grow","grow"));
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	/**
	 * 
	 */
	private void createComponents() {
		createMenu();
	}

	/**
	 * 
	 */
	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu registerMenu = new JMenu(MessageBundle.getMessage("frame.menubar.register"));
			JMenuItem classificationMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.classification"));
			registerMenu.add(classificationMenuItem);
			
			JMenuItem productMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.product"));
			registerMenu.add(productMenuItem);
			
			JMenuItem userMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.user"));
			registerMenu.add(userMenuItem);
			
			JMenuItem clientMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.client"));
			registerMenu.add(clientMenuItem);
			
		menuBar.add(registerMenu);

		JMenu saleMenu = new JMenu(MessageBundle.getMessage("frame.menubar.sale"));
		menuBar.add(saleMenu);
		
		JMenu reportMenu = new JMenu(MessageBundle.getMessage("frame.menubar.report"));
		menuBar.add(reportMenu);
		
		JMenu logoutMenu = new JMenu(MessageBundle.getMessage("frame.menubar.logout"));
		menuBar.add(logoutMenu);
		
		setJMenuBar(menuBar);
	}

}