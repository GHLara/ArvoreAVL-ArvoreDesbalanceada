public class AVLTree {
    private Node root;

    // Passa pela arvore, In order
    public boolean search(Node node, int value) {
        if (node == null) return false;

        // Passa pela subarvore da esquerda
        if (node.getValue() < value) {
            return search(node.getLeft(), value);
        }

        // Passa pela subarvore da direita
        if (node.getValue() > value) {
            return search(node.getRight(), value);
        }

        return true;
    }


    public boolean insert(int value) {
        root = insert(root, value);
        return true;
    }

    public Node insert(Node node, int value){
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getValue()) {
            //Insere na esquerda
            node.setLeft(insert(node.getLeft(), value));
        }
        else if (value > node.getValue()) {
            //Insere na Direita
            node.setRight(insert(node.getRight(), value));
        }

        update(node);
        return reBalance(node);
    }

    public boolean remove(int elem) {

        if (search(root, elem)) {
            root = remove(root, elem);
            return true;
        }

        return false;
    }

    private Node remove(Node node, int value) {
        if (node == null){
            return null; //Não encontrou o valor
        }

        if (value < node.getValue()) { //Se for menor, procura na esquerda
            node.setLeft(remove(node.getLeft(), value));
        }
        else if (value > node.getValue()) { //Se for maior, procura na direita
            node.setRight(remove(node.getRight(), value));
        }
        else { //encontramos o valor
            if (node.getLeft() == null) { //Só filho direita
                return node.getRight(); //Troca o valor removido pelo filho da direita
            }
            else if (node.getRight() == null) {//Só filho esquerda
                return node.getLeft(); //Troca o valor removido pelo filho da esquerda
            }
            else { //filho dos dois lados
                //Ve qual lado é maior, esquerda ou direita
                if (node.getLeft().getHeight() > node.getRight().getHeight()) {
                    int successorValue = findMax(node.getLeft()); //Acha o maior valor da esquerda
                    node.setValue(successorValue); //Muda o valor do nó pro maior valor da esquerda
                    node.setLeft(remove(node.getLeft(), successorValue)); //Remove o valor sucessor
                }
                else {
                    //Mema coisa mas pra direita
                    int successorValue = findMin(node.getRight());
                    node.setValue(successorValue);
                    node.setRight(remove(node.getRight(), successorValue));
                }
            }
        }

        update(node);
        return reBalance(node);
    }

    private int findMin(Node node) { //Acha o menor
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    private int findMax(Node node) { //Acha o maior
        while (node.getRight() != null){
            node = node.getRight();
        }
        return node.getValue();
    }


    private static int findHeight(Node node){
        //Basicamente o código disponível nos slides para encontrar a altura
        if (node == null) {
            return -1;
        } else {
            int leftHeight = findHeight(node.getLeft());
            int rightHeight = findHeight(node.getRight());

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    private void update(Node node){
        //Atualiza a altura e o fator de balanceamento
        //Basicamente copiei o que tava nos slides e alterei algumas coisas
        //Para ajustar ao meu código
        int leftHeight = findHeight(node.getLeft());
        int rightHeight = findHeight(node.getRight());

        if (leftHeight > rightHeight) {
            node.setHeight(leftHeight + 1);
        } else {
            node.setHeight(rightHeight + 1);
        }

        node.setBalanceFactor(rightHeight - leftHeight);
    }

    private Node reBalance(Node node){
        int bf = node.getBalanceFactor();

        if (bf == -2) {
            if (node.getLeft().getBalanceFactor() <= 0) {
                return leftLeftCase(node);
            } else {
                return leftRightCase(node);
            }
        } else if (bf == 2) {
            if (node.getRight().getBalanceFactor() >= 0) {
                return rightRightCase(node);
            } else {
                return rightLeftCase(node);
            }
        }

        return node;
    }

    private Node leftLeftCase(Node node){ //Rotação simples
        return rightRotation(node);
    }

    private Node leftRightCase(Node node){ //Rotação dupla
        node.setLeft(leftRotation(node.getLeft()));
        return  leftLeftCase(node);
    }

    private Node rightRightCase(Node node) {
        return leftRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.setRight(rightRotation(node.getRight()));

        return rightRightCase(node);
    }

    private Node leftRotation(Node node){ //Codigo mostrado nos slides da aula
        Node novaRaiz = node.getRight();
        Node temp = novaRaiz.getLeft();
        novaRaiz.setLeft(node);
        node.setRight(temp);

        return novaRaiz;
    }

    private Node rightRotation(Node node){
        Node novaRaiz = node.getLeft();
        Node temp = novaRaiz.getRight();
        novaRaiz.setRight(node);
        node.setLeft(temp);

        return novaRaiz;
    }


    public Node getRoot() {
        return root;
    }

    public void print2DUtil(Node root, int space) //Da pra visualizar a árvore mas é inútil quando tem muito node
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        print2DUtil(root.getRight(), space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getValue() + "\n");

        // Process left child
        print2DUtil(root.getLeft(), space);
    }

}
