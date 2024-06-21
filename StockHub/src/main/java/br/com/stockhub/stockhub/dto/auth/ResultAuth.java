package br.com.stockhub.stockhub.dto.auth;

import lombok.Data;

@Data
public class ResultAuth {
    private String accessToken;
    private String encryptedAccessToken;
    private int expireInSeconds;
    private boolean shouldResetPassword;
    private String passwordResetCode;
    private int userId;
    private boolean requiresTwoFactorVerification;
    private Object twoFactorAuthProviders;
    private Object twoFactorRememberClientToken;
    private Object returnUrl;
}
