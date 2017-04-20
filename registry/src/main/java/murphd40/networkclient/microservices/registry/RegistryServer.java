package murphd40.networkclient.microservices.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by David on 14/04/2017.
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryServer {

    public static void main(String[] args) {
        SpringApplication.run(RegistryServer.class, args);
    }
}