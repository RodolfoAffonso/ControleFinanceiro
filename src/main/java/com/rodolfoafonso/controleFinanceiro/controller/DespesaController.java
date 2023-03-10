package com.rodolfoafonso.controleFinanceiro.controller;

import com.rodolfoafonso.controleFinanceiro.dto.DespesaDTO;

import com.rodolfoafonso.controleFinanceiro.entity.Despesa;
import com.rodolfoafonso.controleFinanceiro.service.DespesaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/despesas")
public class DespesaController {


    private final DespesaService despesaService;

    @PostMapping
    public ResponseEntity<DespesaDTO> cadastrar(@RequestBody DespesaDTO despesa) {
        despesaService.incluir(despesa);
        return ResponseEntity.ok(despesa);

    }

    @GetMapping
    public List<DespesaDTO> buscaDespesa(String descricao) {
        return despesaService.consulta(descricao);
    }


    @GetMapping("/{ano}/{mes}")
    public List<DespesaDTO> buscaDespesaMes(@PathVariable int ano, @PathVariable int mes){
        return despesaService.consultaMes(ano, mes);

    }

    @GetMapping("/{id}")
    public DespesaDTO detalharDespesa(@PathVariable Long id) {
        return despesaService.detalhar(id);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DespesaDTO> atualizaDespesa(@PathVariable Long id, @RequestBody DespesaDTO despesa) {
        Despesa despesa1 = despesaService.atualiza(id, despesa);
        return ResponseEntity.ok(despesa);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DespesaDTO> removerDespesa(@PathVariable Long id) {
        despesaService.remove(id);
        return ResponseEntity.ok().build();
    }
}
