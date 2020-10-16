/*
Singleton é um padrão de projeto de software. Este padrão garante a 
existência de apenas uma instância de uma classe, mantendo um ponto 
global de acesso ao seu objeto.

 */
package model;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.slf4j.*;

// URL que disponibiliza as API´s do IBGE:
// https://servicodados.ibge.gov.br/api/docs/localidades#api-_

/**
 * @author Benevaldo
 * Utiliza-se o padrao: Singleton
 * 
 */
public class ConsumeAPI {

    private static ConsumeAPI instance;
    private CloseableHttpClient clientHTTP;

    private ConsumeAPI() {
        // Cria um cliente HTTP
        this.clientHTTP = HttpClientBuilder.create().build();
    }

    // Obtem uma ÚNICA instância do Cliente HTTP
    public static synchronized ConsumeAPI getInstance() {
        if (instance == null) {
            instance = new ConsumeAPI();
        }
        return instance;
    }

    public String doGET(String url) {
        String responseGET = "";
        // Cria uma solicitação GET
        HttpGet httpGet = new HttpGet(url);

        try {
            ClassicHttpResponse response = this.clientHTTP.execute(httpGet);
            int status = response.getCode();
            if (status == HttpStatus.SC_OK) {
                // Sucesso na solicitação da requisição
                HttpEntity entity = response.getEntity();
                responseGET = EntityUtils.toString(entity);

            } else {
                responseGET = "Falha ao acessar a API.";
            }

        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }

        return responseGET;
    }

} // fim da classe ConsumeAPI. 
