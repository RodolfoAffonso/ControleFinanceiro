package com.rodolfoafonso.controleFinanceiro.controller;

import com.rodolfoafonso.controleFinanceiro.dto.UserLoginDTO;
import com.rodolfoafonso.controleFinanceiro.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/cadastrar")
@RestController

public class UserController {

    private final UserService userService ;

    @PostMapping
    public ResponseEntity<UserLoginDTO> cadastrar(@RequestBody UserLoginDTO user){
        userService.incluir(user);
        return ResponseEntity.ok(user);

    }

}
