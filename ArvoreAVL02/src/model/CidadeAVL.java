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

public class CidadeAVL extends AVLTree {
    public void obterCidadeAPI() {
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/27/municipios";
        String json = "";
        json = ConsumeAPI.getInstance().doGET(url);
        inserirCidadeAPI(json);
    }
    
    private void inserirCidadeAPI(String json) {
        Gson gson = new Gson();
        Type municipioListType = new TypeToken<ArrayList<Municipio>>() {
        }.getType();
        List<Municipio> municipioList = gson.fromJson(json, municipioListType);
        municipioList.forEach(objCidade -> {
            Municipio obj = new Municipio();
            obj.setId(objCidade.getId());
            obj.setNome(objCidade.getNome());
            insert(obj);
        });
    }
}
