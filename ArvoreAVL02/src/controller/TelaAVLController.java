/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import model.CidadeAVL;


/**
 * FXML Controller class
 *
 * @author benev
 */
public class TelaAVLController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arvore.obterCidadeAPI();
    }

    // Classe que manipula o comportamento da Árvore Binária
    CidadeAVL arvore = new CidadeAVL();

    @FXML
    private Button btnImprimir;

    @FXML
    private TextArea txaExibirDados;

    @FXML
    private TextField txtValor;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnRemover;

    @FXML
    // Ação do botão Imprimir
    void acaoImprimir(ActionEvent event) {
        txaExibirDados.clear();
        if (!arvore.isEmpty()) {
            txaExibirDados.appendText("\n");
            arvore.inorder();
            txaExibirDados.appendText(arvore.getDisplayNode());
            txaExibirDados.appendText("\n");
        } else {
            txaExibirDados.clear();
            txaExibirDados.appendText(arvore.getMensagem());
        }

    }

    @FXML
    // Ação do botão Buscar
    void acaoBuscar(ActionEvent event) {
          txaExibirDados.clear();
        if (!txtValor.getText().isEmpty()) {
            txaExibirDados.clear();
            txaExibirDados.appendText(arvore.searchNode(Integer.parseInt(txtValor.getText())));
        } else {
            txtValor.requestFocus();
            txaExibirDados.clear();
            txaExibirDados.appendText("Entre com um valor numérico!!!");
        }

    }

    
    @FXML
    // Ação do botão Remover        
    void acaoRemover(ActionEvent event) {

        if (!txtValor.getText().isEmpty()) {
            arvore.remove(Integer.parseInt(txtValor.getText()));
            txtValor.setText("");
            txtValor.requestFocus();

            if (arvore.isEmpty()) {
                // Limpar a area de exibição de dados  
                txaExibirDados.clear();
                txaExibirDados.appendText(arvore.getMensagem());
            } else {
                // Exibir a árvore após a remoção
                txaExibirDados.appendText("\n");
                arvore.inorder();
                txaExibirDados.appendText(arvore.getDisplayNode());
                txaExibirDados.appendText("\n");
            }
        }else {
            txtValor.requestFocus();
            txaExibirDados.clear();
            txaExibirDados.appendText("Entre com um valor numérico!!!");
        }
    }

}
