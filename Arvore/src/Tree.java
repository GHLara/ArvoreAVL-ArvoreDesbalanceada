public class Tree {
    private Node root;
    public boolean insert(int value) {
        root = insert(root, value);
        return true;
    }

    public boolean search(Node node, int value) {
        if (node == null) return false;

        // Dig into left subtree.
        if (node.getValue() < value) {
            return search(node.getLeft(), value);
        }

        // Dig into right subtree.
        if (node.getValue() > value) {
            return search(node.getRight(), value);
        }

        // Found value in tree.
        return true;
    }
    public Node insert(Node node, int value){ //current node irá mudar conforme percorremos a árvore

        if(node == null){
            return new Node(value);
        }

        //se meu novo node é menor, o valor deve ir para a esquerda
        if(node.getValue() < value){
            node.setLeft(insert(node.getLeft(), value));
        }
        //se meu novo node é maior, o valor deve ir parar a direita
        else{
            node.setRight(insert(node.getRight(), value));
        }

        return node;
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
        return node;
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

    public Node getRoot() {
        return root;
    }

    public void print2DUtil(Node root, int space)
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
