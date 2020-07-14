package br.com.original.bimo.param.aptidao.credito.model;

import java.io.Serializable;
import java.util.List;

public class CnaeResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Cnae> data;

	public CnaeResponse(List<Cnae> data) {	
		this.data = data;
	}

	public List<Cnae> getData() {
		return data;
	}

	public void setData(List<Cnae> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CnaeResponse [data=" + data + "]";
	}	

}
