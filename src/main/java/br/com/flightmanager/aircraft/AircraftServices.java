package br.com.flightmanager.aircraft;

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Responsible for providing operations related to {@link Aircraft} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see AircraftFacade
 */
@Service
@AllArgsConstructor
public class AircraftServices {

    private final AircraftRepository aircraftRepository;

    /**
     * Obtains all flight objects persisted in the database
     *
     * @return A {@link List} of {@link Aircraft} objects
     */
    public List<Aircraft> obtainAircrafts() {
        return IterableUtils.toList(aircraftRepository.findAll());
    }
}
