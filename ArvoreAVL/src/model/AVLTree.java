
package model;

/**
 *
 * @author Benevaldo
 */
public class AVLTree {

    private AVLNode root;
    private String listaNoArvore;

    /* Construtor */
    public AVLTree() {
        this.root = null;
        this.listaNoArvore = "";
    }

    /* Função para verificar se a árvore está vazia */
    public boolean isEmpty() {
        return this.root == null;
    }

    /* Tornar a árvore logicamente vazia */
    public void makeEmpty() {
        this.root = null;
    }

    /* Função para inserir dados */
    public void insert(int data) {
        // Método insert com sobrecarga recursivo
        this.root = insert(data, this.root);
    }

    /* Função para obter a altura do nó */
    private int height(AVLNode t) {
        return t == null ? -1 : t.getHeight();
    }

    /* Função para obter a altura máximo do nó esquerdo/direito*/
    private int max(int leftHeight, int rightHeight) {
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    /* Método insert com sobrecarga recursivo */
    private AVLNode insert(int x, AVLNode t) {
        if (t == null) {
            t = new AVLNode(x);
        } else if (x < t.getData()) {
            t.setLeft(insert(x, t.getLeft()));
            if (height(t.getLeft()) - height(t.getRight()) == 2) {
                if (x < t.getLeft().getData()) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (x > t.getData()) {
            t.setRight(insert(x, t.getRight()));
            if (height(t.getRight()) - height(t.getLeft()) == 2) {
                if (x > t.getRight().getData()) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else // Valor duplicado, nao fazer nada.
        {
            t.setHeight(max(height(t.getLeft()), height(t.getRight())) + 1);
        }

        return t;
    }

    /* Gire o nó da árvore binária com o filho esquerdo */
    private AVLNode rotateWithLeftChild(AVLNode leftChild) {
        AVLNode rotate = leftChild.getLeft();
        leftChild.setLeft(rotate.getRight());
        rotate.setRight(leftChild);
        leftChild.setHeight(max(height(leftChild.getLeft()), height(leftChild.getRight())) + 1);
        rotate.setHeight(max(height(rotate.getLeft()), leftChild.getHeight()) + 1);
        return rotate;
    }

    /* Gire o nó da árvore binária com o filho da direita */
    private AVLNode rotateWithRightChild(AVLNode rightChild) {
        AVLNode rotate = rightChild.getRight();
        rightChild.setRight(rotate.getLeft());
        rotate.setLeft(rightChild);
        rightChild.setHeight(max(height(rightChild.getLeft()), height(rightChild.getRight())) + 1);
        rotate.setHeight(max(height(rotate.getRight()), rightChild.getHeight()) + 1);
        return rotate;
    }

    /**
     * Rotação dupla do nó da árvore binária: primeiro filho à esquerda com seu
     * filho à direita, depois o nó doubleLeftChild com o novo filho à esquerda.
     */
    private AVLNode doubleWithLeftChild(AVLNode doubleLeftChild) {
        doubleLeftChild.setLeft(rotateWithRightChild(doubleLeftChild.getLeft()));
        return rotateWithLeftChild(doubleLeftChild);
    }

    /**
     * Rotação dupla do nó da árvore binária: primeiro filho direito com seu
     * filho esquerdo, então o nó doubleRightChild com novo filho direito
     */
    private AVLNode doubleWithRightChild(AVLNode doubleRightChild) {
        doubleRightChild.setRight(rotateWithLeftChild(doubleRightChild.getRight()));
        return rotateWithRightChild(doubleRightChild);
    }

    /* Funções para contar o número de nós */
    public int countNodes() {
        return countNodes(this.root);
    }

    /* Funções com sobrecarga para retornar o número de nós */
    private int countNodes(AVLNode r) {
        if (r == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(r.getLeft());
            count += countNodes(r.getRight());
            return count;
        }
    }

    /* Funções para pesquisar um elemento */
    public boolean search(int val) {
        return search(this.root, val);
    }
    
    // Verifica a existencia de um determinado valor na Arvore 
    private boolean search(AVLNode r, int searchValue) {
        boolean found = false;
        while ((r != null) && !found) {
            int value = r.getData();
            if (searchValue < value) {
                r = r.getLeft();
            } else if (searchValue > value) {
                r = r.getRight();
            } else {
                found = true;
                break;
            }
            found = search(r, searchValue);
        }
        return found;
    }
    
    public boolean remove(int val) {
        return remove(this.root, val);
    }
    
    private AVLNode procuraMenor(AVLNode atual){
        AVLNode no1 = atual;
        AVLNode no2 = atual.getLeft();
        while(no2 != null){
            no1 = no2;
            no2 = no2.getLeft();
        }
        
        return no1;
    }
    
    private boolean remove(AVLNode r, int valor){
        if(r == null){
            return false;
        }
        
        boolean res = false;
        if(valor < r.getData()){
            res = remove(r.getLeft(), valor);
//            if(res){
//            }
        }
        
        if(valor > r.getData()){
            res = remove(r.getRight(), valor);
//            if(res){
//            }
        }
        
        if(valor == r.getData()){
            if((r.getLeft() == null) && (r.getRight() == null)){
                r.deleteNode(r);
            }else if((r.getLeft() == null) || (r.getRight() == null)){
                if(r.getLeft() != null){
                    r.setData(r.getLeft().getData());
                    r.setLeft(null);
                } else {
                    r.setData(r.getRight().getData());
                    r.setRight(null);
                }
               
            } else{
                AVLNode temp = procuraMenor(r.getRight());
                r.setData(temp.getData());
                remove(r.getRight(), r.getData());
            }
            res = true;
        }
        
        return res;
    }
    
    /* Realizar exibiçao de dados: inOrder */
    public void inorder() {
        this.listaNoArvore = "";
        inorder(this.root); 
    }

    private void inorder(AVLNode r) {
        if (r != null) {
            inorder(r.getLeft());
            this.listaNoArvore = this.listaNoArvore + Integer.toString(r.getData()) + "   ";
            inorder(r.getRight());
        }
    }

    /* Realizar exibiçao de dados: preOrder */
    public void preorder() {
        this.listaNoArvore = "";
        preorder(this.root);
    }

    private void preorder(AVLNode r) {
        if (r != null) {
            this.listaNoArvore = this.listaNoArvore + Integer.toString(r.getData()) + "   ";
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    /* Realizar exibiçao de dados: posOrder */
    public void postorder() {
        this.listaNoArvore = "";
        postorder(this.root);
    }

    private void postorder(AVLNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            this.listaNoArvore = this.listaNoArvore + Integer.toString(r.getData()) + "   ";
        }
    }

    /**
     * @return the listaNoArvore
     */
    public String getListaNoArvore() {
        return listaNoArvore;
    }

} // fim classe AVLTree
