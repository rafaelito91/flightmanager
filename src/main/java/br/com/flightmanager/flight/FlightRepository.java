package br.com.flightmanager.flight;

import org.springframework.data.repository.CrudRepository;

/**
 * Responsible for persistence operations related to {@link Flight} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see FlightServices
 */
public interface FlightRepository extends CrudRepository<Flight, Long> {
}
