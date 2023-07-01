package net.plantsystem.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Before the run application create database with name "plant-system" also see application.properties files.
 * All Api are successfully run and implement in Swagger.
 * Just run: http://localhost:8080/plant-system/swagger-ui.html on browser and test application after fully running application.
 */


@SpringBootApplication
public class PlantSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantSystemBackendApplication.class, args);
    }

}
