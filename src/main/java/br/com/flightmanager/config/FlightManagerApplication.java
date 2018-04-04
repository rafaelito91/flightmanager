package br.com.flightmanager.config;

import br.com.flightmanager.employee.Employee;
import br.com.flightmanager.employee.EmployeeRepository;
import br.com.flightmanager.flight.Flight;
import br.com.flightmanager.flight.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Responsible for starting the spring boot application
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 03/04/18
 */
@EnableWebMvc
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.flightmanager",
		excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {"br.com.flightmanager.config"}))
@EnableJpaRepositories(basePackageClasses = {EmployeeRepository.class, FlightRepository.class})
@EntityScan(basePackageClasses = {Employee.class, Flight.class})
public class FlightManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagerApplication.class, args);
	}
}
