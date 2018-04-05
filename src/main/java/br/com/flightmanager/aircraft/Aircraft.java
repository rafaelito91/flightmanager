package br.com.flightmanager.aircraft;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Represents an Aircraft used on a Flight by the Airline Company
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/18
 */

@Data
@Entity
@AllArgsConstructor
@Table(name = "aircraft", schema = "fm")
@SequenceGenerator(sequenceName = "seq_aircraft", schema = "fm", name = "AIRCRAFT_SEQUENCE", initialValue = 1, allocationSize = 1)
public class Aircraft implements Serializable {

    /** Field description */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SEQUENCE")
    @Column(name = "id_aircraft")
    private Long id;

    @NotNull
    @Column(name = "model")
    private String model;

    /* Default Constructor required by JPA for entity mapping */
    private Aircraft() {
    }
}
