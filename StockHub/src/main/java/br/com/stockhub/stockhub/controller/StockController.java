package br.com.stockhub.stockhub.controller;

import br.com.stockhub.stockhub.dto.auth.TokenDTO;
import br.com.stockhub.stockhub.dto.login.Login;
import br.com.stockhub.stockhub.dto.stock.ResultStock;
import br.com.stockhub.stockhub.dto.stock.Veiculo;
import br.com.stockhub.stockhub.dto.stock.Veiculos;
import br.com.stockhub.stockhub.service.AutenticationService;
import br.com.stockhub.stockhub.service.BasicsActionService;
import br.com.stockhub.stockhub.service.FilterService;
import br.com.stockhub.stockhub.service.StockService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private BasicsActionService actionService;

    @Autowired
    private FilterService filter;

    @GetMapping("/all")
    public ResponseEntity<List<Veiculo>> findAll(@RequestHeader("Authorization") String token, @RequestHeader("cnpj") String cnpj) throws IOException {
        return ResponseEntity.ok(
                actionService.getStock(cnpj, token)
        );
    }

    @GetMapping("/cor/{cor}")
    public ResponseEntity<List<Veiculo>> findByCor(@RequestHeader("Authorization") String token, @RequestHeader("cnpj") String cnpj, @PathVariable String cor) throws IOException {
        return ResponseEntity.ok(
                filter.filterByCor(cor, cnpj, token)
        );
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<Veiculo>> findByMarca(@RequestHeader("Authorization") String token, String cnpj, @PathVariable String marca) throws IOException {
        return ResponseEntity.ok(
                filter.filterByMarca(marca, cnpj, token)
        );
    }
}
