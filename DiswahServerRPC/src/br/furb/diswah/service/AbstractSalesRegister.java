package br.furb.diswah.service;

import netbula.ORPC.Svc;
import netbula.ORPC.XDR;
import netbula.ORPC.XDRError;
import netbula.ORPC.XDT;
import netbula.ORPC.XDTLong;
import netbula.ORPC.XDTString;
import netbula.ORPC.XDTvoid;

public abstract class AbstractSalesRegister extends Svc implements SalesRegister {

	public AbstractSalesRegister(int prog, int ver) {
		super(prog, ver);
	}

	public AbstractSalesRegister() {
		super(SalesRegister._def_pno, SalesRegister._def_vno);
	}

	abstract public String registerSale(String in_arg);

	abstract public String findSale(Long in_arg);

	abstract public String list();

	abstract public String delete(Long in_arg);

	public XDT proc_call(int proc, XDR inXDR) throws XDRError {
		switch (proc) {
		case 0:
			return new XDTvoid();

		case 1:
			String _out_arg1;
			try {
				XDTString _in_arg = new XDTString();
				_in_arg.xdr(inXDR);
				_out_arg1 = this.registerSale(_in_arg.value);
			} catch (XDRError e) {
				throw e;
			}
			return new XDTString(_out_arg1);

		case 2:
			String _out_arg2;
			try {
				XDTLong _in_arg = new XDTLong();
				_in_arg.xdr(inXDR);
				_out_arg2 = this.findSale(_in_arg.val());
			} catch (XDRError e) {
				throw e;
			}
			return new XDTString(_out_arg2);

		case 3:
			String _out_arg3;
			_out_arg3 = this.list();
			return new XDTString(_out_arg3);

		case 4:
			String _out_arg4;
			try {
				XDTLong _in_arg = new XDTLong();
				_in_arg.xdr(inXDR);
				_out_arg4 = this.delete(_in_arg.val());
			} catch (XDRError e) {
				throw e;
			}
			return new XDTString(_out_arg4);

		default:
			return null;
		}
	}

}