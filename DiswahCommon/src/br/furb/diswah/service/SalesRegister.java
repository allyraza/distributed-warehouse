package br.furb.diswah.service;

public interface SalesRegister{

	public static final int _def_pno = 1;
	public static final int _def_vno = 1;

	public static final int _registerSale_proc = 1;
	public static final int _findSale_proc = 2;
	public static final int _list_proc = 3;
	public static final int _delete_proc = 4;

	public String registerSale(String in_arg) throws netbula.ORPC.rpc_err;

	public String findSale(Long in_arg) throws netbula.ORPC.rpc_err;

	public String list() throws netbula.ORPC.rpc_err;

	public String delete(Long in_arg) throws netbula.ORPC.rpc_err;

}