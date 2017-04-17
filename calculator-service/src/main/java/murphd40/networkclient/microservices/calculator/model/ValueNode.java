package murphd40.networkclient.microservices.calculator.model;

/**
 * Created by David on 16/04/2017.
 */
public class ValueNode extends Node {

    private final Number value;

    public ValueNode(Number value) {
        this.value = value;
    }

    @Override
    public Number evaluate() {
        return value;
    }

    @Override
    public void setLeft(Node left) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRight(Node right) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "ValueNode{" +
                "value=" + value +
                '}';
    }
}
