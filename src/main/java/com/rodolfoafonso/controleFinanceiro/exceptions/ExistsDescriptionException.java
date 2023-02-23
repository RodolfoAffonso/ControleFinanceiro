package com.rodolfoafonso.controleFinanceiro.exceptions;

import org.springframework.http.HttpStatus;


public class ExistsDescriptionException extends CustomException {
    public  ExistsDescriptionException(String descicao) {
        super(HttpStatus.BAD_REQUEST, "Descrição " + descicao + " ja existe");
    }
}
