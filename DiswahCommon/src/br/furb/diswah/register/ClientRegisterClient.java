package br.furb.diswah.register;

import java.util.List;

import netbula.ORPC.ClientGeneric;
import netbula.ORPC.XDTLong;
import netbula.ORPC.XDTString;
import netbula.ORPC.XDTvoid;
import netbula.ORPC.rpc_err;
import br.furb.diswah.model.Client;
import br.furb.diswah.util.Utils;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClientRegisterClient extends ClientGeneric implements ClientRegister{

	/**
	 * @throws rpc_err
	 */
	public ClientRegisterClient() throws rpc_err { };

	/**
	 * @param host
	 * @param proto
	 * @throws rpc_err
	 */
	public ClientRegisterClient(String host, String proto) throws rpc_err {
		super(host, ClientRegister._def_pno, ClientRegister._def_vno, proto);
	}

	/**
	 * @param host
	 * @param proto
	 * @param port
	 * @throws rpc_err
	 */
	public ClientRegisterClient(String host, String proto, int port) throws rpc_err {
		super(host, proto, port, ClientRegister._def_pno, ClientRegister._def_vno);
	}

	/**
	 * @param host
	 * @param prog
	 * @param ver
	 * @param proto
	 * @throws rpc_err
	 */
	public ClientRegisterClient(String host,  int prog, int ver, String proto) throws rpc_err {
		super(host, prog, ver, proto);
	}

	public Client save(Client in_arg) throws rpc_err {
		XDTString _in_arg = new XDTString();
		_in_arg.value = Utils.serializeObject(in_arg);
		XDTString _out_arg = new XDTString();
		getClient().call(ClientRegister._save_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(Client.class, _out_arg.value);
	}

	public Client find(Long in_arg) throws rpc_err {
		XDTString _out_arg = new XDTString();
		getClient().call(ClientRegister._find_proc, new XDTLong(in_arg), _out_arg);
		return Utils.deserializeObject(Client.class, _out_arg.value);
	}

	@SuppressWarnings("unchecked")
	public List<Client> list() throws rpc_err {
		XDTvoid _in_arg = new XDTvoid();
		XDTString _out_arg = new XDTString();
		getClient().call(ClientRegister._list_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(List.class, _out_arg.value);
	}

}