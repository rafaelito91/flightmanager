package br.com.flightmanager.flight;

import br.com.flightmanager.employee.Employee;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Responsible for providing operations related to {@link Flight} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see FlightFacade
 */
@Service
@AllArgsConstructor
public class FlightServices {

    private final FlightRepository flightRepository;

    /**
     * Obtains all flight objects persisted in the database
     *
     * @return A {@link List} of {@link Flight} objects
     */
    public List<Flight> obtainFlights() {
        return IterableUtils.toList(flightRepository.findAll());
    }

    /**
     * Obtains a certain {@link Flight} object by its Id
     * @param id Id of the requested {@link Flight}
     * @return Requested {@link Flight}
     */
    public Flight obtainFlightById(Long id) {
        return flightRepository.findById(id).get();
    }
}
