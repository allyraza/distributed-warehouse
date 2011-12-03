package br.furb.diswah.test;

import java.math.BigDecimal;

import br.furb.diswah.model.Classification;
import br.furb.diswah.model.Product;
import br.furb.diswah.model.Sale;
import br.furb.diswah.model.User;
import br.furb.diswah.model.enums.MeasurementUnit;
import br.furb.diswah.storage.ClassificationStorageImpl;
import br.furb.diswah.storage.ProductStorageImpl;
import br.furb.diswah.storage.SaleStorageImpl;
import br.furb.diswah.storage.UserStorageImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class Teste {
	
	public static void main(String[] args) throws Exception {

		User u = new User();
		u.setEmail("email@email");
		u.setLogin("login");
		u.setPassword("login");
		System.out.println(new UserStorageImpl().save(u).getId());
		
		for(User user :new UserStorageImpl().list()){
			System.out.println(user.getId() + user.getLogin());
		}
		
		Classification classification = new Classification();
		classification.setCode(1l);
		classification.setDescription("A Classification");
		classification.setName("A Classification");
		System.out.println(new ClassificationStorageImpl().save(classification).getId());
		
		Product prod = new Product();
		prod.setMeasurementUnit(MeasurementUnit.BOX);
		prod.setClassification(classification);
		prod.setCode(1l);
		prod.setDescription("Uma caixa de algo");
		prod.setUnitaryPrice(new BigDecimal("150.25"));
		prod.setName("Leite");
		System.out.println(new ProductStorageImpl().save(prod).getId());
		
		SaleStorageImpl ssi = new SaleStorageImpl();
		ssi.save(new Sale());
		
		System.exit(0);
	}
	
}