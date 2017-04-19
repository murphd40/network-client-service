package murphd40.networkclient.microservices.calculator.service.impl;

import murphd40.networkclient.microservices.calculator.service.CalculatorService;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by David on 19/04/2017.
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String evaluate(String expression) {
        Assert.isTrue(StringUtils.isNotBlank(expression), "expression must not be blank");

        double result = new ExpressionBuilder(expression).build().evaluate();
        return String.valueOf(result);
    }

}
