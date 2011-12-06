package br.furb.diswah.register;

import java.util.List;

import netbula.ORPC.rpc_err;
import br.furb.diswah.model.Sale;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface SaleRegister {

	public static final int _def_pno = 1;
	public static final int _def_vno = 1;

	public static final int _save_proc = 1;

	public Sale save(Sale in_arg) throws rpc_err;

	public static final int _find_proc = 2;

	public Sale find(Long in_arg) throws rpc_err;

	public static final int _list_proc = 3;

	public List<Sale> list() throws rpc_err;

}