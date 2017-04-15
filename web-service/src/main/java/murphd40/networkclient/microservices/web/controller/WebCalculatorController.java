package murphd40.networkclient.microservices.web.controller;

import murphd40.networkclient.microservices.web.client.rest.CalculatorServiceRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by David on 15/04/2017.
 */
@RestController
@RequestMapping("/calculate")
public class WebCalculatorController {

    @Autowired
    private CalculatorServiceRestClient calculatorServiceRestClient;

    @RequestMapping
    public ResponseEntity<String> calculate() {
        return ResponseEntity.ok(calculatorServiceRestClient.calculate("1+1"));
    }

}
