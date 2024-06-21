package br.com.stockhub.stockhub.dto.login;

import lombok.Data;

@Data
public class Login {

    private String username;
    private String password;
    private String cnpj;

}
