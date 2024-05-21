package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Quotes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuotesManager {

    public Quotes addQuotes(Quotes quotes) ;

    public List<Quotes> getAllQuotes();

    public Quotes updateQuotes(Quotes quotes) ;
    public Boolean deleteQuotes(int id ) ;

    //pagination

    public Page<Quotes> getAllQuotes(int page , int taille );


    public Page<Quotes> getQuotesByCustomer(int page , int taille , String name );
    public Quotes getQuotesById(Integer id );

   // public Page<Quotes> getQuotesByService(int page , int taille , String keyword);

    public Page<Quotes> getQuotesByProduct(int page , int taille , String keyword);

    public List<Quotes> getAllQuotesList() ;

    public Double getTotalPrice();

    Double getTotalPriceByYearAndMonth(int currentYear, int month) ;




}
