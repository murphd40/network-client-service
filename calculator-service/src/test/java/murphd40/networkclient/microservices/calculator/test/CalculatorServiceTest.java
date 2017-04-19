package murphd40.networkclient.microservices.calculator.test;

import murphd40.networkclient.microservices.calculator.service.CalculatorService;
import murphd40.networkclient.microservices.calculator.service.exception.CalculatorServiceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

/**
 * Created by David on 19/04/2017.
 */
public class CalculatorServiceTest extends BaseSpringBootTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void calculatorServiceEvaluatesExpression() {
        String expected = String.valueOf(0.5 + 2 * (.9 + 4) - 3);
        String result = calculatorService.evaluate("0.5 + 2 * (.9 + 4) - 3");

        assertThat(result, is(expected));
    }

    @Test
    public void calculatorServiceNullExpression() {
        illegalArgumentTestInternal(null);
    }

    @Test
    public void calculatorServiceEmptyExpression() {
        illegalArgumentTestInternal("  ");
    }

    @Test
    public void calculatorServiceBadExpression() {
        illegalArgumentTestInternal("not an expression");
    }

    private void illegalArgumentTestInternal(String expression) {
        expectedException.expect(CalculatorServiceException.class);
        expectedException.expectCause(isA(IllegalArgumentException.class));
        calculatorService.evaluate(expression);
    }

}
