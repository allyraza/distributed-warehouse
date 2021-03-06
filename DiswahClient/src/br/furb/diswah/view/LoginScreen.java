package br.furb.diswah.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import br.furb.diswah.resource.MessageBundle;

/**
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
public class LoginScreen extends JFrame{
	
	private JPanel pnPrincipal;
	
	private JLabel lbLogo;
	
	private JLabel lbLogin;
	private JTextField tfLogin;
	
	private JLabel lbPassword;
	private JPasswordField pfPassword;
	
	private JButton btLogin;
	private JButton btCancel;

	/**
	 * 
	 */
	public LoginScreen(){
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
		setMinimumSize(new Dimension(300, 300));
        setResizable(false);
        
        setLocationRelativeTo(null);
	}
	
	/**
	 * 
	 */
	private void createComponents() {
		pnPrincipal = new JPanel(new MigLayout("insets 10","[align right, 50::][grow]","grow"));
		
		pnPrincipal.add(createLogo(),"span, align center, wrap");
		
		lbLogin = new JLabel(MessageBundle.getMessage("frame.login.label.login"));
		pnPrincipal.add(lbLogin);
		tfLogin = new JTextField();
		pnPrincipal.add(tfLogin, "w 180,wrap");
		
		lbPassword = new JLabel(MessageBundle.getMessage("frame.login.label.password"));
		pnPrincipal.add(lbPassword);
		pfPassword = new JPasswordField();
		pnPrincipal.add(pfPassword, "w 180,wrap");

		pnPrincipal.add(createButtons(),"span, align center");
		
		this.add(pnPrincipal,"grow");
	}
	
	/**
	 * @return
	 */
	private Component createLogo() {
		JPanel pnLogo = new JPanel(new MigLayout("","grow","grow"));
		
		lbLogo = new JLabel(new ImageIcon(ClassLoader.getSystemResource("warehouse.png")));
		pnLogo.add(lbLogo);
		
		return pnLogo;
	}

	/**
	 * 
	 */
	private JPanel createButtons() {
		JPanel pnButtons = new JPanel(new MigLayout("","[align right]10[align left]","grow"));
		
		btLogin = new JButton(MessageBundle.getMessage("frame.login.button.login"));
		btLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TransportProperties prop = new TransportProperties();
				//prop.setHost(PropertiesBundle.getProperty("server.rmi.host"));
				try {
					//LoginService service = TransportFactory.createCommunication(prop, TransportMethod.RMI)
					//									   .requestInterface(LoginService.class, new Object[]{});
					//User user = service.login(tfLogin.getText(), pfPassword.getText());
					
					//UserSession.getInstance().initSession(user);
					
					EventQueue.invokeLater(new Runnable() {
						@Override
						public void run() {
							new SystemFrame().setVisible(true);
						}
					});
					setVisible(false);
				} catch (Throwable e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(LoginScreen.this, 
												  e.getCause().getMessage(),
												  MessageBundle.getMessage("modal.title.error"),
												  JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pnButtons.add(btLogin);
		
		btCancel = new JButton(MessageBundle.getMessage("frame.login.button.cancel"));
		btCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		pnButtons.add(btCancel);
		
		return pnButtons;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LoginScreen().setVisible(true);
	}
	
}