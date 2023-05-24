package org.example.observer;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String email;
    private String ultimaNotificacao;

    public Usuario(String email) {
        this.email = email;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void assinar(Assinatura assinatura) {
        assinatura.addObserver(this);
    }

    public void update(Observable assinatura, Object arg1) {
        this.ultimaNotificacao = this.email + ", " + assinatura.toString();
    }
}
