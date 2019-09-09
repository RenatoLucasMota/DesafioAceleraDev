package br.com.desafioaceleradev.classes.Functions;

public class Criptografia {

    public String Descriptografar(String enc, int numero_casas) {
        return Criptografar(enc, 26-numero_casas);
    }

    public String Criptografar(String enc, int numero_casas) {
        numero_casas = numero_casas % 26 + 26;
        StringBuilder str_encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    str_encoded.append((char) ('A' + (i - 'A' + numero_casas) % 26 ));
                } else {
                    str_encoded.append((char) ('a' + (i - 'a' + numero_casas) % 26 ));
                }
            } else {
                str_encoded.append(i);
            }
        }
        return str_encoded.toString();
    }
}
