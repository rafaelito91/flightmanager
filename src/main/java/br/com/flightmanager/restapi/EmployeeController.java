package br.com.flightmanager.restapi;

import br.com.flightmanager.employee.Employee;
import br.com.flightmanager.employee.EmployeeFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Provides restful interface related to {@link Employee} domain class.
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 04/04/2018
 */
@RestController
@AllArgsConstructor
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public List<Employee> getEmployees() {
        return employeeFacade.obtainEmployees();
    }
}
