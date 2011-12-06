package br.furb.diswah.main;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import br.furb.diswah.register.ClassificationRegister;
import br.furb.diswah.register.ClassificationRegisterHelper;
import br.furb.diswah.register.ClassificationRegisterImpl;
import br.furb.diswah.register.ProductRegister;
import br.furb.diswah.register.ProductRegisterHelper;
import br.furb.diswah.register.ProductRegisterImpl;
import br.furb.diswah.register.UserRegister;
import br.furb.diswah.register.UserRegisterHelper;
import br.furb.diswah.register.UserRegisterImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MainServer {

	private static ClassificationRegisterImpl CLASSIFICATION_REGISTER;
	private static ProductRegisterImpl PRODUCT_REGISTER;
	private static UserRegisterImpl USER_REGISTER;
	
	public static void main(String[] args) throws Throwable {
		ORB orb = ORB.init(new String[]{"–ORBInitialPort", "2000"}, null);

		CLASSIFICATION_REGISTER = new ClassificationRegisterImpl();
		PRODUCT_REGISTER = new ProductRegisterImpl();
		USER_REGISTER = new UserRegisterImpl();

		// Ativa o POA
		POA rootpoa = POAHelper.narrow(orb .resolve_initial_references("RootPOA"));
		rootpoa.the_POAManager().activate();

		// Pega a referência do servidor
		org.omg.CORBA.Object refClass = rootpoa.servant_to_reference(CLASSIFICATION_REGISTER);
		ClassificationRegister hrefClass = ClassificationRegisterHelper.getInstance().narrow(refClass);

		org.omg.CORBA.Object refProd = rootpoa.servant_to_reference(PRODUCT_REGISTER);
		ProductRegister hrefProd = ProductRegisterHelper.getInstance().narrow(refProd);
		
		org.omg.CORBA.Object refUser = rootpoa.servant_to_reference(USER_REGISTER);
		UserRegister hrefUser = UserRegisterHelper.getInstance().narrow(refUser);
		
		// Obtém uma referência para o servidor de nomes
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt namecontextRef = NamingContextExtHelper.narrow(objRef);

		// Registra o servidor no servico de nomes
		NameComponent pathClass[] = namecontextRef.to_name(ClassificationRegister.class.getSimpleName());
		namecontextRef.rebind(pathClass, hrefClass);
		
		NameComponent pathProd[] = namecontextRef.to_name(ProductRegister.class.getSimpleName());
		namecontextRef.rebind(pathProd, hrefProd);
		
		NameComponent pathUser[] = namecontextRef.to_name(UserRegister.class.getSimpleName());
		namecontextRef.rebind(pathUser, hrefUser);

		System.out.println("Servidor aguardando requisicoes ....");
		
		orb.run();
	}
	
}