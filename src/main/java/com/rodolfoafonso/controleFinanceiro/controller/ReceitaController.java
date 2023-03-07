package com.rodolfoafonso.controleFinanceiro.controller;
import com.rodolfoafonso.controleFinanceiro.dto.ReceitaDTO;
import com.rodolfoafonso.controleFinanceiro.entity.Receita;
import com.rodolfoafonso.controleFinanceiro.service.ReceitaService;


import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@AllArgsConstructor
@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<ReceitaDTO> cadastrar(@RequestBody ReceitaDTO receita) {
        receitaService.incluir(receita);
        return ResponseEntity.ok(receita);

    }

    @GetMapping
    public List<ReceitaDTO> buscaReceitas(String descricao) {
        return receitaService.consulta(descricao);
    }


    @GetMapping("/{ano}/{mes}")
    public List<ReceitaDTO> buscarReceitaMes(@PathVariable int ano, @PathVariable int mes){
        return receitaService.consultaMes(ano,mes);
    }



    @GetMapping("/{id}")
    public ReceitaDTO detalharReceita(@PathVariable Long id) {
        return receitaService.detalhar(id);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReceitaDTO> atualizaReceita(@PathVariable Long id, @RequestBody ReceitaDTO receita) {
        Receita receita1 = receitaService.atualiza(id, receita);
        return ResponseEntity.ok(receita);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReceitaDTO> removerReceita(@PathVariable Long id) {
        receitaService.remove(id);
        return ResponseEntity.ok().build();
    }
}
