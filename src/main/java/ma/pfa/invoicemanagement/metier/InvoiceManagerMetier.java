package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Invoice;
import ma.pfa.invoicemanagement.dao.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceManagerMetier implements InvoiceManager{
    @Autowired
    InvoiceRepository invoiceRepository ;

    @Override
    public Invoice addInvoice(Invoice inv) {

        return invoiceRepository.save(inv);
    }

    @Override
    public List<Invoice> getAllInvoice() {

        return invoiceRepository.findAll();
    }

    @Override
    public Page<Invoice> getInvoiceByCustomer(int page , int taille ,String CustomerName) {
        return invoiceRepository.findInvoicesByCustomer(CustomerName,PageRequest.of(page , taille));
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Boolean deleteInvoice(int id) {
        try {
            invoiceRepository.deleteById(id);
            return true ;
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
            return false;

        }
    }

    @Override
    public Page<Invoice> getAllInvoice(int page, int taille) {

        return invoiceRepository.findAll(PageRequest.of(page ,taille));
    }

    /*@Override
    public Page<Invoice> searchInvoice(int page, int taille, String keyword) {
        return invoiceRepository.findByDesignationContains(keyword ,  PageRequest.of(page,taille));
    }*/

  @Override
  public Invoice getInvoiceById(Integer id)
  {
      return invoiceRepository.findInvoicesById(id);
  }

  @Override
    public boolean deleteInvoice(Integer id )
  {
      try {
            invoiceRepository.deleteById(id);

            return  true ;
      }

      catch (Exception ex)
      {
          return false ;
      }
  }

}
