package br.com.flightmanager.restapi;

import br.com.flightmanager.aircraft.Aircraft;
import br.com.flightmanager.aircraft.AircraftFacade;
import br.com.flightmanager.employee.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Provides restful interface related to {@link Employee} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 */
@RestController
@AllArgsConstructor
@RequestMapping("aircrafts")
public class AircraftController {

    private final AircraftFacade aircraftFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public List<Aircraft> getAircrafts() {
        return aircraftFacade.obtainAircrafts();
    }
}
