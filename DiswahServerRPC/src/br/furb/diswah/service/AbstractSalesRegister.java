package br.furb.diswah.service;

import java.util.List;

import netbula.ORPC.Svc;
import netbula.ORPC.XDR;
import netbula.ORPC.XDRError;
import netbula.ORPC.XDT;
import netbula.ORPC.XDTLong;
import netbula.ORPC.XDTString;
import netbula.ORPC.XDTvoid;
import br.furb.diswah.model.Sale;
import br.furb.diswah.util.Utils;

/**
 * @author andre.almeida
 *
 */
public abstract class AbstractSalesRegister extends Svc implements SalesRegister {

	/**
	 * @param prog
	 * @param ver
	 */
	public AbstractSalesRegister(int prog, int ver) {
		super(prog, ver);
	}

	/**
	 * 
	 */
	public AbstractSalesRegister() {
		super(SalesRegister._def_pno, SalesRegister._def_vno);
	}

	abstract public Sale registerSale(Sale sale);

	abstract public Sale findSale(Long id);

	abstract public List<Sale> list();

	abstract public Sale delete(Long id);

	public XDT proc_call(int proc, XDR inXDR) throws XDRError {
		switch (proc) {
		case 0:
			return new XDTvoid();

		case 1:
			String _out_arg1;
			try {
				XDTString _in_arg = new XDTString();
				_in_arg.xdr(inXDR);
				_out_arg1 = Utils.serializeObject(this.registerSale(Utils.deserializeObject(Sale.class, _in_arg.value)));
			} catch (XDRError e) {
				throw e;
			}
			return new XDTString(_out_arg1);

		case 2:
			String _out_arg2;
			try {
				XDTLong _in_arg = new XDTLong();
				_in_arg.xdr(inXDR);
				_out_arg2 = Utils.serializeObject(this.findSale(_in_arg.value));
			} catch (XDRError e) {
				throw e;
			}
			return new XDTString(_out_arg2);

		case 3:
			String _out_arg3;
			_out_arg3 = Utils.serializeObject(this.list());
			return new XDTString(_out_arg3);

		case 4:
			String _out_arg4;
			try {
				XDTLong _in_arg = new XDTLong();
				_in_arg.xdr(inXDR);
				_out_arg4 = Utils.serializeObject(this.delete(_in_arg.value));
			} catch (XDRError e) {
				throw e;
			}
			return new XDTString(_out_arg4);

		default:
			return null;
		}
	}

}