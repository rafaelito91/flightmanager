package br.com.flightmanager.employee;

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Responsible for providing operations related to {@link Employee} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see EmployeeFacade
 */
@Service
@AllArgsConstructor
public class EmployeeServices {

    private final EmployeeRepository employeeRepository;

    /**
     * Obtains all flight objects persisted in the database
     *
     * @return A {@link List} of {@link Employee} objects
     */
    public List<Employee> obtainEmployees() {
        return IterableUtils.toList(employeeRepository.findAll());
    }
}
