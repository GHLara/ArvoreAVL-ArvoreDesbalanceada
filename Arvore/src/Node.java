public class Node {
    private int value;
    private Node left;
    private Node right;
    private int height;
    private int balanceFactor;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBalanceFactor() {return balanceFactor;}

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

}
