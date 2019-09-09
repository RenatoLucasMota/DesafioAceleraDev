package br.com.desafioaceleradev.classes.RestClient;

import br.com.desafioaceleradev.classes.Consts.ConstantesDesafio;
import br.com.desafioaceleradev.classes.Entity.Desafio;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.FileWriter;

public class RestGetDesafio {

    public Desafio RetornaClasseDesafio() {
        Desafio DadosDesafio = null;
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource(ConstantesDesafio.URL_GET);

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            Gson g = new Gson();
            DadosDesafio = g.fromJson(output, Desafio.class);

            FileWriter file = new FileWriter(ConstantesDesafio.ARQUIVO);
            file.write(output);
            file.flush();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
        return DadosDesafio;
    }
}
