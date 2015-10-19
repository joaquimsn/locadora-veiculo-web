package br.com.jsn.noleggio.modules.veiculo.enums;

import java.util.ArrayList;
import java.util.List;

public enum CategoriaVeiculoEnum {
	A("A – Econômico", 1),
	C("C – Econômico com Ar", 2),
	E("F – Intermediário", 3),
	G("G – Intermediário Wagon Especial", 4),
	H("H – Executivo", 5),
	I("I – Utilitário", 6),
	K("K – Executivo Luxo", 7),
	M("M – Intermediário Wagon", 8),
	N("N – Pick-up", 9),
	P("P – 4 x 4 Especial", 10),
	R("R – Minivan", 11),
	U("U – Furgão", 12),
	Y("Y – Blindado", 13);
	
	private String display;
	private int value;
	
	private CategoriaVeiculoEnum(String display, int value) {
		this.display = display;
		this.value = value;
	}
	
	public static List<CategoriaVeiculoEnum> getEnumList() {
		List<CategoriaVeiculoEnum> lista = new ArrayList<CategoriaVeiculoEnum>();
		for(CategoriaVeiculoEnum objeto : values()) {
			lista.add(objeto);
		}
		return lista;
	}

	public static List<Integer> getValueList() {
		List<Integer> lista = new ArrayList<Integer>();
		for(CategoriaVeiculoEnum objeto : values()) {
			lista.add(objeto.value);
		}
		return lista;
	}
	
	public static List<String> getDisplayList() {
		List<String> lista = new ArrayList<String>();
		for(CategoriaVeiculoEnum objeto : values()) {
			lista.add(objeto.display);
		}
		return lista;
	}
	
	public static int getValueByDisplay(String display) {
		for(CategoriaVeiculoEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(Integer value) {
		for(CategoriaVeiculoEnum objeto : values()) {
			if(objeto.value == value.intValue()) {
				return objeto.display;
			}
		}
		return null;
	}
	
	public static CategoriaVeiculoEnum getEnumByValue(Integer value) {
		for(CategoriaVeiculoEnum objeto : values()) {
			if(objeto.value == value.intValue()) {
				return objeto;
			}
		}
		return null;
	}

	/**
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}

