package br.furb.diswah.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import br.furb.diswah.UserSession;
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
		setMinimumSize(new Dimension(500,600));
		setMaximumSize(new Dimension(500,600));
		setPreferredSize(new Dimension(500,600));
		//setResizable(false);
		
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
			
			// Classificação
			JMenuItem classificationMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.classification"));
			classificationMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(new ClassificationView());
				}
			});
			registerMenu.add(classificationMenuItem);
			
			// Produto
			JMenuItem productMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.product"));
			productMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(new ProductsView());
				}
			});
			registerMenu.add(productMenuItem);
			
			// Usuário
			JMenuItem userMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.user"));
			userMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(new UsersView());
				}
			});
			registerMenu.add(userMenuItem);
			
			// Cliente
			JMenuItem clientMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.client"));
			clientMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(new ClientsView());
				}
			});
			registerMenu.add(clientMenuItem);
			
		menuBar.add(registerMenu);

		JMenu saleMenu = new JMenu(MessageBundle.getMessage("frame.menubar.sale"));
		menuBar.add(saleMenu);
		
			// Venda
			JMenuItem saleMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.sale"));
			saleMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(new SalesView());
				}
			});
			saleMenu.add(saleMenuItem);
		
			// Itens de Venda
			JMenuItem saleProductMenuItem = new JMenuItem(MessageBundle.getMessage("frame.menu.saleproduct"));
			saleProductMenuItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setContentPane(new SalesProductsView());
				}
			});
			saleMenu.add(saleProductMenuItem);
			
		JMenuItem logoutMenu = new JMenuItem(MessageBundle.getMessage("frame.menubar.logout"));
		logoutMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserSession.getInstance().destroySession();
				
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						new LoginScreen().setVisible(true);
					}
				});
				SystemFrame.this.dispose();
			}
		});
		menuBar.add(logoutMenu);
		
		setJMenuBar(menuBar);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SystemFrame().setVisible(true);
	}

}