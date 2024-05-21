package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.ProductLine;
import ma.pfa.invoicemanagement.dao.entities.Quotes;
import ma.pfa.invoicemanagement.dao.repositories.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductLineManagerMetier implements ProductLineManager{
    @Autowired
    ProductLineRepository productLineRepository ;
    @Autowired
    QuotesManager quotesManager ;

    @Override
    public ProductLine addProductLine(ProductLine p) {
        return productLineRepository.save(p);
    }

    @Override
    public List<ProductLine> addListOfProductLine(Collection<ProductLine> prd) {
        return productLineRepository.saveAll(prd);
    }

    @Override
    public Double sumProductLinesByQuotes(Integer id) {


        Quotes quote = quotesManager.getQuotesById(id) ;
        List<ProductLine> productLines = productLineRepository.findProductLineByQuotes(quote) ;
        Double sum = productLines.stream()
                .mapToDouble(ProductLine::getTotalPrice)
                .sum();
        return sum ;
    }


    @Override
    public List<ProductLine> getAllProductLines() {
        return productLineRepository.findAll();
    }

    @Override
    public Double sumAllProductLines() {
        List<ProductLine> productLines = productLineRepository.findAll();
        Double sum = productLines.stream()
                .mapToDouble(ProductLine::getTotalPrice)
                .sum();

        return sum;
    }


}
