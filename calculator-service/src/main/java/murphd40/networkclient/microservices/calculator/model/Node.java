package murphd40.networkclient.microservices.calculator.model;

/**
 * Created by David on 16/04/2017.
 */
public abstract class Node {

    Node left, right, parent;

    public abstract Number evaluate();

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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
