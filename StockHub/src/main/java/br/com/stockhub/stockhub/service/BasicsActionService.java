package br.com.stockhub.stockhub.service;

import br.com.stockhub.stockhub.dto.stock.ResultStock;
import br.com.stockhub.stockhub.dto.stock.Veiculo;
import br.com.stockhub.stockhub.dto.stock.Veiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BasicsActionService {

    @Autowired
    private StockService stockService;

    @Autowired
    private AutenticationService autenticationService;

    public Veiculos getStock(String cnpj, String token) throws IOException {
        return stockService.getStock(cnpj, token).getResult().getVeiculos();
    }

    public List<String> marcasPresent(String cnpj, String token) throws IOException {
        return getStock(cnpj, token).getVeiculo().stream().map(Veiculo::getMarca).toList();
    }

}
