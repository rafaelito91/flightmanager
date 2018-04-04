package br.com.flightmanager.flight;

import br.com.flightmanager.employee.Employee;
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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SEQUENCE")
    @Column(name = "id_flight")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_id")
    private Employee pilot;

    /* Default Constructor required by JPA for entity mapping */
    private Flight() {
    }
}
