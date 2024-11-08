package academy.digitalla.store.shopping_service.client;

import academy.digitalla.store.shopping_service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


// ESTA ES LA FORMA DE COMUNICAR 2 MICROSERVICIOS.
// SE COMUNICAN COMO SE SI TRATARA DE UN CONTROLADOR, PERO SE USA LA ANOTACION @FeignClient.
// LA FORMA EN QUE SE DESCUBREN ES A TRAVES DE EUREKA. EL ATRIBUTO "NAME" DEBE SER EL QUE ESTÉ REGISTRADO EN EUREKA Y ES EL MICROSERVICIO CON EL QUE NOS QUEREMOS COMUNICAR.
// EL ATRIBUTO "PATH" HACE REFERENCIA A LA RUTA ESTABLECIDA PARA LA CLASE CONTROLADORA DEL MICROSERVICIO A CONECTAR. ES LA RUTA BASE.
// SIN EMBARGO, SI QUIERES UTILIZAR LA RUTA COMPLETA TAMBIEN PUEDES USAR EL ATRIBUTO "URL": "http://localhost:8092".

// SIEMPRE DEERÁ SER UNA INTERFAZ.
// LOS METODOS DE ESTA INTERFAZ SE PODRAN USAR, PRINCIPALMENTE EN LAS CLASES SERVICIOS DE ESTE MICROSERVICIO, PARA OBTENER INFORMACIÓN DEL OTRO
// MICROSERVICIO Y USARLA.
// NORMALMENTE SE QUERRÁ ENVIAR INFORMACION DEL OTRO MICROSERVICIO EN EL JSON.
// SI ES ASI, SERA NECESARIO CREAR UNA CLASE MODELO, COMO LAS DEL PAQUETE MODEL, PARA PODER USAR ESE OBJETO DENTRO DE LA ENTIDAD CORRESPONDIENTE, CON LA ANOTACIÓN @Transient.

@FeignClient(name = "customer-service", path="/customers")
//@RequestMapping("/customers")
public interface CustomerClient {

    //  ESTE METODO DEBE ENCONTRARSE DESARROLLADO EN LA CLASE CONTROLADORA DE CUSTOMER-SERVICE
    // PUEDES TRAER LOS METODOS QUE VAYAS NECESITANDO.
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

}
