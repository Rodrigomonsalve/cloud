package academy.digitalla.store.shopping_service.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;

import academy.digitalla.store.shopping_service.model.Product;
import lombok.Data;

//import javax.persistence.*;
//import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
//@Data
@Table(name = "tbl_invoce_items")
public class InvoiceItem  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoice_id;
    @Positive(message = "El stock debe ser mayor que cero")
    private Double quantity;
    private Double  price;

    @Column(name = "product_id")
    private Long productId;


    @Transient
    private Double subTotal;


    // LA ANOTACION @Transient ES PARA QUE ESTE ATRIBUTO NO SE GUARDE EN LA BASE DE DATOS.
    // SIN EMBARGO, SE MOSTRARÁ EN EL JSON.
    // ESTE OBJETO ES PRODUCTO DE LA COMUNICACIÓN CON OTRO MICROSERVICIO (PRODUCT-SERVICE).
    @Transient
    private Product product;



    public Double getSubTotal(){
        if (this.price >0  && this.quantity >0 ){
            return this.quantity * this.price;
        }else {
            return (double) 0;
        }
    }
    public InvoiceItem(){
        this.quantity=(double) 0;
        this.price=(double) 0;

    }


    public Long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public @Positive(message = "El stock debe ser mayor que cero") Double getQuantity() {
        return quantity;
    }

    public void setQuantity(@Positive(message = "El stock debe ser mayor que cero") Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}