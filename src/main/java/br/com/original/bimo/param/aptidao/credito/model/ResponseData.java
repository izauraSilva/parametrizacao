package br.com.original.bimo.param.aptidao.credito.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.original.bimo.param.aptidao.credito.entities.ParamAptidaoCreditoPJ;

public class ResponseData implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer expiresIn;
	private List<Cnae> cnaesRestricted;
	private Integer companyFoundation;
	private BigDecimal minimumPresumedBilling;
	private BigDecimal maximumPresumedBilling;
	private Integer score;		

	public ResponseData(ParamAptidaoCreditoPJ paramAptidaoCreditoPJ) {
		this.expiresIn = paramAptidaoCreditoPJ.getQtdDiaValCarga();
		this.cnaesRestricted = paramAptidaoCreditoPJ.getCnaes().stream().map(c -> new Cnae(c.getCodCnae(),c.getDescCnae())).collect(Collectors.toList());
		this.companyFoundation = paramAptidaoCreditoPJ.getQtdMesFundEmpr();
		this.minimumPresumedBilling = paramAptidaoCreditoPJ.getValFatPresMin();
		this.maximumPresumedBilling = paramAptidaoCreditoPJ.getValFatPresMax();
		this.score = paramAptidaoCreditoPJ.getValScoreRisco();
	}
		
	public Integer getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
	public List<Cnae> getCnaesRestricted() {
		return cnaesRestricted;
	}
	public void setCnaesRestricted(List<Cnae> cnaesRestricted) {
		this.cnaesRestricted = cnaesRestricted;
	}
	public Integer getCompanyFoundation() {
		return companyFoundation;
	}
	public void setCompanyFoundation(Integer companyFoundation) {
		this.companyFoundation = companyFoundation;
	}	
	public BigDecimal getMinimumPresumedBilling() {
		return minimumPresumedBilling;
	}

	public void setMinimumPresumedBilling(BigDecimal minimumPresumedBilling) {
		this.minimumPresumedBilling = minimumPresumedBilling;
	}

	public BigDecimal getMaximumPresumedBilling() {
		return maximumPresumedBilling;
	}

	public void setMaximumPresumedBilling(BigDecimal maximumPresumedBilling) {
		this.maximumPresumedBilling = maximumPresumedBilling;
	}

	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "ParameterResponse [expiresIn=" + expiresIn + ", cnaesRestricted=" + cnaesRestricted
				+ ", companyFoundation=" + companyFoundation + ", minimumPresumedBilling=" + minimumPresumedBilling
				+ ", maximumPresumedBilling=" + maximumPresumedBilling + ", score=" + score + "]";
	}	
	

}
