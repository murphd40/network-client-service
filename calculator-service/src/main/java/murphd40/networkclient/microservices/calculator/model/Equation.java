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
        add((x, y) -> x.doubleValue() + y.doubleValue(),"+"),
        subtract((x, y) -> x.doubleValue() - y.doubleValue(), "-"),
        multiply((x, y) -> x.doubleValue() * y.doubleValue(),"x", "*"),
        divide((x, y) -> x.doubleValue() / y.doubleValue(), "/");

        private BiFunction<Number, Number, Number> function;

        private Set<String> symbols;

        Operator(BiFunction<Number, Number, Number> function, String... symbols) {
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
