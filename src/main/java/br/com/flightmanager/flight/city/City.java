package br.com.flightmanager.flight.city;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Represents a city which the Airline Company has flights attending
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/18
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "city", schema = "fm")
@SequenceGenerator(sequenceName = "seq_city", schema = "fm", name = "CITY_SEQUENCE", initialValue = 1, allocationSize = 1)
public class City implements Serializable {

    /** Field description */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_SEQUENCE")
    @Column(name = "id_city")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    /* Default Constructor required by JPA for entity mapping */
    private City() {
    }
}
