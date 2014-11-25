package nl.mad.snackbar.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Class for Collega object.
 * @author Ruben Zorgman
 */
@Entity
public class Collega extends BaseEntity {

    private String naam;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Snack snack;

    public Collega() {

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Snack getSnack() {
        return snack;
    }

    public void setSnack(Snack snack) {
        this.snack = snack;
    }

}
