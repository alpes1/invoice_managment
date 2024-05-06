package ma.pfa.invoice_managment.metier;

import ma.pfa.invoice_managment.dao.entities.Customer;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerManager {

    // CRUD operations
    public Customer addCustomer(Customer c) ;

    public Customer updateCustomer(Integer id ) ;
    public Boolean deleteCustomer(Integer id ) ;

    public Page<Customer> getAllCustomer(int page , int taille ) ;
    public Page<Customer> getCustomerByCustomerName(int page , int taille , String keyword) ;

    public Page<Customer> getCustomerByAdress(int page , int taille , String keyword) ;

    public List<Customer> getAllCustomerList();

}
