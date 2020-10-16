/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benevaldo
 */
public class CidadeAVL extends AVLTree {

    // Obterm o JSON com a relação das cidades de um determinado Estado.
    public void obterCidadeAPI() {
        // URL obterm um JSON com todas as cidades do estado do Amazonas (cídigo do AM=13)
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/13/municipios";
        String json = "";
        json = ConsumeAPI.getInstance().doGET(url);
        inserirCidadeAPI(json);
    }

    // Insere a relação de municípios da API, através do json, na árvore AVL.
    private void inserirCidadeAPI(String json) {
        
        // Classe da Google para manipular JSON
        Gson gson = new Gson();
        
        // Identifica o tipo da classe Municipio para estrutura ArrayList  
        Type municipioListType = new TypeToken<ArrayList<Municipio>>() {
        }.getType();
        
        // Faz o parse do Josn para Objeto Java segundo o tipo: municipioListType 
        List<Municipio> municipioList = gson.fromJson(json, municipioListType);

        // Perrcorre a lista de Objeto cidade e insere na árvore AVL
        municipioList.forEach(objCidade -> {
            Municipio obj = new Municipio();
            obj.setId(objCidade.getId());
            obj.setNome(objCidade.getNome());
            insert(obj);
        });
    }
}
