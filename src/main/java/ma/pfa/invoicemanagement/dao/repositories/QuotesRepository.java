package ma.pfa.invoicemanagement.dao.repositories;

import ma.pfa.invoicemanagement.dao.entities.Quotes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quotes, Integer> {
    Page<Quotes> findQuotesByCustomer(String CustomerName, Pageable pageable);

    // List<Quotes> findQuotesByQuote_Date(Date date) ;
    // Page<Quotes> findQuotesByProductLines(String keyword , Pageable pageable);
    // Page<Quotes> findQuotesByServices(String keyword , Pageable pageable);
    @SuppressWarnings("null")
    List<Quotes> findAll();

    Quotes findQuotesById(Integer id);

    @Query("SELECT SUM(q.totalprice) FROM Quotes q WHERE YEAR(q.quote_Date) = :year AND MONTH(q.quote_Date) = :month")
    Double findTotalPriceByYearAndMonth(@Param("year") int year, @Param("month") int month);
}

    // Long sumQuotesByProductLines

