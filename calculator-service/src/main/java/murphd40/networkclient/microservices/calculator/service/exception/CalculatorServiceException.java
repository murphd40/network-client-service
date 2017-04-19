package murphd40.networkclient.microservices.calculator.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by David on 19/04/2017.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CalculatorServiceException extends RuntimeException {

    public CalculatorServiceException() {
        super();
    }

    public CalculatorServiceException(String message) {
        super(message);
    }

    public CalculatorServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculatorServiceException(Throwable cause) {
        super(cause);
    }
}
