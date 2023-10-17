package com.redes.praticabdredes.model;

public class Dispositivo {
    private String nome;
    private String ip;
    private String mac;
    private String tipo;
    private String descricao;
    public Dispositivo(String nome, String ip, String mac, String tipo, String descricao, String localizacao) {
        this.nome = nome;
        this.ip = ip;
        this.mac = mac;
        this.tipo = tipo;
        this.descricao = descricao;
        this.localizacao = localizacao;
    }
    public Dispositivo() {
    }
    private String localizacao;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

}
