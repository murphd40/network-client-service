package murphd40.networkclient.microservices.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by David on 15/04/2017.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CalculatorServer {

    public static void main(String[] args) {
        SpringApplication.run(CalculatorServer.class, args);
    }

}
