package br.com.stockhub.stockhub.dto.stock;

import lombok.Data;

@Data
public class ResponseStockInitial {
    private String result;
    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;
}
