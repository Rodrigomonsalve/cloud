package academy.digitalla.store.service_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//ANOTACION PARA INDICAR QUE ES UN CLIENTE DEL SERVIDOR EUREKA.
public class ServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProductApplication.class, args);
	}

}
