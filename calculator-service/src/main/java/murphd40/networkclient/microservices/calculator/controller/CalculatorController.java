package murphd40.networkclient.microservices.calculator.controller;

import murphd40.networkclient.microservices.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by David on 15/04/2017.
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> calculate(@RequestBody String equation) {
        return ResponseEntity.ok(calculatorService.evaluate(equation));
    }

}
