package nl.mad.snackbar.support;

import nl.mad.snackbar.SnackService;
import nl.mad.snackbar.model.Snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackBuilder {

    private Snack snack;

    @Autowired
    private SnackService snackService;

    public void checkExists() {
        if (snack == null) {
            snack = new Snack();
        }
    }

    public SnackBuilder setNaam(String naam) {
        checkExists();
        snack.setNaam(naam);
        return this;
    }

    public Snack create() {
        Snack snack = snackService.create(this.snack);
        this.snack = null;
        return snack;
    }

}
