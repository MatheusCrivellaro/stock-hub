package br.com.stockhub.stockhub.service;

import br.com.stockhub.stockhub.dto.stock.ResponseStock;
import br.com.stockhub.stockhub.dto.stock.ResponseStockInitial;
import br.com.stockhub.stockhub.dto.stock.ResultStock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class StockService {

    public ResponseStock getStock(String cnpj, String bearerToken) throws IOException {
        //Abrindo conexão com a URL
        URL url = new URL("http://api.autonitro.com.br/api/services/app/StoreSite/GetStoreSiteXmlByCNPJ?cnpj=" + cnpj);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //Configurando a conexão
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
        connection.connect();

        //Conferindo o codigo de resposta da requisição
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Falha ao obter estoque: " + connection.getResponseMessage());
        }

        //Coletando a String do JSON de resposta
        String responseBody = new String(connection.getInputStream().readAllBytes());
        connection.disconnect();

        //Convertendo o JSON em um objeto Java
        return responseJsonToObject(responseBody);
    }

    private ResponseStock responseJsonToObject(String json) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
        ResponseStockInitial initial = gson.fromJson(json, ResponseStockInitial.class);
        ResultStock rs = gson.fromJson(initial.getResult(), ResultStock.class);

        return new ResponseStock(
                rs,
                initial.getTargetUrl(),
                initial.isSuccess(),
                initial.getError(),
                initial.isUnAuthorizedRequest(),
                initial.is__abp()
        );
    }

}
