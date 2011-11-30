package br.furb.diswah.connection;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;


/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class PropertiesBundle {

	private static Properties properties;
	
	private static Properties getProperties(){
		if(properties == null){
			properties = new Properties();
			try {
				properties.load(new FileReader(new File("diswah.properties")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	public static String getProperty(String key){
		return String.valueOf(getProperties().get(key));
	}
	
}