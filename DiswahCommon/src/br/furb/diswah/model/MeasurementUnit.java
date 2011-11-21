package br.furb.diswah.model;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public enum MeasurementUnit {

	CAIXA("caixa"),
	GRAMA("grama"),
	KILOGRAMA("kilo"),
	LITRO("litro"),
	PACOTE("pacote"),
	UNIDADE("unidade");
	
	
	private String name;
	
	private MeasurementUnit(String name){
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}