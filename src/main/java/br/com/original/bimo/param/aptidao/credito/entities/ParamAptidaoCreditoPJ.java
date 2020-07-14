package br.com.original.bimo.param.aptidao.credito.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="PARM_APDAO_CREDT_PJ", schema = "BIMO")
public class ParamAptidaoCreditoPJ implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARAM_SEQ")
	@SequenceGenerator(name = "PARAM_SEQ", sequenceName = "PARM_APDAO_CREDT_PJ_SEQ", allocationSize = 1, schema = "BIMO")
	@Column(name = "ID_PARM_APDAO_CREDT_PJ")
	private Long id;
	
	@Column(name = "QTI_DIA_VALDD_CARGA")
	private Integer qtdDiaValCarga; 	
	
	@Column(name = "QTI_MES_FUNDC_EMPR")
	private Integer qtdMesFundEmpr; 
	
	@Column(name = "VAL_FATMT_PRESM_MIN")
	private BigDecimal valFatPresMin; 
	
	@Column(name = "VAL_FATMT_PRESM_MAX")
	private BigDecimal valFatPresMax; 
	
	@Column(name = "VAL_SCORE_RISCO")
	private Integer valScoreRisco;
	
	@Column(name = "DAT_INIC_VGCIA")
	private LocalDateTime datInicVgcia; 
	
	@Column(name = "DAT_FNAL_VGCIA")
	private LocalDateTime datFimVgcia;
	
	@Column(name = "COD_USUAR_INCL")
	private String codUsuIncl; 
	
	@Column(name = "COD_USUAR_ALT")
	private String codUsuAlt;

	@OneToMany(mappedBy = "paramAptidaoCreditoPJ", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ParamAptidaoCreditoPjCnae> cnaes = new ArrayList<>();
}
