package murphd40.networkclient.microservices.calculator.controller;

import murphd40.networkclient.microservices.calculator.service.EquationParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by David on 15/04/2017.
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private EquationParserService equationParserService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> calculate(@RequestBody String equation) {
        return ResponseEntity.ok(equationParserService.parse(equation).evaluate().toString());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity exceptionHandler() {
        return ResponseEntity.badRequest().build();
    }

}
