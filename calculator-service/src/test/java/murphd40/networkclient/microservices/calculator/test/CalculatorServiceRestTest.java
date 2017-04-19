package murphd40.networkclient.microservices.calculator.test;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by David on 19/04/2017.
 */
public class CalculatorServiceRestTest extends BaseCalculatorServiceRestTest {

    @Test
    public void calculateRequestEvaluatesExpression() {
        String expected = String.valueOf(0.5 + 2 * (.9 + 4) - 3);
        String result = calculateRequest("0.5 + 2 * (.9 + 4) - 3");

        assertThat(result, is(expected));
    }

    @Test
    public void calculatorServiceRestTest() {
        expectedHttpClientException.expect(HttpStatus.BAD_REQUEST);
        calculateRequest("not an expression");
    }
    
}
