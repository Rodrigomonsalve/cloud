package academy.digitallab.store.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//ESTE ES EL SERVIDOR (GATEWAY) A TRAVES DEL CUAL SE REALIZARAN TODAS LAS PETICIOES A CUALQUIER MICROSERVICIO.
//YA NO SERA NECESARIO VISITAR CADA MICROSERVICIO A TRAVES DE SU PUERTO PARTICULAR. TODOS OBEDECERAN A UNO SOLO, QUE ES EL DE ESTE SERVIDOR. EJEMPLO
//http://localhost:8086/customers
//http://localhost:8086/products

//FLUJO:
// 1) Acude al servidor centralizado.
// 2) El servidor cetralizado localiza en la nube el archivo de propiedades del gateway para inicializarlo, y localizar la url buscada dentro de él (/products,/customers, etc).
// 3) Acude a Eureka para saber en dónde esta ese microservicio en particular.

//Por lo anterior, forzosamente tambien se debe registar en Eureka.

// NO HAY CÒDIGO. TOD LO HACE EL ARCHIVO DE CONFIGURACION EN LA NUBE, UNA DEPENDENCIA EN EL POM, Y EUREKA.
@EnableEurekaClient
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}
