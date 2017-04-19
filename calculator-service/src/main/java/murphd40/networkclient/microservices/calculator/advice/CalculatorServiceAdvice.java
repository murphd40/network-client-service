package murphd40.networkclient.microservices.calculator.advice;

import murphd40.networkclient.microservices.calculator.service.exception.CalculatorServiceException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by David on 19/04/2017.
 */
@Component
@Aspect
public class CalculatorServiceAdvice {

    @Pointcut("execution(* murphd40.networkclient.microservices.calculator.service.CalculatorService.*(..) )")
    public void anyCalculatorServiceMethod() {}

    @AfterThrowing(pointcut = "anyCalculatorServiceMethod()", throwing = "t")
    public void wrapException(Throwable t) {
        throw new CalculatorServiceException(t);
    }

}
