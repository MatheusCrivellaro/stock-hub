package br.com.stockhub.stockhub.dto.stock;

import lombok.Data;

@Data
public class Veiculo {
    private String CNPJ;
    private String HashPaidTraffic;
    private String Codigo;
    private String PlacaVeiculo;
    private String TipoVeiculo;
    private String UsadoNovo;
    private String Marca;
    private String Modelo;
    private String AnoModelo;
    private String AnoFabricacao;
    private String Versao;
    private String Combustivel;
    private String Cambio;
    private String QuantidadePortas;
    private String Cor;
    private String Chassi;
    private String RENAVAN;
    private String KM;
    private String Carroceria;
    private String Blindado;
    private String Destaque;
    private String PrecoOriginalVenda;
    private String PrecoVenda;
    private String UrlReservaMercadoLivre;
    private String Observacao;
    private Opcionais Opcionais;
    private Fotos Fotos;
    private String YoutubeVideo;
    private String DataCriacao;
    private String DataAlteracao;
    private String Cilindradas;
    private String Estilo;

}
