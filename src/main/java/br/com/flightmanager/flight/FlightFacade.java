package br.com.flightmanager.flight;

import br.com.flightmanager.flight.city.City;
import br.com.flightmanager.restapi.FlightController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Orchestrate services related to {@link Flight} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see FlightController
 */
@Component
@AllArgsConstructor
public class FlightFacade {

    private final FlightServices flightService;

    /**
     * Obtains all city objects persisted in the database
     * @return A {@link List} of {@link City} objects
     */
    public List<City> obtainCities() {
        return flightService.obtainCities();
    }

    /**
     * Obtains all flight objects persisted in the database
     *
     * @return A {@link List} of {@link Flight} objects
     */
    public List<Flight> obtainFlights() {
        return flightService.obtainFlights();
    }

    /**
     * Obtains a certain {@link Flight} object by its Id
     * @param id Id of the requested {@link Flight}
     * @return Requested {@link Flight}
     */
    public Flight obtainFlightById(Long id) {
        return flightService.obtainFlightById(id);
    }

    @Transactional
    public Flight registerFlight(Flight flight) {
        return null;
    }
}
