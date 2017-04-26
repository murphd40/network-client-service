package murphd40.networkclient.microservices.web.test;

import murphd40.networkclient.microservices.web.client.rest.CalculatorServiceRestClient;
import murphd40.networkclient.microservices.web.controller.WebCalculatorController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by David on 26/04/2017.
 */
public class WebServiceRestTest extends BaseWebServiceRestTest {

    @Mock
    private CalculatorServiceRestClient calculatorServiceRestClient;

    @InjectMocks
    @Autowired
    private WebCalculatorController webCalculatorController;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validRequestTest() {
        Mockito.doReturn("2").when(calculatorServiceRestClient).calculate(Mockito.anyString());
        assertThat(calculateRequest("1+1"), is("2"));
    }

    @Test
    public void badRequestTest() {
        Mockito.doThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST)).when(calculatorServiceRestClient).calculate(Mockito.anyString());
        assertTrue(calculateRequest("1+1").contains("400 BAD_REQUEST"));
    }

}
