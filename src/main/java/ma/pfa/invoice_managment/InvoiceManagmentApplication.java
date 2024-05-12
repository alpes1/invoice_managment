package ma.pfa.invoice_managment;

import ma.pfa.invoice_managment.dao.entities.Customer;
import ma.pfa.invoice_managment.dao.entities.Invoice;
import ma.pfa.invoice_managment.metier.CustomerManager;
import ma.pfa.invoice_managment.metier.InvoiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class InvoiceManagmentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceManagmentApplication.class, args);
    }
 /*   @Autowired
    InvoiceManager invoiceManager ;*/

  /*  @Autowired
    CustomerManager cs ;*/
    @Override

    public void run(String... args) throws Exception {
  /*      List<Invoice> invoices = invoiceManager.getAllInvoice();
        invoices.forEach(x -> System.out.println(x.getInvoiceNumber() ));

        List<Customer> css = cs.getAllCustomerList();
        css.forEach(x-> System.out.println(x.getCustomarEmail()));
*/



    }

}
