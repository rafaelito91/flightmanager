package br.com.flightmanager.flight;

import br.com.flightmanager.aircraft.Aircraft;
import br.com.flightmanager.employee.Employee;
import br.com.flightmanager.flight.city.City;

import java.time.LocalDateTime;

/**
 * Builder class responsible for creating a  {@link Flight} object.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 08/04/2018
 */
public class FlightBuilder {

    private Employee pilot;

    private Aircraft aircraft;

    private City origin;

    private City destination;

    private LocalDateTime start;

    private LocalDateTime end;


    public FlightBuilder pilot(Employee pilot) {
        this.pilot = pilot;
        return this;
    }

    public FlightBuilder aircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        return this;
    }

    public FlightBuilder origin(City origin) {
        this.origin = origin;
        return this;
    }

    public FlightBuilder destination(City destination) {
        this.destination = destination;
        return this;
    }

    public FlightBuilder start(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public FlightBuilder end(LocalDateTime end) {
        this.end = end;
        return this;
    }

    public Flight build() {
        return new Flight(null, pilot, aircraft, origin, destination, start, end);
    }
}
