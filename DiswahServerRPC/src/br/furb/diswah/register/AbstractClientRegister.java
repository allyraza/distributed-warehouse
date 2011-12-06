package br.furb.diswah.register;

import java.util.List;

import netbula.ORPC.Svc;
import netbula.ORPC.XDR;
import netbula.ORPC.XDRError;
import netbula.ORPC.XDT;
import netbula.ORPC.XDTLong;
import netbula.ORPC.XDTString;
import netbula.ORPC.XDTvoid;
import br.furb.diswah.model.Client;
import br.furb.diswah.util.Utils;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class AbstractClientRegister extends Svc implements ClientRegister {

	public AbstractClientRegister(int prog, int ver) {
		super(prog, ver);
	}

	public AbstractClientRegister() {
		super(ClientRegister._def_pno, ClientRegister._def_vno);
	}

	abstract public Client save(Client in_arg) ;

	abstract public Client find(Long in_arg) ;

	abstract public List<Client> list() ;

	public XDT proc_call (int proc, XDR inXDR) throws XDRError {
		switch(proc) {
		case 0: return new XDTvoid();

		case 1:
		String _out_arg1;
		try {
			XDTString _in_arg = new XDTString();
			_in_arg.xdr(inXDR);
			_out_arg1 = Utils.serializeObject(this.save(Utils.deserializeObject(Client.class, _in_arg.value)));
		} catch (XDRError e) {
			throw e;
		}
		return new XDTString(_out_arg1);

		case 2:
		String _out_arg2;
		try {
			XDTLong _in_arg = new XDTLong();
			_in_arg.xdr(inXDR);
			_out_arg2 = Utils.serializeObject(this.find(_in_arg.value));
		} catch (XDRError e) {
			throw e;
		}
		return new XDTString(_out_arg2);

		case 3:
		String _out_arg3;
		_out_arg3 = Utils.serializeObject(this.list());
		return new XDTString(_out_arg3);

		default: return null;
		}
	}

}