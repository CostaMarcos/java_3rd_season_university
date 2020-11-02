/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Benevevaldo
 */
public class Municipio extends Node {

    private long id;
    private String nome;

    public Municipio() {
        super();
    }

    /**
     * @return the id
     */
    public int getId() {
        return (int) id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
        this.setNumericKey(id);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;

        // Preenche o atributo stringKey da superclasse Node, que determina
        // o critério de comparação para cada NO. 
        this.setStringKey(nome);
    }

}// fim classe Municipio 
