package ma.pfa.invoice_managment.dao.repositories;

import ma.pfa.invoice_managment.dao.entities.Customer;
import ma.pfa.invoice_managment.dao.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    Page<Invoice> findInvoicesByCustomer(String CustomerName, Pageable pageable) ;
    List<Invoice> findInvoicesByInvoiceDate(Date date) ;
    Page<Invoice> findByDesignationContains(String keyword , Pageable pageable);

    Invoice findInvoicesById(Integer id) ;


}
