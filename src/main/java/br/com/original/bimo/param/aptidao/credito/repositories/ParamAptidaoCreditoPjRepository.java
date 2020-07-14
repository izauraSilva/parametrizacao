package br.com.original.bimo.param.aptidao.credito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.original.bimo.param.aptidao.credito.entities.ParamAptidaoCreditoPJ;

@Repository
public interface ParamAptidaoCreditoPjRepository extends JpaRepository<ParamAptidaoCreditoPJ, Long> {

	ParamAptidaoCreditoPJ findByDatFimVgciaIsNull();
}
