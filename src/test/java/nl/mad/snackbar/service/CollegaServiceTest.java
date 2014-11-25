package nl.mad.snackbar.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import nl.mad.snackbar.AbstractSpringContextTest;
import nl.mad.snackbar.model.Collega;
import nl.mad.snackbar.model.Snack;
import nl.mad.snackbar.support.CollegaBuilder;
import nl.mad.snackbar.support.SnackBuilder;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CollegaServiceTest extends AbstractSpringContextTest {

    @Autowired
    private CollegaService collegaService;

    @Autowired
    private CollegaBuilder collegaBuilder;

    @Autowired
    private SnackBuilder snackBuilder;

    @Test
    public void create() {
        Snack snack = snackBuilder.setNaam("Frikandel").create();
        collegaBuilder.setNaam("Frans Duits").setSnack(snack).create();
        List<Collega> collegas = collegaService.findAll();
        assertEquals(1, collegas.size());
        Collega collega = collegas.get(0);
        assertEquals("Frans Duits", collega.getNaam());
        assertEquals("Frikandel", collega.getSnack().getNaam());
    }

    @Test
    public void findBySnackId() {
        Snack snack = snackBuilder.setNaam("Frikandel").create();
        collegaBuilder.setNaam("Frans Duits").setSnack(snack).create();
        collegaBuilder.setNaam("Frans Engels").setSnack(snack).create();
        collegaBuilder.setNaam("Frans Frans").setSnack(snack).create();
        Snack bal = snackBuilder.setNaam("Broodje bal").create();
        collegaBuilder.setNaam("Frans Pools").setSnack(bal).create();
        List<Collega> collegas = collegaService.findBySnackId(snack.getId());
        assertEquals(3, collegas.size());
        String[] mustMatch = new String[] { "Frans Duits", "Frans Engels", "Frans Frans" };
        assertInRange(mustMatch, collegas.get(0));
        assertInRange(mustMatch, collegas.get(1));
        assertInRange(mustMatch, collegas.get(2));
    }

    public void assertInRange(String[] mustMatch, Collega collega) {
        for (String match : mustMatch) {
            if (match.equals(collega.getNaam())) {
                return;
            }
        }
        fail("No match found for: " + collega.getNaam());
    }
}
