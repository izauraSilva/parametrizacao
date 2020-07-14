package br.com.original.bimo.param.aptidao.credito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ParameterResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ResponseData data;
	
}
