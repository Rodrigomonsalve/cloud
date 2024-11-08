package academy.digitalla.store.shopping_service.entity;

import academy.digitalla.store.shopping_service.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.Valid;
import lombok.Data;

//import javax.persistence.*;
//import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Data
@Entity
@Table(name = "tlb_invoices")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_invoice")
    private String numberInvoice;

    private String description;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;



    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> items;

    private String state;

    public Invoice(){

        items = new ArrayList<>();
    }



    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    // LA ANOTACION @Transient ES PARA QUE ESTE ATRIBUTO NO SE GUARDE EN LA BASE DE DATOS.
    // SIN EMBARGO, SE MOSTRARÉ EN EL JSON.
    // ESTE OBJETO ES PRODUCTO DE LA COMUNICACIÓN CON OTRO MICROSERVICIO (CUSTOMER-SERVICE).
    @Transient
    private Customer customer;


    public Long getInvoice_id() {
        return id;
    }

    public void setInvoice_id(Long id) {
        this.id = id;
    }

    public String getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public @Valid List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(@Valid List<InvoiceItem> items) {
        this.items = items;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
