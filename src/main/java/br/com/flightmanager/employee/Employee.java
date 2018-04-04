package br.com.flightmanager.employee;

import javax.persistence.*;

/**
 * Possess attributes all company employees must have
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 03/04/18
 */
@Entity
@Table(name = "EMPLOYEE", schema = "FM")
@SequenceGenerator(sequenceName = "SEQ_EMPLOYEE", schema = "FM", name = "EMPLOYEE_SEQUENCE", initialValue = 1, allocationSize = 1)
public abstract class Employee {

    /** Field description */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQUENCE")
    @Column(name = "ID_EMPLOYEE")
    private Long id;

    @Column(name = "NAME")
    private String name;


}
