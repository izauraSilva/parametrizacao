package br.com.original.bimo.param.aptidao.credito.services;

import br.com.original.bimo.param.aptidao.credito.entities.ParamAptidaoCreditoPJ;
import br.com.original.bimo.param.aptidao.credito.model.ParameterRequest;

public interface ParamAptidaoCreditoPjService {
	
	ParamAptidaoCreditoPJ saveParameter(ParameterRequest request);
	
	ParamAptidaoCreditoPJ updateParameter(ParamAptidaoCreditoPJ paramAptidaoCreditoPJ);
	
	ParamAptidaoCreditoPJ getLastParamAptidaoCreditoPJ();
}
