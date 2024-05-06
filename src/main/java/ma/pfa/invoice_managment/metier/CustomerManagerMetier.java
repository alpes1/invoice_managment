package ma.pfa.invoice_managment.metier;

import ma.pfa.invoice_managment.dao.entities.Customer;
import ma.pfa.invoice_managment.dao.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManagerMetier implements CustomerManager{

    @Autowired
    CustomerRepository customerRepository ;
    public Customer addCustomer(Customer c)
    {
        return customerRepository.save(c) ;
    };

    public Customer updateCustomer(Integer id )
    {
        return null ;
    } ;
    public Boolean deleteCustomer(Integer id )
    {return null ;};



    public Page<Customer> getAllCustomer(int page , int taille )
    {
        return customerRepository.findAll( PageRequest.of(page,taille));
    };
    public Page<Customer> getCustomerByCustomerName(int page , int taille , String keyword)
    {
        return customerRepository.findCustomerByCustomerName(keyword ,PageRequest.of(page,taille) );
    };

    public Page<Customer> getCustomerByAdress(int page , int taille , String keyword)
    {
        return customerRepository.findCustomerByAddress(keyword,PageRequest.of(page,taille));
    };

    public List<Customer> getAllCustomerList() {
        return customerRepository.findAll() ;
    }
}
