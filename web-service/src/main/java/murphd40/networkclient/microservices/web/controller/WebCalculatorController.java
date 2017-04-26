package murphd40.networkclient.microservices.web.controller;

import murphd40.networkclient.microservices.web.client.rest.CalculatorServiceRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by David on 15/04/2017.
 */
@RestController
@RequestMapping("/calculate")
public class WebCalculatorController {

    @Autowired
    private CalculatorServiceRestClient calculatorServiceRestClient;

    @RequestMapping("/{equation:.*}")
    public ResponseEntity<String> calculate(@PathVariable String equation) {
        String result = calculatorServiceRestClient.calculate(equation);
        return ResponseEntity.ok(result);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ModelAndView handleClientError() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bad-request");
        return modelAndView;
    }

}
