package br.furb.diswah.util;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public final class Utils {

	public static <T> T deserializeObject(Class<T> clazz, String obj){
		return new JSONDeserializer<T>().deserialize(obj);
	}
	
	public static String serializeObject(Object obj){
		return new JSONSerializer().deepSerialize(obj); 
	}
	
}