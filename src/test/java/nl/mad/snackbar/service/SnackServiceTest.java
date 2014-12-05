package nl.mad.snackbar.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import nl.mad.snackbar.AbstractSpringContextTest;
import nl.mad.snackbar.model.Snack;
import nl.mad.snackbar.service.SnackService;
import nl.mad.snackbar.support.SnackBuilder;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SnackServiceTest extends AbstractSpringContextTest {

    @Autowired
    private SnackService snackService;

    @Autowired
    private SnackBuilder snackBuilder;

    @Test
    public void create() {
        snackBuilder.setNaam("Frikandel").create();
        List<Snack> snacks = snackService.findAll();
        assertEquals(4, snacks.size());
        assertEquals("Broodje kipsate", snacks.get(0).getNaam());
    }
}
