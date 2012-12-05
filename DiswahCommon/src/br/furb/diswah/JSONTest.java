package br.furb.diswah;

import java.util.ArrayList;
import java.util.List;

import br.furb.diswah.model.BasicEntity;
import br.furb.diswah.model.Client;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class JSONTest {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		List<Client> users = new ArrayList<Client>();
		users.add(new Client());
		users.add(new Client());
		users.add(new Client());
		users.add(new Client());
		users.add(new Client());
		users.add(new Client());
		users.add(null);
		
		String serialized = new JSONSerializer().deepSerialize(users);
		System.out.println(serialized);
		List<BasicEntity> ll = (List<BasicEntity>) new JSONDeserializer().deserialize(serialized);
		
		for(BasicEntity b : ll)
			System.out.println(b);
	}
	
	/**
	 * @param a
	 * @param b
	 */
	public static void test(int a, int b){
		System.out.println(a + " - " + b);
	}

}

