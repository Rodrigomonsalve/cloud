package academy.digitalla.store.shopping_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Customer {


    private Long id;
    private String numberID;
    private String firstName;
    private String lastName;
    private String email;
    private String photoUrl;
    private Region region;
    private String state;

}
