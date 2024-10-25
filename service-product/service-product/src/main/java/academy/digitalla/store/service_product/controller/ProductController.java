package academy.digitalla.store.service_product.controller;

import academy.digitalla.store.service_product.entity.Category;
import academy.digitalla.store.service_product.entity.Product;
import academy.digitalla.store.service_product.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // localhost:8091/products?categoryId=1
    @GetMapping
    public ResponseEntity<List<Product>> listProduct(@RequestParam(name = "categoryId", required = false) Long categoryId){

        List<Product> products=new ArrayList<>();

        if(null==categoryId){

            products=productService.listAllProduct();

            if(products.isEmpty()){

                return ResponseEntity.noContent().build();
            }

        }else{

            //products=productService.findByCategory(Category.builder().id(categoryId).build());

            products=productService.findByCategory(new Category(categoryId));

            if(products.isEmpty()){

                return ResponseEntity.notFound().build();
            }

        }

        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(products);
        }



    }

    //localhost:8091/products/1
    @GetMapping(value="/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){

        Product product = productService.getProduct(id);

        if(product==null){

            return ResponseEntity.notFound().build();
        } else{

            return ResponseEntity.ok(product);
        }



    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result){

        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Product productCreate=productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
    }


    @PutMapping(value="/{id}")
    public ResponseEntity<Product>  updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

        product.setId(id);

        Product productDB=productService.updateProduct(product);

        if(productDB==null){

            return ResponseEntity.notFound().build();
        }else {

            return ResponseEntity.ok(productDB);

        }

    }


    //localhost:8091/products/4
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){

        Product productDelete=productService.deleteProduct(id);

        if(productDelete==null){

            return ResponseEntity.notFound().build();

        } else{

            return ResponseEntity.ok(productDelete);

        }

    }

    //localhost:8091/3/stock?quantity=2
    @GetMapping(value = "/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable Long id, @RequestParam(name="quantity", required=true) Double quantity){

        Product product=productService.updateStock(id, quantity);

        if(product==null){

            return ResponseEntity.notFound().build();

        } else{

            return ResponseEntity.ok(product);
        }

    }

    private String formatMessage(BindingResult result){

        List<Map<String,String>> errors=result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String> error=new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        //ErrorMessage errorMessage=ErrorMessage.builder().code("01").messages(errors).build();
        ErrorMessage errorMessage=new ErrorMessage("01",errors);

        ObjectMapper mapper=new ObjectMapper();
        String jsonString="";

        try{

            jsonString=mapper.writeValueAsString(errorMessage);

        }catch (JsonProcessingException e){

            e.printStackTrace();
        }

        return jsonString;



    }

}
