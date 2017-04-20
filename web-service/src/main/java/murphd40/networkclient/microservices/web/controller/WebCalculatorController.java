package murphd40.networkclient.microservices.web.controller;

import murphd40.networkclient.microservices.web.client.rest.CalculatorServiceRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/{equation}")
    public ResponseEntity<String> calculate(Model model, @PathVariable String equation) {
        model.addAttribute("equation", equation);
        String result = calculatorServiceRestClient.calculate(equation);
        model.addAttribute("result", result);
        return ResponseEntity.ok(result);
    }

}
