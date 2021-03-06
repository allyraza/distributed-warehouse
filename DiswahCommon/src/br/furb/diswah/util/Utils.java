package br.furb.diswah.util;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * 
 * @author Andr� Felipe de Almeida {almeida.andref@gmail.com}
 */
public final class Utils {

	/**
	 * @param clazz
	 * @param obj
	 * @return the deserialized object
	 */
	public static <T> T deserializeObject(Class<T> clazz, String obj){
		return new JSONDeserializer<T>().deserialize(obj);
	}
	
	/**
	 * @param obj
	 * @return the serialized object
	 */
	public static String serializeObject(Object obj){
		return new JSONSerializer().deepSerialize(obj); 
	}
	
}