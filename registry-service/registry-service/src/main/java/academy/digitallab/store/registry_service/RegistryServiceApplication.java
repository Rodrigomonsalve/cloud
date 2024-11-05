package academy.digitallab.store.registry_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// ESTE ES UN SERVIDOR EUREKA.
// SIRVE PARA REGISTRAR TODOS LOS MICROSERVICIOS, CON  LA FINALIDAD DE QUE SE PUEDAN VER ENTRE ELLOS.
// REGISTRA:
// 1) UBICACION
// 2) ESTADO (CORRIENDO O CAIDO). CADA MICROSERVICIO, DETERMINADO TIEMPO, ENVIA UN HEARTBEAT A EUREKA.
// LOS MICROSERVICIOS PUEDEN ESTAR CORRIENDO PERO SIN NECESIDAD DE CONECTARSE A EUREKA.
// PARA VER LOS MICROSERVICIOS REGISTRADOS, DEBES IR A:  localhost:8099  EN EL NAVEGADOR.

// EL PUERTO PREDETERMINADO DE EUREKA ES EL 8761, PERO SE PUEDE CAMBIAR, COMO SE HIZO EN ESTE CASO:
// EN CADA ARCHIVO DE PROPIEDADES (EL QUE YA SE ENCUENTRA EN LA NUBE) DE CADA MICROSERVICIO SE DEBE ESTABLECER ESTA CONEXION.

@SpringBootApplication
@EnableEurekaServer//ANOTACION PARA INDICAR QUE ES UN SERVIDOR EUREKA.
public class RegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryServiceApplication.class, args);
	}

}
