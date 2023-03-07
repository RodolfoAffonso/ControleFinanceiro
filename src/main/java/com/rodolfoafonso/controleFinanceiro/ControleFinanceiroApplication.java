package com.rodolfoafonso.controleFinanceiro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rodolfoafonso.controleFinanceiro.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@SpringBootApplication
public class ControleFinanceiroApplication {

//	private final LoginService loginService;
	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}

//	@PostConstruct
//	public void create() throws JsonProcessingException {
//		this.loginService.createUsers();
//	}
}
