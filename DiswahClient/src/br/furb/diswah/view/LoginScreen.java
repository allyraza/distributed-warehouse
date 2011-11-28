package br.furb.diswah.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.furb.diswah.exception.BusinessException;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.resource.MessageBundle;
import br.furb.diswah.service.LoginService;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class LoginScreen extends JFrame{
	
	private JTextField tfLogin;
	private JPasswordField pfPassword;
	
	private JButton btLogin;
	private JButton btCancel;

	public LoginScreen(){
		configFrame();
		createComponents();
	}

	/**
	 * 
	 */
	private void configFrame() {
		setLayout(new MigLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(407, 295));
		//setIconImage(new ImageIcon(getClass().getResource("/com/publica/shell/toolbar/logotipo32.png")).getImage());
        setResizable(false);
        setTitle(MessageBundle.getInstance().getMessage("frame.login.title"));
	}

	/**
	 * 
	 */
	private void createComponents() {
		// TODO Auto-generated method stub
		tfLogin = new JTextField();
		add(tfLogin);
		
		pfPassword = new JPasswordField();
		add(pfPassword);
		
		btLogin = new JButton();
		btLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					LoginService service = TransportFactory.createCommunication(null, TransportMethod.RMI).requestInterface(LoginService.class, new Object[]{});
					service.login(tfLogin.getText(), pfPassword.getText());
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		add(btLogin);
		
		btCancel = new JButton();
		add(btCancel);
	}
	
}