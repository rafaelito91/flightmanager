package br.com.flightmanager.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Possess attributes all company employees must have
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 03/04/18
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "employee", schema = "fm")
@SequenceGenerator(sequenceName = "seq_employee", schema = "fm", name = "EMPLOYEE_SEQUENCE", initialValue = 1, allocationSize = 1)
public class Employee implements Serializable {

    //TODO Transform it to a Abstract class and create abstraction for the Pilot Employee type
    /** Field description */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQUENCE")
    @Column(name = "id_employee")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    /* Default Constructor required by JPA for entity mapping */
    private Employee() {
    }
}
