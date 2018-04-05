package br.com.flightmanager.flight;

import br.com.flightmanager.aircraft.Aircraft;
import br.com.flightmanager.employee.Employee;
import br.com.flightmanager.flight.city.City;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a Flight for the Airline Company
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/18
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "flight", schema = "fm")
@SequenceGenerator(sequenceName = "seq_flight", schema = "fm", name = "FLIGHT_SEQUENCE", initialValue = 1, allocationSize = 1)
public class Flight implements Serializable {

    /** Field description */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SEQUENCE")
    @Column(name = "id_flight")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_id")
    private Employee pilot;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    /* Default Constructor required by JPA for entity mapping */
    private Flight() {
    }
}
