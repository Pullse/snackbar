package nl.mad.snackbar;

import java.util.List;

import nl.mad.snackbar.model.Snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SnackService {

    private final SnackRepository snackRepository;

    @Autowired
    public SnackService(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    public List<Snack> findAll() {
        return snackRepository.findAll();
    }

    public Snack create(Snack snack) {
        return snackRepository.save(snack);
    }
}
