package br.com.flightmanager.flight;

import br.com.flightmanager.aircraft.AircraftServices;
import br.com.flightmanager.employee.Employee;
import br.com.flightmanager.employee.EmployeeServices;
import br.com.flightmanager.flight.city.City;
import br.com.flightmanager.flight.city.CityRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final CityRepository cityRepository;

    private final EmployeeServices employeeServices;

    private final AircraftServices aircraftServices;

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

    /**
     * Obtains all city objects persisted in the database
     * @return A {@link List} of {@link City} objects
     */
    public List<City> obtainCities() {
        return IterableUtils.toList(cityRepository.findAll());
    }

    /**
     * Regiister a {@link Flight} object
     * @param flight {@link Flight} that is going to be persisted
     * @return Persisted {@link Flight} object
     */
    public Flight registerFlight(Flight flight) {
        FlightBuilder flightBuilder = new FlightBuilder();
        Flight flightToBePersisted = flightBuilder.pilot(employeeServices.getExistingEmployee(flight.getPilot()))
                .aircraft(aircraftServices.getExistingAircraft(flight.getAircraft()))
                .origin(getExistingCity(flight.getOrigin()))
                .destination(getExistingCity(flight.getDestination()))
                .start(flight.getStart())
                .end(flight.getEnd()).build();

        return flightRepository.save(flightToBePersisted);
    }

    /**
     * Obtains a entity object (if exists) in the database that has the same core attributes as the informed entity.
     * Otherwise, returns the informed entity
     * @param city informed entity
     * @return The existing entity on the database or the informed entity
     */
    private City getExistingCity(City city) {
        City existingCity = cityRepository.getExisting(city.getId(), city.getName());
        return existingCity == null ? city : existingCity;
    }
}
