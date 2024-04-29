package ma.pfa.invoice_managment.dao.repositories;

import ma.pfa.invoice_managment.dao.entities.Invoice;
import ma.pfa.invoice_managment.dao.entities.Product;
import ma.pfa.invoice_managment.dao.entities.Quotes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Quotes> findProductByCategory(String CustomerName, Pageable pageable) ;
    List<Quotes> findProductByName(Date date) ;
    Page<Quotes> findBy(String keyword , Pageable pageable);
}
