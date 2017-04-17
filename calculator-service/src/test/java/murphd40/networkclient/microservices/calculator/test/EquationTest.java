package murphd40.networkclient.microservices.calculator.test;

import murphd40.networkclient.microservices.calculator.model.Equation;
import murphd40.networkclient.microservices.calculator.model.Node;
import murphd40.networkclient.microservices.calculator.model.OperatorNode;
import murphd40.networkclient.microservices.calculator.model.ValueNode;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by David on 16/04/2017.
 */
public class EquationTest {

    private Node head, prev;

    @Before
    public void init() {
        head = null;
        prev = null;
    }

    @Test
    public void equationTest() {

        value(10);
        operator(Equation.Operator.add);
        value(5);
        operator(Equation.Operator.multiply);
        value(3);
        operator(Equation.Operator.multiply);
        value(2);

        System.out.println(head.evaluate());

    }

    @Test
    public void equationTest2() {
        value(10);
        operator(Equation.Operator.multiply);
        value(5);
        operator(Equation.Operator.subtract);
        value(4);

        System.out.println(head.evaluate());
    }

    private void value(Number number) {

        Node node = new ValueNode(number);

        if (head == null) {
            head = node;
        } else {
            prev.setRight(node);
            node.setParent(prev);
        }

        prev = node;
    }

    private void operator(Equation.Operator operator) {

        OperatorNode node = new OperatorNode(operator);

        if (head == null) {
            throw new IllegalArgumentException("Equation cannot start with an operator!");
        }

        if (head instanceof ValueNode) {
            node.setLeft(head);
            head.setParent(node);
            head = node;
        } else {
            OperatorNode headOperator = (OperatorNode) head;

            if (headOperator.getOperator().getPrecedence() > operator.getPrecedence()) {
                // new head
                node.setLeft(head);
                head.setParent(node);
                head = node;
            } else {
                node.setLeft(prev);
                prev.getParent().setRight(node);
                prev.setParent(node);
            }
        }

        prev = node;
    }

}
