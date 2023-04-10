package com.example.aula0902;

public class Usuario {
    String login;
    String senha;
    boolean admin;

    public Usuario(String login, String senha, boolean admin) {
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}

