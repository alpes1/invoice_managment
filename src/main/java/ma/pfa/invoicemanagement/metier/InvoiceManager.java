package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvoiceManager {
    public Invoice addInvoice(Invoice inv);


    public List<Invoice> getAllInvoice();

    public Invoice updateInvoice(Invoice invoice) ;
    public Boolean deleteInvoice(int id ) ;

    //pagination

    public Page<Invoice> getAllInvoice(int page , int taille );

    public Page<Invoice> getInvoiceByCustomer(int page , int taille , String name );

    //public Page<Invoice> searchInvoice(int page , int taille , String keyword) ;

    public Invoice getInvoiceById(Integer id) ;

    public boolean deleteInvoice(Integer id );








}
