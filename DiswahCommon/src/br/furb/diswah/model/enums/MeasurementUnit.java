package br.furb.diswah.model.enums;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public enum MeasurementUnit {

	CAIXA("caixa","cx"),
	GRAMA("grama","g"),
	KILOGRAMA("kilo","kg"),
	LITRO("litro","l"),
	PACOTE("pacote","pc"),
	UNIDADE("unidade","un");
	
	
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
		return name;
	}
	
	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}
	
}