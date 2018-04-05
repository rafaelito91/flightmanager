package br.com.flightmanager.aircraft;

import org.springframework.data.repository.CrudRepository;

/**
 * Responsible for persistence operations related to {@link Aircraft} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see AircraftServices
 */
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {
}
