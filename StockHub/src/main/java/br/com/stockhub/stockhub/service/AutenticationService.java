package br.com.stockhub.stockhub.service;

import br.com.stockhub.stockhub.dto.auth.AutonitroTokenResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

@Service
public class AutenticationService {

    private final String api_url;

    public AutenticationService() {
        this.api_url = "http://api.autonitro.com.br/api/TokenAuth/Authenticate";
    }

    public AutonitroTokenResponse authenticate(String username, String password) throws IOException {

        //Abrindo conexão com a URL
        URL url = new URL(api_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //Configurando a conexão
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

        //Criando bory da requisição
        String jsonBody = "{\"usernameOrEmailAddress\":\"" + username + "\",\"password\":\"" + password + "\"}";
        connection.setDoOutput(true);
        connection.getOutputStream().write(jsonBody.getBytes());

        //Conferindo o codigo de resposta da requisição
        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Falha na autenticação: " + connection.toString());
        }

        //Coletando a String do JSON de resposta
        String responseBody = new String(connection.getInputStream().readAllBytes());
        connection.disconnect();

        //Convertendo o JSON em um objeto Java
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(responseBody, AutonitroTokenResponse.class);
    }

}
