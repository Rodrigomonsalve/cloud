package academy.digitalla.store.shopping_service.service;

//import academy.digitallab.store.shopping.repository.InvoiceItemsRepository;
//import academy.digitallab.store.shopping.repository.InvoiceRepository;
//import academy.digitallab.store.shopping.entity.Invoice;
import academy.digitalla.store.shopping_service.client.CustomerClient;
import academy.digitalla.store.shopping_service.client.ProductClient;
import academy.digitalla.store.shopping_service.entity.Invoice;
import academy.digitalla.store.shopping_service.entity.InvoiceItem;
import academy.digitalla.store.shopping_service.model.Customer;
import academy.digitalla.store.shopping_service.model.Product;
import academy.digitalla.store.shopping_service.repository.InvoiceItemsRepository;
import academy.digitalla.store.shopping_service.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceItemsRepository invoiceItemsRepository;

   @Autowired
   ProductClient productClient;


    @Autowired
    CustomerClient customerClient;

    @Override
    public List<Invoice> findInvoiceAll() {
        return  invoiceRepository.findAll();
    }


    /*@Override
    public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceDB = invoiceRepository.findByNumberInvoice ( invoice.getNumberInvoice () );
        if (invoiceDB !=null){
            return  invoiceDB;
        }
        invoice.setState("CREATED");
        return invoiceRepository.save(invoice);
    }*/

    @Override
    public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceDB = invoiceRepository.findByNumberInvoice ( invoice.getNumberInvoice () );
        if (invoiceDB !=null){
            return  invoiceDB;
        }
        invoice.setState("CREATED");

        invoiceDB=invoiceRepository.save(invoice);

        invoiceDB.getItems().forEach(invoiceItem -> {//????  Y FOREACH

            productClient.updateStockProduct(invoiceItem.getProductId(),  invoiceItem.getQuantity() *-1);

        });

        return invoiceDB;
    }


    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getInvoice_id());
        if (invoiceDB == null){
            return  null;
        }
        invoiceDB.setCustomerId(invoice.getCustomerId());
        invoiceDB.setDescription(invoice.getDescription());
        invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
        invoiceDB.getItems().clear();
        invoiceDB.setItems(invoice.getItems());
        return invoiceRepository.save(invoiceDB);
    }


    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getInvoice_id());
        if (invoiceDB == null){
            return  null;
        }
        invoiceDB.setState("DELETED");
        return invoiceRepository.save(invoiceDB);
    }

    /*@Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }*/

    @Override
    public Invoice getInvoice(Long id) {

        Invoice invoice=invoiceRepository.findById(id).orElse(null);
        if(null != invoice){

            Customer customer = customerClient.getCustomer(invoice.getCustomerId()).getBody(); //AQUI ESTOY COMUICANDOME CON OTRO MICROSERVICIO (CUSTOMER-SERVICE).
            invoice.setCustomer(customer);

            List<InvoiceItem> listItem=invoice.getItems().stream().map(invoiceItem -> {//?????

                Product product=productClient.getProduct(invoiceItem.getProductId()).getBody();
                invoiceItem.setProduct(product);
                return invoiceItem;//POR QUE RETURN?

            }).collect(Collectors.toList());//?????
            invoice.setItems(listItem);//?????
        }
        return invoice;
    }
}
