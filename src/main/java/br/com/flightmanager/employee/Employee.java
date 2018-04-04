package br.com.flightmanager.employee;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Possess attributes all company employees must have
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 03/04/18
 */
@Data
@Entity
@Table(name = "EMPLOYEE", schema = "FM")
@SequenceGenerator(sequenceName = "SEQ_EMPLOYEE", schema = "FM", name = "EMPLOYEE_SEQUENCE", initialValue = 1, allocationSize = 1)
public class Employee implements Serializable {

    //TODO Transform it to a Abstract class and create abstraction for the Pilot Employee type
    /** Field description */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQUENCE")
    @Column(name = "ID_EMPLOYEE")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;
}
