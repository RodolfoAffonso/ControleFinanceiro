package com.rodolfoafonso.controleFinanceiro.service;

import com.rodolfoafonso.controleFinanceiro.dto.ReceitaDTO;
import com.rodolfoafonso.controleFinanceiro.entity.Receita;
import com.rodolfoafonso.controleFinanceiro.exceptions.ExistsDescriptionException;
import com.rodolfoafonso.controleFinanceiro.repository.ReceitaRepository;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReceitaService {


    private final ReceitaRepository receitaRepository;


    public void incluir(ReceitaDTO receitaDTO) {
        long count = receitaRepository.verificaCondicao(receitaDTO.getDescricao(), receitaDTO.getData());
        if (count > 0) {
            throw new ExistsDescriptionException("Descrição ja existe");

        } else {
            Receita receita = new Receita(receitaDTO.getId(), receitaDTO.getDescricao(), receitaDTO.getValor(), receitaDTO.getData());
            receitaRepository.save(receita);
        }
    }

    public List<ReceitaDTO> consulta(String descricao) {
        if (descricao == null) {
            List<Receita> receitas = receitaRepository.findAll();
            return ReceitaDTO.getReceitaDTOS(receitas);
        }else {
            List<Receita> receitas = receitaRepository.findByDescricao(descricao);
            return ReceitaDTO.getReceitaDTOS(receitas);
        }
        }

    public ReceitaDTO detalhar(Long id) {
        Receita receita = receitaRepository.getReferenceById(id);
        return new ReceitaDTO(receita);
    }

    public Receita atualiza(Long id, ReceitaDTO receitaDTO) {
        long count = receitaRepository.verificaCondicao(receitaDTO.getDescricao(), receitaDTO.getData());
        if (count > 0) {
            throw new ExistsDescriptionException("Descrição ja existe");

        } else {
            Receita receita = receitaRepository.getReferenceById(id);
            receita.setDescricao(receitaDTO.getDescricao());
            receita.setValor(receitaDTO.getValor());
            receita.setData(receitaDTO.getData());
            return receita;
        }
    }

    public void remove(Long id) {
        receitaRepository.deleteById(id);
    }

    public List<ReceitaDTO> consultaMes(int ano ,int mes) {
        List<Receita> receitas = receitaRepository.buscaMes(ano,mes);
        return ReceitaDTO.getReceitaDTOS(receitas);
    }


}