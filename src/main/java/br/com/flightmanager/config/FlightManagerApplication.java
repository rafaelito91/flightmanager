package br.com.flightmanager.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Responsible for starting the spring boot application
 *
 * @author Rafael Kyoshi Ito
 * @version 1.0 03/04/18
 */
@SpringBootApplication
public class FlightManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagerApplication.class, args);
	}
}
