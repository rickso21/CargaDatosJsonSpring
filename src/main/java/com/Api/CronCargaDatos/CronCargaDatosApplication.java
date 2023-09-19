package com.Api.CronCargaDatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@SpringBootApplication
//@PropertySource("classpath:/database-config.json")
@RestController
//@ImportResource("classpath:/database-config.json")
public class CronCargaDatosApplication {

	@GetMapping("/prueba")
	public String greeting() {
		return "Eliminacion de Datos y Carga Activo";
	}
	public static void main(String[] args) {

		SpringApplication.run(CronCargaDatosApplication.class, args);
	}

}