package ma.pfa.invoice_managment.dao.repositories;

import ma.pfa.invoice_managment.dao.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer > {
    public Page<Customer> findCustomerByQuotes(String keyword , Pageable pageable);
    public Page<Customer> findCustomerByAddress(String keyword , Pageable pageable);
    public Page<Customer> findCustomerByCustomerName(String keyword , Pageable pageable);


}
