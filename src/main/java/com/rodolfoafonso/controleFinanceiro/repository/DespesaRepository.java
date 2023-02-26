package com.rodolfoafonso.controleFinanceiro.repository;

import com.rodolfoafonso.controleFinanceiro.dto.ResumoCategoriaDTO;
import com.rodolfoafonso.controleFinanceiro.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa,Long> {
    @Query("SELECT count(*)  From Despesa d WHERE d.descricao = :descricao and Month(data) = Month(:data)")
    Long verificaCondicao(@Param("descricao") String descricao, @Param("data") LocalDate data);

    List<Despesa> findByDescricao(String descricao);
    @Query("SELECT d FROM Despesa d WHERE Year(data) = :ano  and Month(data) = :mes")
    List<Despesa> buscaMes(@Param("ano") int ano , @Param("mes") int mes);

    @Query("SELECT new com.rodolfoafonso.controleFinanceiro.dto.ResumoCategoriaDTO(sum(d.valor), d.categoria.descricao) FROM Despesa d WHERE Year(d.data) = :ano  and Month(d.data) = :mes group by d.categoria.descricao ")
    List<ResumoCategoriaDTO> resumoMes(@Param("ano") int ano , @Param("mes") int mes);

}
