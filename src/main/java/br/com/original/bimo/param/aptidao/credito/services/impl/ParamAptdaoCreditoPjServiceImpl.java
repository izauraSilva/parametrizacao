package br.com.original.bimo.param.aptidao.credito.services.impl;

import br.com.original.bimo.param.aptidao.credito.entities.ParamAptidaoCreditoPJ;
import br.com.original.bimo.param.aptidao.credito.entities.ParamAptidaoCreditoPjCnae;
import br.com.original.bimo.param.aptidao.credito.model.ParameterRequest;
import br.com.original.bimo.param.aptidao.credito.repositories.ParamAptidaoCreditoPjRepository;
import br.com.original.bimo.param.aptidao.credito.services.ParamAptidaoCreditoPjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParamAptdaoCreditoPjServiceImpl implements ParamAptidaoCreditoPjService{
	
	@Value("${user.bimo}")
	private String user;
	
	@Autowired
	ParamAptidaoCreditoPjRepository paramRepository;	

	@Override
	public ParamAptidaoCreditoPJ saveParameter(ParameterRequest request) {

		ParamAptidaoCreditoPJ paramAptidaoCreditoPJ = new ParamAptidaoCreditoPJ();
		paramAptidaoCreditoPJ.setQtdDiaValCarga(request.getExpiresIn());
		paramAptidaoCreditoPJ.setQtdMesFundEmpr(request.getCompanyFoundation());
		paramAptidaoCreditoPJ.setValFatPresMin(request.getMinimumPresumedBilling());
		paramAptidaoCreditoPJ.setValFatPresMax(request.getMaximumPresumedBilling());
		paramAptidaoCreditoPJ.setValScoreRisco(request.getScore());
		paramAptidaoCreditoPJ.setDatInicVgcia(LocalDateTime.now());
		paramAptidaoCreditoPJ.setCodUsuIncl(user);
		List<ParamAptidaoCreditoPjCnae> cnaes = new ArrayList<>();
		Optional.ofNullable(request.getCnaesRestricted()).ifPresent(i -> i.forEach(c -> {
			ParamAptidaoCreditoPjCnae cnae = new ParamAptidaoCreditoPjCnae();
			cnae.setCodCnae(c.getCode());
			cnae.setDescCnae(c.getDescription());
			cnae.setParamAptidaoCreditoPJ(paramAptidaoCreditoPJ);
			cnaes.add(cnae);
		}));
		paramAptidaoCreditoPJ.setCnaes(cnaes);

		return paramRepository.save(paramAptidaoCreditoPJ);
	}

	@Override
	public ParamAptidaoCreditoPJ getLastParamAptidaoCreditoPJ() {
		return paramRepository.findByDatFimVgciaIsNull();
	}

	@Override
	public ParamAptidaoCreditoPJ updateParameter(ParamAptidaoCreditoPJ aptidaoCreditoPJ) {
		aptidaoCreditoPJ.setCodUsuAlt(user);
		aptidaoCreditoPJ.setDatFimVgcia(LocalDateTime.now());
		return paramRepository.save(aptidaoCreditoPJ);
	}	

}
