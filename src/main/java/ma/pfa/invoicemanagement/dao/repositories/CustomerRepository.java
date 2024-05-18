package ma.pfa.invoicemanagement.dao.repositories;

import ma.pfa.invoicemanagement.dao.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer > {
    public Page<Customer> findCustomerByQuotes(String keyword , Pageable pageable);
    public Page<Customer> findCustomerByAddress(String keyword , Pageable pageable);
    public Page<Customer> findCustomerByName(String keyword , Pageable pageable);

    public List<Customer> findAll() ;
    public Customer findCustomerById(Integer id) ;

}
