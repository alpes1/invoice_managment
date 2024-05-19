package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.ProductLine;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public interface ProductLineManager {

    public ProductLine addProductLine(ProductLine p) ;

    public List<ProductLine> addListOfProductLine(Collection<ProductLine> prd) ;


    public Double sumProductLinesByQuotes( Integer id);


    public  List<ProductLine> getAllProductLines ();

    public Double sumAllProductLines() ;


}
