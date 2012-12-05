package br.furb.diswah.model.enums;

import br.furb.diswah.resource.MessageBundle;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public enum MeasurementUnit {

	/**
	 * 
	 */
	BOX("measurementunit.name.box","measurementunit.shortname.box"),
	/**
	 * 
	 */
	GRAM("measurementunit.name.gram","measurementunit.shortname.gram"),
	/**
	 * 
	 */
	KILOGRAM("measurementunit.name.kilogram","measurementunit.shortname.kilogram"),
	/**
	 * 
	 */
	LITER("measurementunit.name.liter","measurementunit.shortname.liter"),
	/**
	 * 
	 */
	PACKAGE("measurementunit.name.package","measurementunit.shortname.package"),
	/**
	 * 
	 */
	UNITY("measurementunit.name.unity","measurementunit.shortname.unity");
	
	
	private String name;
	private String shortName;
	
	private MeasurementUnit(String name, String shortName){
		this.name = name;
		this.shortName = shortName;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return MessageBundle.getMessage(name);
	}
	
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return MessageBundle.getMessage(shortName);
	}
	
}