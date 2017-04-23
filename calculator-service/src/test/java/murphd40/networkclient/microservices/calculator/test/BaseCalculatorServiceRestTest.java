package murphd40.networkclient.microservices.calculator.test;

import murphd40.networkclient.microservices.calculator.test.util.ExpectedHttpClientException;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by David on 19/04/2017.
 */
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = BaseCalculatorServiceRestTest.RestTestConfig.class)
public abstract class BaseCalculatorServiceRestTest extends BaseSpringBootTest {

    @Rule
    public final ExpectedHttpClientException expectedHttpClientException = ExpectedHttpClientException.none();

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    public String calculateRequest(String expression) {
        String uri = uriBuilder().path("/calculator").toUriString();
        return restTemplate.postForObject(uri, expression, String.class);
    }

    private UriComponentsBuilder uriBuilder() {
        return UriComponentsBuilder.fromHttpUrl("http://localhost").port(port);
    }

    @TestConfiguration
    public static class RestTestConfig {

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }

    }

}
