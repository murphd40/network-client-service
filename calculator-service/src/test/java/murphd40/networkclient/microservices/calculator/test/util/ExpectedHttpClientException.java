package murphd40.networkclient.microservices.calculator.test.util;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by David on 20/04/2017.
 */
public class ExpectedHttpClientException implements TestRule {

    private HttpStatus expectedStatus;

    private ExpectedHttpClientException() {

    }

    public static ExpectedHttpClientException none() {
        return new ExpectedHttpClientException();
    }

    public void expect(HttpStatus expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new ExpectedHttpClientExceptionStatement(base);
    }

    private class ExpectedHttpClientExceptionStatement extends Statement {
        private final Statement next;

        public ExpectedHttpClientExceptionStatement(Statement base) {
            next = base;
        }

        @Override
        public void evaluate() throws Throwable {
            try {
                next.evaluate();
            } catch (HttpClientErrorException e) {
                handleException(e);
                return;
            }
            if (isAnyExceptionExpected()) {
                fail(String.format("Expected exception of type %s with HTTP status %s", HttpClientErrorException.class.toString(), expectedStatus.toString()));
            }
        }
    }

    private void handleException(HttpClientErrorException e) {
        if (isAnyExceptionExpected()) {
            assertThat(e.getStatusCode(), is(expectedStatus));
        } else {
            throw e;
        }
    }

    private boolean isAnyExceptionExpected() {
        return expectedStatus != null;
    }

}
