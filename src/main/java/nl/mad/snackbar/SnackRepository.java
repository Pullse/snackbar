package nl.mad.snackbar;

import java.util.List;

import nl.mad.snackbar.model.Snack;
import nl.mad.snackbar.support.SnacksCreator;

import org.springframework.stereotype.Repository;

@Repository
public class SnackRepository {

    private List<Snack> snacks = SnacksCreator.getSnacks();

    public List<Snack> getAllSnacks() {
        return snacks;
    }

}
