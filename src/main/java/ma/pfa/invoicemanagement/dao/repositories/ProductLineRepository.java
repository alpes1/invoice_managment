package ma.pfa.invoicemanagement.dao.repositories;

import ma.pfa.invoicemanagement.dao.entities.ProductLine;
import ma.pfa.invoicemanagement.dao.entities.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductLineRepository extends JpaRepository< ProductLine,Integer> {
    //public List<ProductLine> findAll() ;


    public List<ProductLine> findProductLineByQuotes(Quotes q) ;
}
