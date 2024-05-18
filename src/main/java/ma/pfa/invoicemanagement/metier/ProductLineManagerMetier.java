package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.ProductLine;
import ma.pfa.invoicemanagement.dao.repositories.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductLineManagerMetier implements ProductLineManager{
    @Autowired
    ProductLineRepository productLineRepository ;

    @Override
    public ProductLine addProductLine(ProductLine p) {
        return productLineRepository.save(p);
    }

    @Override
    public List<ProductLine> addListOfProductLine(Collection<ProductLine> prd) {
        return productLineRepository.saveAll(prd);
    }


}
