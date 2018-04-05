package br.com.flightmanager.flight.city;

import org.springframework.data.repository.CrudRepository;

/**
 * Responsible for persistence operations related to {@link City} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 */
public interface CityRepository extends CrudRepository<City, Long> {
}
