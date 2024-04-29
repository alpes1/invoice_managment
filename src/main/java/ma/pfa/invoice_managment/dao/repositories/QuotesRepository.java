package ma.pfa.invoice_managment.dao.repositories;

import ma.pfa.invoice_managment.dao.entities.Invoice;
import ma.pfa.invoice_managment.dao.entities.Quotes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface QuotesRepository extends JpaRepository<Quotes,Integer> {
    Page<Quotes> findQuotesByCustomer(String CustomerName, Pageable pageable) ;
   // List<Quotes> findQuotesByQuoteDate(Date date) ;
    //Page<Quotes> findByDesignationContains(String keyword , Pageable pageable);
}
