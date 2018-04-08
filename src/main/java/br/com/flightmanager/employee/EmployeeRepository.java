package br.com.flightmanager.employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Responsible for persistence operations related to {@link Employee} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 * @see EmployeeServices
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from #{#entityName} e where e.id = ?1 or (?1 = null and e.name = ?2)")
    Employee getExisting(Long id, String name);
}
