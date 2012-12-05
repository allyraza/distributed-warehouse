package br.furb.diswah.service;

import java.util.List;

import br.furb.diswah.model.Sale;

/**
 * @author andre.almeida
 *
 */
public interface SalesRegister{

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
	public static final int _registerSale_proc = 1;
	/**
	 * 
	 */
	public static final int _findSale_proc = 2;
	/**
	 * 
	 */
	public static final int _list_proc = 3;
	/**
	 * 
	 */
	public static final int _delete_proc = 4;

	/**
	 * @param sale
	 * @return Sale
	 * @throws netbula.ORPC.rpc_err
	 */
	public Sale registerSale(Sale sale) throws netbula.ORPC.rpc_err;

	/**
	 * @param id
	 * @return Sale
	 * @throws netbula.ORPC.rpc_err
	 */
	public Sale findSale(Long id) throws netbula.ORPC.rpc_err;

	/**
	 * @return list<sale>
	 * @throws netbula.ORPC.rpc_err
	 */
	public List<Sale> list() throws netbula.ORPC.rpc_err;

	/**
	 * @param id
	 * @return sale
	 * @throws netbula.ORPC.rpc_err
	 */
	public Sale delete(Long id) throws netbula.ORPC.rpc_err;

}