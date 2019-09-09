package br.com.desafioaceleradev.classes.Functions;

import br.com.desafioaceleradev.classes.Consts.ConstantesDesafio;
import br.com.desafioaceleradev.classes.Entity.Desafio;
import br.com.desafioaceleradev.classes.RestClient.RestGetDesafio;
import br.com.desafioaceleradev.classes.RestClient.RestPostDesafio;
import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProcessaDados {
    // Salva arquivo answer.json no diretório
    public static File GetAndSaveDesafio() throws IOException {
        Gson g = new Gson();
        String jsonInString = g.toJson(GetDesafio());
        FileWriter file = new FileWriter(ConstantesDesafio.ARQUIVO);
        file.write(jsonInString);
        file.flush();
        file.close();
        return  new File(ConstantesDesafio.ARQUIVO);
    }

    // Envia arquivo via requisição :POST
    public static void PostDesafio(){
        RestPostDesafio Post = new RestPostDesafio();
        Post.PostFile();
    }

    // Busca o JSOn via requisição :GET
    public static Desafio GetDesafio(){
        RestGetDesafio Get = new RestGetDesafio();
        Desafio DadosDesafio = Get.RetornaClasseDesafio();
        return ProcessaDesafio(DadosDesafio);
    }

    // Processa as informações do desafio (Descriptografa e faz o resumoem SHA1)
    public static Desafio ProcessaDesafio(Desafio DadosDesafio){
        Criptografia Decode = new Criptografia();
        DadosDesafio.setDecifrado(Decode.Descriptografar(DadosDesafio.getCifrado(), DadosDesafio.getNumero_casas()));
        DadosDesafio.setResumo_criptografico(DigestUtils.sha1Hex(DadosDesafio.getDecifrado()));
        return DadosDesafio;
    }
}
