package br.com.original.bimo.param.aptidao.credito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class ParameterRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "expiresIn is required")
	private Integer expiresIn;

	@Valid
	@NotNull(message = "list cnaes is required")
	private List<ParameterCnaeRequest> cnaesRestricted;
	
	@NotNull(message = "companyFoundation is required")
	private Integer companyFoundation;
	
	@NotNull(message = "minimumPresumedBilling is required")
	private BigDecimal minimumPresumedBilling;
	
	@NotNull(message = "maximumPresumedBilling is required")
	private BigDecimal maximumPresumedBilling;

	@Max(value=9999, message="Score - maximum 4 characters allowed")
	@NotNull(message = "score is required")
	private Integer score;

}
