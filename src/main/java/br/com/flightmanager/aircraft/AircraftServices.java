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

    /**
     * Obtains a entity object (if exists) in the database that has the same core attributes as the informed entity.
     * Otherwise, returns the informed entity
     * @param aircraft informed entity
     * @return The existing entity on the database or the informed entity
     */
    public Aircraft getExistingAircraft(Aircraft aircraft) {
        Aircraft existingAircraft = aircraftRepository.getExisting(aircraft.getId(), aircraft.getModel());
        return existingAircraft == null ? aircraft : existingAircraft;
    }
}
