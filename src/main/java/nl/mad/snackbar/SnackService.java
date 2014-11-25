package nl.mad.snackbar;

import java.util.List;

import nl.mad.snackbar.model.Snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackService {

    @Autowired
    private SnackRepository snackRepository;

    public List<Snack> getAllSnacks() {
        return snackRepository.getAllSnacks();
    }

}
