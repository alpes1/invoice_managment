package ma.pfa.invoicemanagement.dao.repositories;

import ma.pfa.invoicemanagement.dao.entities.Quotes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quotes, Integer> {
    Page<Quotes> findQuotesByCustomer(String CustomerName, Pageable pageable);

    // List<Quotes> findQuotesByQuote_Date(Date date) ;
    // Page<Quotes> findQuotesByProductLines(String keyword , Pageable pageable);
    // Page<Quotes> findQuotesByServices(String keyword , Pageable pageable);
    @SuppressWarnings("null")
    List<Quotes> findAll();

    Quotes findQuotesById(Integer id);

    // Long sumQuotesByProductLines
}
