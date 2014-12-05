package nl.mad.snackbar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.mad.snackbar.AbstractSpringContextTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by ruben on 5-12-2014.
 */
public class ControllerTest{

    protected MockMvc webClient;

    protected void initWebClient(Object controller) {

        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(new ObjectMapper());

        this.webClient = MockMvcBuilders.standaloneSetup(controller).setMessageConverters(messageConverter).build();
    }
}
