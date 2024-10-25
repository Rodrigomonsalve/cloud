package academy.digitalla.store.customer_service.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

//import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_regions")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



}
