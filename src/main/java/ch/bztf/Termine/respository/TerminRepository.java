package ch.bztf.Termine.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.bztf.Termine.model.Termin;

/**
 * StudentRespository
 * - Das ist eine Schnittstelle zur Datenbank
 */
@Repository // Spring Boot macht daraus eine StandardRepository
public interface TerminRepository extends CrudRepository<Termin, Long>{

    
}