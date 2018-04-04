package br.com.flightmanager.employee;

import org.springframework.data.repository.CrudRepository;

/**
 * Responsible for persistence operations related to {@link Employee} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see EmployeeServices
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
