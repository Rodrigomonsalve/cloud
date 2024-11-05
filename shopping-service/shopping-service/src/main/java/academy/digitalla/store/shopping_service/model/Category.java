package academy.digitalla.store.shopping_service.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Category {

    private Long id;

    private String name;
}
