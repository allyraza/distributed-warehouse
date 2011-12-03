package br.furb.diswah.service;

import java.util.List;

import br.furb.diswah.model.Sale;
import br.furb.diswah.util.Utils;
import netbula.ORPC.ClientGeneric;
import netbula.ORPC.XDTLong;
import netbula.ORPC.XDTString;
import netbula.ORPC.XDTvoid;
import netbula.ORPC.rpc_err;

public class SalesRegisterClient extends ClientGeneric implements SalesRegister{

	/**
	Construct an RPC client that is not bound to any server
	*/
	public SalesRegisterClient() throws rpc_err { };

	/**
	Construct an RPC client object connected to a server
	on the specified host with the specified protocol

	@param host server hostname, or URL of the RPC proxy if http is used
	@param proto protocol, can be "tcp", "udp" or "http"
	*/
	public SalesRegisterClient(String host, String proto) throws rpc_err {
		super(host, SalesRegister._def_pno, SalesRegister._def_vno, proto);
	}


	/**
	Construct an RPC client object connected to a server
	on the specified host with the specified protocol and port number

	@param host server hostname
	@param proto protocol, can be "tcp" or "udp"
	@param port server's fixed port number
	*/
	public SalesRegisterClient(String host, String proto, int port) throws rpc_err {
		super(host, proto, port, SalesRegister._def_pno, SalesRegister._def_vno);
	}


	/**
	Construct an RPC client object connected to a server
	on the specified host with the specified program number,version and protocol

	@param host server hostname, or URL of RPC proxy
	@param proto protocol, can be "tcp", "udp" or "http"
	@param prog server's program number
	@param ver server's version number
	*/
	public SalesRegisterClient(String host,  int prog, int ver, String proto) throws rpc_err {
		super(host, prog, ver, proto);
	}

	public Sale registerSale(Sale sale) throws rpc_err {
		XDTString _in_arg = new XDTString();
		_in_arg.value = Utils.serializeObject(sale);
		XDTString _out_arg = new XDTString();
		getClient().call(SalesRegister._registerSale_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(Sale.class, _out_arg.value);
	}

	public Sale findSale(Long id) throws rpc_err {
		XDTLong _in_arg = new XDTLong();
		_in_arg.value = id;
		XDTString _out_arg = new XDTString();
		getClient().call(SalesRegister._findSale_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(Sale.class, _out_arg.value);
	}

	@SuppressWarnings("unchecked")
	public List<Sale> list() throws rpc_err {
		XDTvoid _in_arg = new XDTvoid();
		XDTString _out_arg = new XDTString();
		getClient().call(SalesRegister._list_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(List.class, _out_arg.value);
	}

	public Sale delete(Long id) throws rpc_err {
		XDTLong _in_arg = new XDTLong();
		_in_arg.value = id;
		XDTString _out_arg = new XDTString();
		getClient().call(SalesRegister._delete_proc, _in_arg, _out_arg);
		return Utils.deserializeObject(Sale.class, _out_arg.value);
	}

}