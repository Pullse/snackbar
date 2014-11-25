package nl.mad.snackbar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Class for Collega object.
 * @author Ruben Zorgman
 */
public class Collega {

    private long id;

    private String naam;

    @JsonBackReference
    private Snack snack;

    public Collega(long id, String naam, Snack snack) {
        this.id = id;
        this.naam = naam;
        this.snack = snack;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
