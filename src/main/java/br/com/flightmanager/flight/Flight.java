package br.com.flightmanager.flight;

import br.com.flightmanager.employee.Employee;
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
@Table(name = "FLIGHT", schema = "FM")
@SequenceGenerator(sequenceName = "SEQ_FLIGHT", schema = "FM", name = "FLIGHT_SEQUENCE", initialValue = 1, allocationSize = 1)
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SEQUENCE")
    @Column(name = "ID_FLIGHT")
    private Long id;

    @JoinColumn(name = "ID_PILOT")
    private Employee pilot;
}
