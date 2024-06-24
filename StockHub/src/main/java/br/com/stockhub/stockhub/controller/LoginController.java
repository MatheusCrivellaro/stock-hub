package br.com.stockhub.stockhub.controller;

import br.com.stockhub.stockhub.dto.auth.TokenDTO;
import br.com.stockhub.stockhub.dto.login.Login;
import br.com.stockhub.stockhub.service.AutenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AutenticationService authService;

    @PostMapping
    public ResponseEntity<TokenDTO> login(@RequestBody Login login) throws IOException {
        var token = authService.authenticate(login.getUsername(), login.getPassword()).getResult().getAccessToken();
        return ResponseEntity.ok(new TokenDTO(token, login.getCnpj()));
    }

}
