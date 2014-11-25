package nl.mad.snackbar.service;

import java.util.List;

import nl.mad.snackbar.model.Collega;
import nl.mad.snackbar.repository.CollegaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CollegaService {

    private final CollegaRepository collegaRepository;

    @Autowired
    public CollegaService(CollegaRepository collegaRepository) {
        this.collegaRepository = collegaRepository;
    }

    public List<Collega> findAll() {
        return collegaRepository.findAll();
    }

    public Collega create(Collega collega) {
        return collegaRepository.save(collega);
    }

    public List<Collega> findBySnackId(Long snackId) {
        return collegaRepository.findBySnackId(snackId);
    }

}
