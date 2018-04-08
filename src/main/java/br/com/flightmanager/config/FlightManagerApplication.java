package br.com.flightmanager.config;

import br.com.flightmanager.aircraft.Aircraft;
import br.com.flightmanager.aircraft.AircraftRepository;
import br.com.flightmanager.config.converter.LocalDateTimeAttributeConverter;
import br.com.flightmanager.employee.Employee;
import br.com.flightmanager.employee.EmployeeRepository;
import br.com.flightmanager.flight.Flight;
import br.com.flightmanager.flight.FlightRepository;
import br.com.flightmanager.flight.city.City;
import br.com.flightmanager.flight.city.CityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
@EnableJpaRepositories(basePackageClasses = {AircraftRepository.class, CityRepository.class, EmployeeRepository.class, FlightRepository.class})
@EntityScan(basePackageClasses = {Aircraft.class, City.class, Employee.class, Flight.class, LocalDateTimeAttributeConverter.class})
public class FlightManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/flights").allowedMethods("GET", "POST");
                registry.addMapping("/aircrafts").allowedOrigins("http://localhost:9000");
                registry.addMapping("/employees").allowedOrigins("http://localhost:9000");
			}
		};
	}
}
