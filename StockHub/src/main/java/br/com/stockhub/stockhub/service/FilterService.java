package br.com.stockhub.stockhub.service;

import br.com.stockhub.stockhub.dto.stock.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FilterService {


    @Autowired
    private BasicsActionService service;

    public List<Veiculo> filterByCor(String cor, String cnpj, String token) throws IOException {
        return service.getStock(cnpj, token).stream().filter(veiculo -> veiculo.getCor().equalsIgnoreCase(cor)).toList();
    }

    public List<Veiculo> filterByMarca(String marca, String cnpj, String token) throws IOException {
        return service.getStock(cnpj, token).stream().filter(veiculo -> veiculo.getMarca().equalsIgnoreCase(marca)).toList();
    }

}
