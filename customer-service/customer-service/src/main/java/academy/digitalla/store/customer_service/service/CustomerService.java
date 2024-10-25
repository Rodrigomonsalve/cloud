package academy.digitalla.store.customer_service.service;

import academy.digitalla.store.customer_service.repository.entity.Customer;
import academy.digitalla.store.customer_service.repository.entity.Region;

import java.util.List;

public interface CustomerService {

    public List<Customer> findCustomerAll();
    public List<Customer> findCustomersByRegion(Region region);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
    public  Customer getCustomer(Long id);



}