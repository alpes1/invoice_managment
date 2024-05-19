package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Quotes;
import ma.pfa.invoicemanagement.dao.repositories.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotesManagerMetier implements QuotesManager{

    @Autowired
    QuotesRepository quotesRepository ;
    public Quotes addQuotes(Quotes quotes) {

        return quotesRepository.save(quotes) ;

    }

    public List<Quotes> getAllQuotes()
    {
        return quotesRepository.findAll() ;
    };

    public Quotes updateQuotes(int id )
    {

        return null ;
    };
    public Boolean deleteQuotes(int id )
    {
        return null ;
    };

    //pagination

    public Page<Quotes> getAllQuotes(int page , int taille )
    {
        return quotesRepository.findAll(PageRequest.of(page ,taille));
    };

    public Page<Quotes> getQuotesByCustomer(int page , int taille , String keyword )
    {
        return quotesRepository.findQuotesByCustomer(keyword, PageRequest.of(page,taille));
    }

    @Override
    public Quotes getQuotesById(Integer id) {
        return quotesRepository.findQuotesById(id);
    }

    @Override
    public Page<Quotes> getQuotesByProduct(int page, int taille, String keyword) {
        return null;
    }

    ;

/*    public Page<Quotes> getQuotesByProduct(int page , int taille , String keyword)
    {
        return quotesRepository.findQuotesByProduct(keyword ,PageRequest.of(page,taille)) ;
    };*/

/*    public Page<Quotes> getQuotesByService(int page , int taille , String keyword)
    {
        return quotesRepository.findQuotesByServices(keyword ,PageRequest.of(page,taille)) ;
    };*/

    public List<Quotes> getAllQuotesList()
    {
        return quotesRepository.findAll();
    }

    @Override
    public Double getTotalPrice() {
        return null;
    }


}
