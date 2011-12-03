package br.furb.diswah.main;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import br.furb.diswah.storage.EntityStorageImpl;
import br.furb.diswah.storage.corba.EntityStorage;
import br.furb.diswah.storage.corba.EntityStorageHelper;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MainServer {

	private static EntityStorageImpl ENTITY_STORAGE;
	
	public static void main(String[] args) throws Throwable {
		ORB orb = ORB.init(new String[]{"–ORBInitialPort", "2000"}, null);

		ENTITY_STORAGE = new EntityStorageImpl();

		// Ativa o POA
		POA rootpoa = POAHelper.narrow(orb .resolve_initial_references("RootPOA"));
		rootpoa.the_POAManager().activate();

		// Pega a referência do servidor
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(ENTITY_STORAGE);
		EntityStorage href = EntityStorageHelper.getInstance().narrow(ref);

		// Obtém uma referência para o servidor de nomes
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt namecontextRef = NamingContextExtHelper.narrow(objRef);

		// Registra o servidor no servico de nomes
		NameComponent path[] = namecontextRef.to_name(EntityStorage.class.getSimpleName());
		namecontextRef.rebind(path, href);

		System.out.println("Servidor aguardando requisicoes ....");
	}
	
}