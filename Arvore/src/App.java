public class App {
    public static void main(String[] args) throws Exception {

        Testes teste = new Testes();
        System.out.println("-------TESTES COM ARVORE AVL-------");
        teste.AVLTreeTest(100);
        teste.AVLTreeTest(500);
        teste.AVLTreeTest(1000);
        teste.AVLTreeTest(10000);
        teste.AVLTreeTest(20000);

        System.out.println("-------TESTES COM ARVORE DESBALANCEADA-------");
        teste.BinaryTreeTest(100);
        teste.BinaryTreeTest(500);
        teste.BinaryTreeTest(1000);
        teste.BinaryTreeTest(10000);
        teste.BinaryTreeTest(20000);

    }
}
