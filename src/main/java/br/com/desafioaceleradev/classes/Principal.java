package br.com.desafioaceleradev.classes;

import br.com.desafioaceleradev.classes.Functions.ProcessaDados;

public class Principal {
    public static void main(String[] args) {

        try {
            // Faz o GET e Salva JSON Processado
            ProcessaDados.GetAndSaveDesafio();

            // Envia arquivo via requisição :POST
            ProcessaDados.PostDesafio();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

