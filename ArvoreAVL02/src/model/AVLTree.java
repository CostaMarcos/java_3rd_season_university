package model;

public abstract class AVLTree {

    private Node root;
    private String displayNode;
    private String mensagem;

    // Construtor
    public AVLTree() {
        this.root = null;
        this.mensagem = "";
        displayNode = "";
    }

    /* Função para verificar se a árvore está vazia */
    public boolean isEmpty() {
        if (this.root == null) {
            this.mensagem = "Árvore AVL está vazia!!!!";
            return true;
        } else {
            return false;
        }
    }

    /* Tornar a árvore logicamente vazia */
    public void makeEmpty() {
        this.root = null;
    }

    /* Função para obter a altura do nó */
    private int height(Node t) {
        return t == null ? -1 : t.getHeight();
    }

    /* Função para obter a altura máximo do nó esquerdo ou direito*/
    private int max(int leftHeight, int rightHeight) {
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    /* (Rotação) : Gire o nó da árvore binária com o filho esquerdo */
    private Node rotateWithLeftChild(Node leftChild) {
        Node rotate = leftChild.getLeft();
        leftChild.setLeft(rotate.getRight());
        rotate.setRight(leftChild);
        leftChild.setHeight(max(height(leftChild.getLeft()), height(leftChild.getRight())) + 1);
        rotate.setHeight(max(height(rotate.getLeft()), leftChild.getHeight()) + 1);
        return rotate;
    }

    /* (Rotação) : Gire o nó da árvore binária com o filho da direita */
    private Node rotateWithRightChild(Node rightChild) {
        Node rotate = rightChild.getRight();
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
    private Node doubleWithLeftChild(Node doubleLeftChild) {
        doubleLeftChild.setLeft(rotateWithRightChild(doubleLeftChild.getLeft()));
        return rotateWithLeftChild(doubleLeftChild);
    }

    /**
     * Rotação dupla do nó da árvore binária: primeiro filho direito com seu
     * filho esquerdo, então o nó doubleRightChild com novo filho direito
     */
    private Node doubleWithRightChild(Node doubleRightChild) {
        doubleRightChild.setRight(rotateWithLeftChild(doubleRightChild.getRight()));
        return rotateWithRightChild(doubleRightChild);
    }

    /* Funções para contar o número de nós */
    public int countNodes() {
        return countNodes(this.root);
    }

    /* Funções recursiva com sobrecarga para retornar o número de nós */
    private int countNodes(Node r) {
        if (r == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(r.getLeft());
            count += countNodes(r.getRight());
            return count;
        }
    }

    /* Realizar exibiçao de dados: inOrder */
    public void inorder() {
        this.displayNode = "";
        if (!isEmpty()) {
            inorder(this.root);
        }
    }

    private void inorder(Node r) {
        if (r != null) {
            inorder(r.getLeft());
            mountDisplay(r);
            inorder(r.getRight());
        }
    }

    // Procedimento para montar a exibição dos dados do NO
    // Para cada tipo de objeto do NO deve-se reescrecer o método através do polimorfismo 
    protected void mountDisplay(Node r) {
        //this.displayNode = this.displayNode + Long.toString(r.getNumericKey()) + "   ";
        
        this.displayNode = this.displayNode + r.getStringKey() + "\n";
    }


    /* Função para inserir dados */
    public void insert(Node newNode) {
        // Método insert com sobrecarga recursivo
        //this.root = insert(newNode, this.root);

        this.root = insertStringKey(newNode, this.root);
    }

    /* Método insert com sobrecarga recursivo */
    private Node insert(Node newNode, Node t) {
        if (t == null) {
            t = newNode;
        } else if (newNode.getNumericKey() < t.getNumericKey()) {
            t.setLeft(insert(newNode, t.getLeft()));
            if (height(t.getLeft()) - height(t.getRight()) == 2) {
                if (newNode.getNumericKey() < t.getLeft().getNumericKey()) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (newNode.getNumericKey() > t.getNumericKey()) {
            t.setRight(insert(newNode, t.getRight()));
            if (height(t.getLeft()) - height(t.getRight()) == -2) {
                if (newNode.getNumericKey() > t.getRight().getNumericKey()) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else {
            // Valor duplicado, nao fazer nada, pois não permite inserir valor repetido.
            return t;
        }
        // Atualizar a altura da árvore após a inclusão de um NOVO elemento. 
        t.setHeight(max(height(t.getLeft()), height(t.getRight())) + 1);
        return t;
    }

    /* Método insert com sobrecarga recursivo */
    private Node insertStringKey(Node newNode, Node t) {
        if (t == null) {
            t = newNode;
        } else if (newNode.getStringKey().compareToIgnoreCase(t.getStringKey()) < 0) {
            // (newNode.getNumericKey() < t.getNumericKey()) {

            t.setLeft(insertStringKey(newNode, t.getLeft()));
            if (height(t.getLeft()) - height(t.getRight()) == 2) {
                if (newNode.getStringKey().compareToIgnoreCase(t.getLeft().getStringKey()) < 0) {
                    //    (newNode.getNumericKey() < t.getLeft().getNumericKey()) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (newNode.getStringKey().compareToIgnoreCase(t.getStringKey()) > 0) {
            // (newNode.getNumericKey() > t.getNumericKey()) {
            t.setRight(insertStringKey(newNode, t.getRight()));
            if (height(t.getLeft()) - height(t.getRight()) == -2) {
                if (newNode.getStringKey().compareToIgnoreCase(t.getRight().getStringKey()) > 0) {
                    //(newNode.getNumericKey() > t.getRight().getNumericKey()) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        } else {
            // Valor duplicado, nao fazer nada, pois não permite inserir valor repetido.
            return t;
        }
        // Atualizar a altura da árvore após a inclusão de um NOVO elemento. 
        t.setHeight(max(height(t.getLeft()), height(t.getRight())) + 1);
        return t;
    }
    
    public String searchNode(int numeroCidade){
        return buscarNo(this.root, numeroCidade); 
    }
    
    private String buscarNo(Node r, int numeroCidade){
        String cidade = null;
        try{
            if(numeroCidade > r.numericKey){
                buscarNo(r.right, numeroCidade);
            } else if(numeroCidade < r.numericKey){
                buscarNo(r.left, numeroCidade);
            } else if(numeroCidade == r.numericKey){
                cidade = cidade + r.stringKey; 
            }
        } catch(Exception e){
            cidade = cidade + "Cidade não encontrada";
        }
        
        return cidade;
    }
    
    
    private Node procuraMenor(Node atual){
        Node no1 = atual;
        Node no2 = atual.left;
        while(no2 != null){
            no1 = no2;
            no2 = no2.left;
        }
        
        return no1;
    }
        
    private Boolean removeNode(Node r, int numeroNo){
        if(r == null){
            return false;
        }
        
        boolean removido = false;
        
        if(numeroNo < r.numericKey){
            removido = removeNode(r.left, numeroNo);
        }
        
        if(numeroNo > r.numericKey){
            removido = removeNode(r.right, numeroNo);
        }
        
        if(numeroNo == r.numericKey){
            if((r.left == null) && (r.right == null)){
                r = null;
            }else if((r.left == null) || (r.right == null)){
                if(r.left != null){
                    r.numericKey = r.left.numericKey;
                    r.stringKey = r.left.stringKey;
                    r.left = null;
                } else {
                    r.numericKey = r.right.numericKey;
                    r.stringKey = r.right.stringKey;
                    r.right = null;
                }
            } else{
                Node temp = procuraMenor(r.right);
                r.numericKey = temp.numericKey;
                r.stringKey = temp.stringKey;
                removeNode(r.right, r.numericKey);
            }
            removido = true;
        }
        
        return removido;
    }
    
    public Boolean remove(int numeroNo) {
        return removeNode(this.root, numeroNo);
    }
    
    public String getDisplayNode() {
        return displayNode;
    }
    
    public String getMensagem() {
        return mensagem;
    }

}