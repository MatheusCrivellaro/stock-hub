package br.com.stockhub.stockhub.controller;

import br.com.stockhub.stockhub.dto.login.Login;
import br.com.stockhub.stockhub.service.AutenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Service("/login")
public class LoginController {

    @Autowired
    private AutenticationService authService;

    @PostMapping
    public void login(HttpSession session, Login login) throws IOException {
        session.setAttribute("cnpj", login.getCnpj());
        session.setAttribute("authToken", authService.authenticate(login.getUsername(), login.getPassword()).getResult().getAccessToken());
    }

}
