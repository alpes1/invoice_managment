package ma.pfa.invoicemanagement.dao.repositories;

import ma.pfa.invoicemanagement.dao.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //Page<Product> findProductByCategory(String Category, Pageable pageable) ;

    Page<Product> findProductByName(String keyword , Pageable pageable);
    Page<Product> findProductByCategory(String keyword , Pageable pageable) ;
    Page<Product> findProductByDescription(String keyword , Pageable pageable) ;
    Page<Product> findProductById(Integer id , Pageable pageable) ;
    public Product findProductById(Integer id ) ;





}
