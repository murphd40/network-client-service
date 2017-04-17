package murphd40.networkclient.microservices.calculator.model;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * Created by David on 15/04/2017.
 */
public class Equation {

    private List<Number> numbers;

    private List<Operator> operators;

    public Number evaluate() {
        return 0;
    }

    public enum Operator {
        add((x, y) -> x.doubleValue() + y.doubleValue(), 0, "+"),
        subtract((x, y) -> x.doubleValue() - y.doubleValue(), 0, "-"),
        multiply((x, y) -> x.doubleValue() * y.doubleValue(), 1,"x", "*"),
        divide((x, y) -> x.doubleValue() / y.doubleValue(), 1, "/");

        private BiFunction<Number, Number, Number> function;
        private int precedence;
        private Set<String> symbols;

        Operator(BiFunction<Number, Number, Number> function, int precedence, String... symbols) {
            this.function = function;
            this.precedence = precedence;
            this.symbols = Sets.newHashSet(symbols);
        }

        public static Operator of(String symbol) {
            for (Operator operator : Operator.values()) {
                if (operator.symbols.contains(symbol)) {
                    return operator;
                }
            }

            throw new IllegalArgumentException(String.format("Symbol [%s] not recognized", symbol));
        }

        public Number apply(Number lhs, Number rhs) {
            return function.apply(lhs, rhs);
        }

        public int getPrecedence() {
            return precedence;
        }

    }

    private Equation() {}

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Builder() {

        }

        public Equation build() {
            return new Equation();
        }

    }

}
