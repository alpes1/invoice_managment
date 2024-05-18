package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Customer;
import org.hibernate.id.IntegralDataTypeHolder;
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

    public Customer getCustomerById(Integer id) ;

}
