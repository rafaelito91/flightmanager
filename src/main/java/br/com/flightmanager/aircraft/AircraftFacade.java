package br.com.flightmanager.aircraft;

import br.com.flightmanager.restapi.AircraftController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Orchestrate services related to {@link Aircraft} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see AircraftController
 */
@Component
@AllArgsConstructor
public class AircraftFacade {

    private final AircraftServices aircraftServices;

    /**
     * Obtains all flight objects persisted in the database
     *
     * @return A {@link List} of {@link Aircraft} objects
     */
    public List<Aircraft> obtainAircrafts() {
        return aircraftServices.obtainAircrafts();
    }
}
