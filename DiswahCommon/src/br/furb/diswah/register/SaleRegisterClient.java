package br.furb.diswah.register;

import java.util.List;

import netbula.ORPC.ClientGeneric;
import netbula.ORPC.XDTLong;
import netbula.ORPC.XDTString;
import netbula.ORPC.XDTvoid;
import netbula.ORPC.rpc_err;
import br.furb.diswah.model.Sale;
import br.furb.diswah.util.Utils;

/**
 * @author andre.almeida
 *
 */
public class SaleRegisterClient extends ClientGeneric implements SaleRegister{

	/**
	 * @throws rpc_err
	 */
	public SaleRegisterClient() throws rpc_err { };

	/**
	 * @param host
	 * @param proto
	 * @throws rpc_err
	 */
	public SaleRegisterClient(String host, String proto) throws rpc_err {
		super(host, SaleRegister._def_pno, SaleRegister._def_vno, proto);
	}

	/**
	 * @param host
	 * @param proto
	 * @param port
	 * @throws rpc_err
	 */
	public SaleRegisterClient(String host, String proto, int port) throws rpc_err {
		super(host, proto, port, SaleRegister._def_pno, SaleRegister._def_vno);
	}

	/**
	 * @param host
	 * @param prog
	 * @param ver
	 * @param proto
	 * @throws rpc_err
	 */
	public SaleRegisterClient(String host,  int prog, int ver, String proto) throws rpc_err {
		super(host, prog, ver, proto);
	}

	public Sale save(Sale in_arg) throws rpc_err {
		XDTString _in_arg = new XDTString();
		_in_arg.value = Utils.serializeObject(in_arg);
		XDTString _out_arg = new XDTString();
		getClient().call(SaleRegister._save_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(Sale.class, _out_arg.value);
	}

	public Sale find(Long in_arg) throws rpc_err {
		XDTString _out_arg = new XDTString();
		XDTLong in_long = new XDTLong(in_arg);
		getClient().call(SaleRegister._find_proc, in_long, _out_arg);
		return Utils.deserializeObject(Sale.class, _out_arg.value);
	}

	@SuppressWarnings("unchecked")
	public List<Sale> list() throws rpc_err {
		XDTvoid _in_arg = new XDTvoid();
		XDTString _out_arg = new XDTString();
		getClient().call(SaleRegister._list_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(List.class, _out_arg.value);
	}

}