package br.com.flightmanager.aircraft;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;

/**
 * Responsible for persistence operations related to {@link Aircraft} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see AircraftServices
 */
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

    @Query("select e from #{#entityName} e where e.id = ?1 or (?1 = null and e.model = ?2)")
    Aircraft getExisting(Long id, String model);
}
