package br.com.stockhub.stockhub.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDTO {

    private String token;
    private String cnpj;

}
