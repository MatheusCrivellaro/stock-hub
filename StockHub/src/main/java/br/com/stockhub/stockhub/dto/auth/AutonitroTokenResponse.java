package br.com.stockhub.stockhub.dto.auth;

import lombok.Data;

@Data
public class AutonitroTokenResponse {
    private ResultAuth result;
    private String targetUrl;
    private boolean success;
    private String error;
    private boolean unAuthorizedRequest;
    private boolean __abp;
}
