package nl.mad.snackbar.repository;

import java.util.List;

import nl.mad.snackbar.model.Collega;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegaRepository extends JpaRepository<Collega, Long> {

    List<Collega> findBySnackId(Long snackId);

}
