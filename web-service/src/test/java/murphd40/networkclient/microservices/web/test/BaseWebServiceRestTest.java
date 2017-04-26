package murphd40.networkclient.microservices.web.test;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class BaseWebServiceRestTest extends BaseSpringBootTest {

    @LocalServerPort
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    public String calculateRequest(String expression) {
        String uri = uriBuilder().path("/calculate/{expression}").buildAndExpand(expression).toUriString();
        return restTemplate.getForObject(uri, String.class);
    }

    private UriComponentsBuilder uriBuilder() {
        return UriComponentsBuilder.fromHttpUrl("http://localhost").port(port);
    }

}