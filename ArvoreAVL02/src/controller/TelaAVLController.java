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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtValor.requestFocus();
    }

    // Classe que manipula o comportamento da Árvore Binária
    CidadeAVL arvore = new CidadeAVL();

    @FXML
    private Button btnImprimir;

    @FXML
    private Button btnInserir;

    @FXML
    private TextArea txaExibirDados;

    @FXML
    private TextField txtValor;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnRemover;

    @FXML
    // Ação do botão Inserir        
    void acaoInserir(ActionEvent event) {
//        if (!txtValor.getText().isEmpty()) {
//            Municipio municio = new Municipio();
//            //municio.setId(Long.parseLong(txtValor.getText()));
//            municio.setNome(txtValor.getText());
//            arvore.insert(municio);
//            txtValor.setText("");
//            txtValor.requestFocus();
//        } else {
//            txtValor.requestFocus();
//            txaExibirDados.clear();
//            txaExibirDados.appendText("Entre com um valor!!!");
//        }
        
        arvore.obterCidadeAPI();
        txaExibirDados.clear();
        txaExibirDados.appendText("Cidades do Estado do Amazonas associadas a AVL!!!");

    }

    @FXML
    // Ação do botão Imprimir
    void acaoImprimir(ActionEvent event) {

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
//        if (!txtValor.getText().isEmpty()) {
//            txaExibirDados.clear();
//            if (arvore.search(Integer.parseInt(txtValor.getText()))) {
//                txaExibirDados.appendText(arvore.getMensagem());
//            } else {
//                txaExibirDados.appendText(arvore.getMensagem());
//            }
//        } else {
//            txtValor.requestFocus();
//            txaExibirDados.clear();
//            txaExibirDados.appendText("Entre com um valor numérico!!!");
//        }

    }

    @FXML
    // Ação do botão Remover        
    void acaoRemover(ActionEvent event) {

//        if (!txtValor.getText().isEmpty()) {
//            arvore.remove(Integer.parseInt(txtValor.getText()));
//            txtValor.setText("");
//            txtValor.requestFocus();
//
//            if (arvore.isEmpty()) {
//                // Limpar a area de exibição de dados  
//                txaExibirDados.clear();
//                txaExibirDados.appendText(arvore.getMensagem());
//            } else {
//                // Exibir a árvore após a remoção
//                txaExibirDados.appendText("\n");
//                arvore.inorder();
//                txaExibirDados.appendText(arvore.getListaNoArvore());
//                txaExibirDados.appendText("\n");
//            }
//        }else {
//            txtValor.requestFocus();
//            txaExibirDados.clear();
//            txaExibirDados.appendText("Entre com um valor numérico!!!");
//        }
    }

}
