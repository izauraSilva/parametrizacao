package br.com.original.bimo.param.aptidao.credito.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="PARM_APDAO_CREDT_PJ_CNAE", schema = "BIMO")
public class ParamAptidaoCreditoPjCnae implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COD_CNAE")
	private String codCnae;
	
	@Column(name = "DES_CNAE")
	private String descCnae;

	@Id
	@ManyToOne
	@JoinColumn(name="ID_PARM_APDAO_CREDT_PJ")
	private ParamAptidaoCreditoPJ paramAptidaoCreditoPJ;

}
