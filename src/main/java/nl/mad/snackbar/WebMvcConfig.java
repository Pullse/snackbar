package nl.mad.snackbar;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class with the Web MVC configuration.
 * @author Ruben Zorgman
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "nl.mad.snackbar",
        includeFilters = { @Filter(Controller.class) },
        excludeFilters = { @Filter(Service.class), @Filter(Repository.class), @Filter(Configuration.class) })
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJacksonHttpMessageConverter());
    }

    /**
     * Maps Jackson to convert Http Messages.
     * @return MappingJackson2HttpMessageConverter
     */
    private MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    /**
     * Gets a new instance of ObjectMapper.
     * @return ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
