package nl.mad.snackbar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mockit.*;
import nl.mad.snackbar.AbstractSpringContextTest;
import nl.mad.snackbar.model.Snack;
import nl.mad.snackbar.repository.SnackRepository;
import nl.mad.snackbar.service.SnackService;
import nl.mad.snackbar.support.SnackBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SnackControllerTest extends ControllerTest{

    @Injectable
    private SnackService snackService;

    private SnackController snackController;

    @Before
    public void setup(){
        snackController = new SnackController(snackService);
        Deencapsulation.setField(snackController, "snackService", snackService);
        this.initWebClient(snackController);
    }

    @Test
    public void getSnacks() throws Exception{
        webClient.perform(get("/snacks")).andExpect(status().isOk());
        new Verifications() {
            {
                snackService.findAll();
            }
        };
    }

}
