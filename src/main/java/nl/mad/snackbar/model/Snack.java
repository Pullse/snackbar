package nl.mad.snackbar.model;

import javax.persistence.Entity;

/**
 * Class for Snack object
 * @author Ruben Zorgman
 */
@Entity
public class Snack extends BaseEntity {

    private String naam;

    public Snack() {

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

}
