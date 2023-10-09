import java.math.RoundingMode;
import java.util.Random;
import java.math.BigDecimal;
public class Testes {
    public void AVLTreeTest(int insertQuantity){
        AVLTree arvoreAVL = new AVLTree();
        Random random = new Random();

        //Inserção
        long startTime = System.nanoTime();
        for(int i = 0; i <= insertQuantity; i++) {
            int randomNumber = random.nextInt(insertQuantity);
            arvoreAVL.insert(randomNumber);
        }
        long endTime = System.nanoTime();
        double result = endTime - startTime;
        System.out.println("Resultado do teste com " + insertQuantity + " inserções: " + new BigDecimal(result / 1000000000).setScale(8, RoundingMode.CEILING).toPlainString());

        //Busca
        long startTimeBusca = System.nanoTime();
        for(int i = 0; i <= insertQuantity; i++) {
            int randomNumber = random.nextInt(insertQuantity);
            arvoreAVL.search(arvoreAVL.getRoot(),randomNumber);
        }
        long endTimeBusca = System.nanoTime();
        double resultBusca = endTimeBusca - startTimeBusca;
        System.out.println("Resultado do teste com " + insertQuantity + " Buscas: " + new BigDecimal(resultBusca / 1000000000).setScale(8, RoundingMode.CEILING).toPlainString());

        //Remove
        long startTimeRemove = System.nanoTime();
        for(int i = 0; i <= insertQuantity; i++) {
            int randomNumber = random.nextInt(insertQuantity);
            arvoreAVL.remove(randomNumber);
        }
        long endTimeRemove = System.nanoTime();
        double resultRemove = endTimeRemove - startTimeRemove ;
        System.out.println("Resultado do teste com " + insertQuantity + " remoções: " + new BigDecimal(resultRemove / 1000000000).setScale(8, RoundingMode.CEILING).toPlainString());
        System.out.println();
    }

    public void BinaryTreeTest(int insertQuantity){
        Tree arvore = new Tree();
        Random random = new Random();

        //Inserção
        long startTime = System.nanoTime();
        for(int i = 0; i <= insertQuantity; i++) {
            int randomNumber = random.nextInt(insertQuantity);
            arvore.insert(randomNumber);
        }
        long endTime = System.nanoTime();
        double result = endTime - startTime;
        System.out.println("Resultado do teste com " + insertQuantity + " inserções: " + new BigDecimal(result / 1000000000).setScale(8, RoundingMode.CEILING).toPlainString());

        //Busca
        long startTimeBusca = System.nanoTime();
        for(int i = 0; i <= insertQuantity; i++) {
            int randomNumber = random.nextInt(insertQuantity);
            arvore.search(arvore.getRoot(),randomNumber);
        }
        long endTimeBusca = System.nanoTime();
        double resultBusca = endTimeBusca - startTimeBusca;
        System.out.println("Resultado do teste com " + insertQuantity + " Buscas: " + new BigDecimal(resultBusca / 1000000000).setScale(8, RoundingMode.CEILING).toPlainString());

        //Remove
        long startTimeRemove = System.nanoTime();
        for(int i = 0; i <= insertQuantity; i++) {
            int randomNumber = random.nextInt(insertQuantity);
            arvore.remove(randomNumber);
        }
        long endTimeRemove = System.nanoTime();
        double resultRemove = endTimeRemove - startTimeRemove ;
        System.out.println("Resultado do teste com " + insertQuantity + " remoções: " + new BigDecimal(resultRemove / 1000000000).setScale(8, RoundingMode.CEILING).toPlainString());

        System.out.println();
    }

}
