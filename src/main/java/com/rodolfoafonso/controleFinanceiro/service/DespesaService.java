package com.rodolfoafonso.controleFinanceiro.service;

import com.rodolfoafonso.controleFinanceiro.dto.DespesaDTO;
import com.rodolfoafonso.controleFinanceiro.entity.Categoria;
import com.rodolfoafonso.controleFinanceiro.entity.Despesa;
import com.rodolfoafonso.controleFinanceiro.entity.Receita;
import com.rodolfoafonso.controleFinanceiro.exceptions.ExistsDescriptionException;
import com.rodolfoafonso.controleFinanceiro.repository.CategoriaRepository;
import com.rodolfoafonso.controleFinanceiro.repository.DespesaRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DespesaService {

    DespesaRepository despesaRepository;

    CategoriaRepository categoriaRepository;

    public void incluir(DespesaDTO despesaDTO) {

        Categoria categoria = getCategoria(despesaDTO);

        long count = despesaRepository.verificaCondicao(despesaDTO.getDescricao(), despesaDTO.getData());
        if (count > 0) {
            throw new ExistsDescriptionException("Descrição ja existe");

        } else {
            Despesa despesa = new Despesa(despesaDTO.getId(), despesaDTO.getDescricao(), despesaDTO.getValor(), despesaDTO.getData(), categoria);
            despesaRepository.save(despesa);
        }
    }

    public List<DespesaDTO> consulta(String descricao) {
        if (descricao == null) {
            List<Despesa> despesas = despesaRepository.findAll();
            return despesas.stream().map(despesa -> new DespesaDTO(despesa.getId(), despesa.getDescricao(), despesa.getValor(), despesa.getData(), despesa.getCategoria().toString())).toList();
        } else {  List<Despesa> despesas = despesaRepository.findByDescricao(descricao);
            return despesas.stream().map(despesa -> new DespesaDTO(despesa.getId(), despesa.getDescricao(), despesa.getValor(), despesa.getData(), despesa.getCategoria().toString())).toList();
        }
    }


    public DespesaDTO detalhar(Long id) {
        Despesa despesa = despesaRepository.getReferenceById(id);
        return new DespesaDTO(despesa);
    }

    public Despesa atualiza(Long id, DespesaDTO despesaDTO) {

        Categoria categoria = getCategoria(despesaDTO);

        long count = despesaRepository.verificaCondicao(despesaDTO.getDescricao(), despesaDTO.getData());
        if (count > 0) {
            throw new ExistsDescriptionException("Descrição ja existe");

        } else {
            Despesa despesa = despesaRepository.getReferenceById(id);
            despesa.setDescricao(despesaDTO.getDescricao());
            despesa.setValor(despesaDTO.getValor());
            despesa.setData(despesaDTO.getData());
            despesa.setCategoria(categoria);
            return despesa;
        }
    }

    private Categoria getCategoria(DespesaDTO despesaDTO) {
        String categoriaStr;

        if (despesaDTO.getCategoria() == null)
            categoriaStr = "OUTROS";

        else
            categoriaStr = despesaDTO.getCategoria();

        Optional<Categoria> optionalCategoria = this.categoriaRepository.findByCategoria(categoriaStr);

        return optionalCategoria.orElseThrow(() -> new RuntimeException("Categoria invalida "));

    }

    public void remove(Long id) {
        despesaRepository.deleteById(id);
    }

    public List<DespesaDTO> consultaMes(int ano, int mes) {
        List<Despesa> despesas = despesaRepository.buscaMes(ano,mes);
        return despesas.stream().map(despesa -> new DespesaDTO(despesa.getId(), despesa.getDescricao(), despesa.getValor(), despesa.getData(), despesa.getCategoria().toString())).toList();
    }
}
