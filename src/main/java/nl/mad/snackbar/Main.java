package nl.mad.snackbar;

import nl.mad.snackbar.model.Collega;
import nl.mad.snackbar.model.Snack;

public class Main {

    public static void main(String[] args) {
        SnackService snackService = new SnackService();
        for (Snack snack : snackService.getAllSnacks()) {
            System.out.println(snack.getNaam());
            if (!snack.getCollegas().isEmpty()) {
                for (Collega collega : snack.getCollegas()) {
                    System.out.println("-Collega: " + collega.getNaam());
                }
            }
        }

    }

}
