package br.com.flightmanager.restapi;

import br.com.flightmanager.flight.Flight;
import br.com.flightmanager.flight.FlightFacade;
import br.com.flightmanager.flight.city.City;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Provides restful interface related to {@link Flight} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 */
@RestController
@AllArgsConstructor
@RequestMapping("flights")
public class FlightController {

    private final FlightFacade flightFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public List<Flight> getFlights() {
        return flightFacade.obtainFlights();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flight registerFlight(@RequestBody Flight flight) {
        return flightFacade.registerFlight(flight);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flight getFlightById(@RequestParam Long id) {
        return flightFacade.obtainFlightById(id);
    }

    @GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<City> getCities() {
        return flightFacade.obtainCities();
    }
}
