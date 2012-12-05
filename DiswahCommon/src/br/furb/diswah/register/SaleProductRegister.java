package br.furb.diswah.register;

import java.util.List;

import netbula.ORPC.rpc_err;
import br.furb.diswah.model.SaleProduct;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface SaleProductRegister {

	/**
	 * 
	 */
	public static final int _def_pno = 1;
	/**
	 * 
	 */
	public static final int _def_vno = 1;

	/**
	 * 
	 */
	public static final int _save_proc = 1;

	/**
	 * @param in_arg
	 * @return saleProduct
	 * @throws rpc_err
	 */
	public SaleProduct save(SaleProduct in_arg) throws rpc_err;

	/**
	 * 
	 */
	public static final int _find_proc = 2;

	/**
	 * @param in_arg
	 * @return saleProduct
	 * @throws rpc_err
	 */
	public SaleProduct find(Long in_arg) throws rpc_err;

	/**
	 * 
	 */
	public static final int _list_proc = 3;

	/**
	 * @return list<saleProduct>
	 * @throws rpc_err
	 */
	public List<SaleProduct> list() throws rpc_err;

}