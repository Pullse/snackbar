package nl.mad.snackbar.service;

import java.util.List;

import nl.mad.snackbar.model.Snack;
import nl.mad.snackbar.repository.SnackRepository;

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

    public Snack findSnack(Long id){
        return snackRepository.findOne(id);
    }

    public List<Snack> findAll() {
        return snackRepository.findAll();
    }

    public Snack createSnack(Snack snack) {
        return snackRepository.save(snack);
    }

    public void deleteSnack(Snack snack){
        snackRepository.delete(snack);
    }

}
