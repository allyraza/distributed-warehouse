package br.furb.diswah.register;

import java.util.List;

import netbula.ORPC.ClientGeneric;
import netbula.ORPC.XDTLong;
import netbula.ORPC.XDTString;
import netbula.ORPC.XDTvoid;
import netbula.ORPC.rpc_err;
import br.furb.diswah.model.SaleProduct;
import br.furb.diswah.util.Utils;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SaleProductRegisterClient extends ClientGeneric implements SaleProductRegister {

	/**
	 * @throws rpc_err
	 */
	public SaleProductRegisterClient() throws rpc_err {
	};

	/**
	 * @param host
	 * @param proto
	 * @throws rpc_err
	 */
	public SaleProductRegisterClient(String host, String proto) throws rpc_err {
		super(host, SaleProductRegister._def_pno, SaleProductRegister._def_vno, proto);
	}

	/**
	 * @param host
	 * @param proto
	 * @param port
	 * @throws rpc_err
	 */
	public SaleProductRegisterClient(String host, String proto, int port) throws rpc_err {
		super(host, proto, port, SaleProductRegister._def_pno, SaleProductRegister._def_vno);
	}

	/**
	 * @param host
	 * @param prog
	 * @param ver
	 * @param proto
	 * @throws rpc_err
	 */
	public SaleProductRegisterClient(String host, int prog, int ver, String proto) throws rpc_err {
		super(host, prog, ver, proto);
	}

	public SaleProduct save(SaleProduct in_arg) throws rpc_err {
		XDTString _in_arg = new XDTString();
		_in_arg.value = Utils.serializeObject(in_arg);
		XDTString _out_arg = new XDTString();
		getClient().call(SaleProductRegister._save_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(SaleProduct.class, _out_arg.value);
	}

	public SaleProduct find(Long in_arg) throws rpc_err {
		XDTString _out_arg = new XDTString();
		getClient().call(SaleProductRegister._find_proc, new XDTLong(in_arg), _out_arg);
		return Utils.deserializeObject(SaleProduct.class, _out_arg.value);
	}

	@SuppressWarnings("unchecked")
	public List<SaleProduct> list() throws rpc_err {
		XDTvoid _in_arg = new XDTvoid();
		XDTString _out_arg = new XDTString();
		getClient().call(SaleProductRegister._list_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(List.class, _out_arg.value);
	}

}