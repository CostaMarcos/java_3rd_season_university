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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import model.AVLNode;
import model.AVLTree;

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
    AVLTree arvore = new AVLTree();

    // Classe que representa o no Raiz da Árvore Binária
    AVLNode raiz;

    int cont = 0;
    
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
        arvore.insert(Integer.parseInt(txtValor.getText()));
        txtValor.setText("");
        txtValor.requestFocus();
    }

    @FXML
    // Ação do botão Imprimir
    void acaoImprimir(ActionEvent event) {
        cont += 1;
        txaExibirDados.clear();
        if(cont == 1){
            txaExibirDados.appendText("Em pre ordem:\n");
            arvore.preorder();
            txaExibirDados.appendText(arvore.getListaNoArvore());
            txaExibirDados.appendText("\n");
        } else if(cont == 2) {
            txaExibirDados.appendText("Em ordem:\n");
            arvore.inorder();
            txaExibirDados.appendText(arvore.getListaNoArvore());
            txaExibirDados.appendText("\n");
        } else if(cont == 3){
            txaExibirDados.appendText("Pos ordem:\n");
            arvore.postorder();
            txaExibirDados.appendText(arvore.getListaNoArvore());
            txaExibirDados.appendText("\n");
        } else {
            cont = 0;
            txaExibirDados.appendText("Pre ordem:\n");
            arvore.preorder();
            txaExibirDados.appendText(arvore.getListaNoArvore());
            txaExibirDados.appendText("\n");
        }        
    }

    @FXML
    // Ação do botão Buscar
    void acaoBuscar(ActionEvent event) {

        // Implementado pelo Aluno
        // Limpar a area de exibição de dados  
        txaExibirDados.clear();
        
        if ( arvore.search(Integer.parseInt(txtValor.getText()))){
             txaExibirDados.appendText("Elemento encontrado: " + txtValor.getText() ); 
        }else{
           txaExibirDados.appendText("Elemento NAO existe na Arvore: " + txtValor.getText() );  
        }
       
    }

    @FXML
    // Ação do botão Remover        
    void acaoRemover(ActionEvent event) { 
        txaExibirDados.clear();
        if(arvore.remove(Integer.parseInt(txtValor.getText()))){
            txaExibirDados.appendText("Removido com suceso");
        } else {
            txaExibirDados.appendText("Nao foi possivel remover o item");
        }
    }
}
