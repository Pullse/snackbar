package nl.mad.snackbar.support;

import java.util.ArrayList;
import java.util.List;

import nl.mad.snackbar.model.Collega;
import nl.mad.snackbar.model.Snack;

public final class SnacksCreator {

    private SnacksCreator() {

    }

    public static List<Snack> getSnacks() {
        List<Snack> snacks = new ArrayList<Snack>();
        Snack frikandel = new Snack(1, "Frikandel");

        //TODO: verwijder dit. Tijdelijk aanmaken van Collegas voor testen van GET methode snacks.
        Collega bert = new Collega(100, "Bert Henkjes", frikandel);
        frikandel.addCollega(bert);
        Collega frans = new Collega(101, "Frans Molenaar", frikandel);
        frikandel.addCollega(frans);

        snacks.add(frikandel);

        Snack kroket = new Snack(2, "Kroket");
        snacks.add(kroket);
        Snack broodjePinda = new Snack(3, "Broodje pinda");
        snacks.add(broodjePinda);
        Snack gehaktbal = new Snack(4, "Gehaktbal");
        snacks.add(gehaktbal);
        Snack pizza = new Snack(5, "Pizza");
        snacks.add(pizza);
        Snack broodjeEiMetUi = new Snack(6, "Broodje ei met ui");
        snacks.add(broodjeEiMetUi);
        Snack viandel = new Snack(7, "Viandel");
        snacks.add(viandel);
        Snack kipsate = new Snack(8, "Kipsate");
        snacks.add(kipsate);
        Snack patat = new Snack(9, "Patat");
        snacks.add(patat);
        Snack hamburger = new Snack(10, "Hamburger");
        snacks.add(hamburger);
        return snacks;
    }
}
