package murphd40.networkclient.microservices.web.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by David on 15/04/2017.
 */
@Component
public class CalculatorServiceRestClient {

    @LoadBalanced
    @Autowired
    private RestTemplate restTemplate;

    public String calculate(String equation) {
        return restTemplate.postForObject("http://calculator-service/calculator", equation, String.class);
    }

}
