package nl.mad.snackbar.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Class for Snack object
 * @author Ruben Zorgman
 */
public class Snack {

    private long id;

    private String naam;

    //For Jackson to work well, one of the two relationships should not be serialized.
    @JsonManagedReference
    private List<Collega> collegas;

    public Snack(long id, String naam) {
        this.id = id;
        this.naam = naam;
        collegas = new ArrayList<Collega>();
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

    public List<Collega> getCollegas() {
        return collegas;
    }

    public void setCollegas(List<Collega> collegas) {
        this.collegas = collegas;
    }

    public void addCollega(Collega collega) {
        collegas.add(collega);
    }

}
