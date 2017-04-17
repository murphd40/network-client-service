package murphd40.networkclient.microservices.calculator.model;

/**
 * Created by David on 16/04/2017.
 */
public class OperatorNode extends Node {

    private Equation.Operator operator;

    public OperatorNode(Equation.Operator operator) {
        this.operator = operator;
    }

    public Equation.Operator getOperator() {
        return operator;
    }

    @Override
    public Number evaluate() {
        return operator.apply(left.evaluate(), right.evaluate());
    }

    @Override
    public String toString() {
        return "OperatorNode{" +
                "operator=" + operator +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
