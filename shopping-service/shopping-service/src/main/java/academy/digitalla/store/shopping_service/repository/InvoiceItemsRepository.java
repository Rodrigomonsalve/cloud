package academy.digitalla.store.shopping_service.repository;

//import academy.digitallab.store.shopping.entity.InvoiceItem;
import academy.digitalla.store.shopping_service.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
