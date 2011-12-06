package br.furb.diswah.register;

import java.util.List;

import netbula.ORPC.rpc_err;
import br.furb.diswah.model.Client;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface ClientRegister {

	public static final int _def_pno = 1;
	public static final int _def_vno = 1;

	public static final int _save_proc = 1;

	public Client save(Client in_arg) throws rpc_err;

	public static final int _find_proc = 2;

	public Client find(Long in_arg) throws rpc_err;

	public static final int _list_proc = 3;

	public List<Client> list() throws rpc_err;

}