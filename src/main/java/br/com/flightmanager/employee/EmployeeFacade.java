package br.com.flightmanager.employee;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Orchestrate services related to {@link Employee} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 */
@Component
@AllArgsConstructor
public class EmployeeFacade {

    private final EmployeeServices employeeServices;

    /**
     * Obtains all employee objects persisted in the database
     *
     * @return A {@link List} of {@link Employee} objects
     */
    public List<Employee> obtainEmployees() {
        return employeeServices.obtainEmployees();
    }
}
