package br.com.original.bimo.param.aptidao.credito.model;

import java.io.Serializable;

public class Cnae implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String description;
	
	public Cnae(String code, String description) {	
		this.code = code;
		this.description = description;
	}	

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Cnae [code=" + code + ", description=" + description + "]";
	}	

}
