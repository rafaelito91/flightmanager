package br.com.flightmanager.flight.city;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;

/**
 * Responsible for persistence operations related to {@link City} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 */
public interface CityRepository extends CrudRepository<City, Long> {

    @Query("select c from #{#entityName} c where c.id = ?1 or (?1 = null and c.name = ?2)")
    City getExisting(Long id, String name);
}
