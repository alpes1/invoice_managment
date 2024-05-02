package ma.pfa.invoice_managment.metier;

import ma.pfa.invoice_managment.dao.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface CustomerManager {

    // CRUD operations
    public Customer addCustomer(Customer c) ;

    public Customer updateCustomer(Integer id ) ;
    public Boolean deleteCustomer(Integer id ) ;

    public Page<Customer> getAllCustomer(int page , int taille ) ;
    public Page<Customer> getCustomerByCustomerName(int page , int taille , String keyword) ;

    public Page<Customer> getCustomerByAdress(int page , int taille , String keyword) ;

}
