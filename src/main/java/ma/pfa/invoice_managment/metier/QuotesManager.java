package ma.pfa.invoice_managment.metier;

import ma.pfa.invoice_managment.dao.entities.Invoice;
import ma.pfa.invoice_managment.dao.entities.Quotes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuotesManager {

    public Quotes addQuotes(Quotes quotes) ;

    public List<Invoice> getAllQuotes();

    public Quotes updateQuotes(int id ) ;
    public Boolean deleteQuotes(int id ) ;

    //pagination

    public Page<Quotes> getAllQuotes(int page , int taille );

    public Page<Quotes> getQuotesByCustomer(int page , int taille , String name );

    public Page<Quotes> searchQuotes(int page , int taille , String keyword) ;


}
