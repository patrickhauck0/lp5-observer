package org.example.observer;

import java.util.Observable;
public class Assinatura extends Observable {
    private String curso;
    private String download;

    public Assinatura(String curso, String download) {
        this.curso = curso;
        this.download = download;
    }

    public void lancarNotificao() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Obrigado por se inscrever{" +
                "no curso de='" + curso + '\'' +
                ", link para download dos materiais='" + download + '\'' +
                '}';
    }
}
