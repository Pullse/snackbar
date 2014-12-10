package nl.mad.snackbar.support;

import javax.annotation.PostConstruct;

import nl.mad.snackbar.model.Snack;
import org.hibernate.action.internal.CollectionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Populator {

    @Autowired
    private SnackBuilder snackBuilder;

    @Autowired
    private CollegaBuilder collegaBuilder;

    @PostConstruct
    public void populate() {
        Snack kipsate = snackBuilder.setNaam("Broodje kipsate").create();
        collegaBuilder.setNaam("Ruben Zorgman").setSnack(kipsate).create();
        Snack kroket = snackBuilder.setNaam("Kroket").create();
        collegaBuilder.setNaam("Piet Friet").setSnack(kroket).create();
        snackBuilder.setNaam("Broodje frikandel").create();
        snackBuilder.setNaam("Broodje bal").create();
        snackBuilder.setNaam("Ei met Ui").create();
        snackBuilder.setNaam("Broodje kroket").create();
        snackBuilder.setNaam("Losse frikandel").create();
        snackBuilder.setNaam("Losse kroket").create();
    }
}
