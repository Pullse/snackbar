package nl.mad.snackbar.support;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Populator {

    @Autowired
    private SnackBuilder snackBuilder;

    @PostConstruct
    public void populate() {
        snackBuilder.setNaam("Broodje kipsate").create();
        snackBuilder.setNaam("Kroket").create();
        snackBuilder.setNaam("Broodje frikandel").create();
    }
}
