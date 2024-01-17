package com.ig.safemoney.model;

public class DadosTokenJWT {

    private String tokenJWT;

    public DadosTokenJWT() {
    }

    public DadosTokenJWT(String tokenJWT) {
        this.tokenJWT = tokenJWT;
    }

    public String getTokenJWT() {
        return tokenJWT;
    }

    public void setTokenJWT(String tokenJWT) {
        this.tokenJWT = tokenJWT;
    }
}
