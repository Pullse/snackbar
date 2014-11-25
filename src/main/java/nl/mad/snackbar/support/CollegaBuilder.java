package nl.mad.snackbar.support;

import nl.mad.snackbar.model.Collega;
import nl.mad.snackbar.model.Snack;
import nl.mad.snackbar.service.CollegaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegaBuilder {

    private Collega collega;

    @Autowired
    private CollegaService collegaService;

    public void checkExists() {
        if (collega == null) {
            collega = new Collega();
        }
    }

    public CollegaBuilder setNaam(String naam) {
        checkExists();
        collega.setNaam(naam);
        return this;
    }

    public CollegaBuilder setSnack(Snack snack) {
        checkExists();
        collega.setSnack(snack);
        return this;
    }

    public Collega create() {
        Collega collega = collegaService.create(this.collega);
        this.collega = null;
        return collega;
    }

}
