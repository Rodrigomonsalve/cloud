package academy.digitalla.store.shopping_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//ANOTACION PARA INDICAR QUE ES UN CLIENTE DEL SERVIDOR EUREKA.
@EnableFeignClients
public class ShoppingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingServiceApplication.class, args);
	}

}
