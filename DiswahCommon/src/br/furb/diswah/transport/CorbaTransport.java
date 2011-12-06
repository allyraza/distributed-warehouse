package br.furb.diswah.transport;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import br.furb.diswah.exception.CommunicationException;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class CorbaTransport extends BasicTransport {

	CorbaTransport(TransportProperties properties) {
		super(properties);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T requestInterface(Class<T> target, Object[] params) throws CommunicationException {
		try {
			if(params == null || params.length == 0 || params[0] == null || !(params[0] instanceof Helper))
				throw new Exception("Classe Helper não informada.");
			
			ORB orb = ORB.init(new String[] {"–ORBInitialPort", "2000", "–ORBInitialHost", getProperties().getHost()}, null);
			NamingContextExt namecontextRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
			return ((Helper<T>) params[0]).narrow(namecontextRef.resolve_str(target.getSimpleName()));
		} catch (Exception e) {
			throw new CommunicationException(String.format("Ocorreu um erro ao instanciar a classe '%s'", target.getSimpleName()) ,e);
		}
	}

}