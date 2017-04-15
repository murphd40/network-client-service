package murphd40.networkclient.microservices.calculator.service;

import murphd40.networkclient.microservices.calculator.model.Equation;
import org.springframework.stereotype.Service;

/**
 * Created by David on 15/04/2017.
 */
@Service
public class EquationParserService {

    private static final String NUMBER_REGEX = "[\\d.]+";
    private static final String OPERATOR_REGEX = "[+\\-*/x]";

    public Equation parse(String equation) {
        return Equation.newBuilder().build();
    }

}
