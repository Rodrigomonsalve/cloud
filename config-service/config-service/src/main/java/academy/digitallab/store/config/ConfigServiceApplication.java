package academy.digitallab.store.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// ESTE ES UN SERVIDOR CENTRALIZADO AL QUE SE CONECTAN LOS MICROSERVICIOS (OTROS CODIGOS).
// CONSTITUYE LA CONEXION CON LA NUBE, EN NUESTRO CASO, GITHUB
// SE CUMPLEN LOS SIGUIENTES PASOS:
// 1) EL MICROSERVICIO CORRESPONDIENTE, A TRAVES DE SU BOOTSTRAP.YML SE CONECTA A ESTE SERVIDOR, EL CUAL, DEBE ESTAR CORRIENDO.
// 2) ESTE SERVIDOR, A  TRAVES  DE SU BOOTRSTRAP.YML, SE CONECTA A LA NUBE, EN ESTE CASO, A UN REPOSITORIO DE GITHUB.
// 3) EN LA NUBE SE BUSCAN LOS ARCHIVOS DE PROPIEDADES DE ESE MICROSERVICIO EN PARTICULAR LOS CUALES, EN NUESTRO CASO, SE ENCUETRAN EN LA CARPETA "CONFIG-DATA"

// PARA SABER SI HAY CONEXION CON ESE MICROSERVICIO, DEBES VISITAR EN POSTMAN:
// http://root:s3cr3t@localhost:8083/customer-service/default
//TE MOSTRARÁ SU ARCHIVO DE CONFIGURACIÓN EN JSON.

@EnableConfigServer  // ANOTACIÓN NECESARIA PARA DECIR QUE ESTE ES UN SERVIDOR CENTRALIZADO
@SpringBootApplication
public class ConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceApplication.class, args);
	}

}
