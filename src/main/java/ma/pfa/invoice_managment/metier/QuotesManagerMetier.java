package ma.pfa.invoice_managment.metier;

import ma.pfa.invoice_managment.dao.entities.Invoice;
import ma.pfa.invoice_managment.dao.entities.Quotes;
import ma.pfa.invoice_managment.dao.repositories.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotesManagerMetier implements QuotesManager{

    @Autowired
    QuotesRepository quotesRepository ;
    public Quotes addQuotes(Quotes quotes) {

        return quotesRepository.save(quotes) ;

    }

    public List<Invoice> getAllQuotes()
    {
        return null ;
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
        return null ;
    };

    public Page<Quotes> getQuotesByCustomer(int page , int taille , String name )
    {
        return null ;
    };

    public Page<Quotes> searchQuotes(int page , int taille , String keyword)
    {
        return null ;
    };


}
