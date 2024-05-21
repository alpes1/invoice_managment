package ma.pfa.invoicemanagement;

import ma.pfa.invoicemanagement.dao.entities.Entreprise;
import ma.pfa.invoicemanagement.dao.entities.ProductLine;
import ma.pfa.invoicemanagement.dao.entities.Quotes;
import ma.pfa.invoicemanagement.metier.EntrepriseManager;
import ma.pfa.invoicemanagement.metier.ProductLineManager;
import ma.pfa.invoicemanagement.metier.ProductManager;
import ma.pfa.invoicemanagement.metier.QuotesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InvoiceManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceManagementApplication.class, args);
    }

    @Autowired
    QuotesManager quotesManager;
    @Autowired
    ProductLineManager productLineManager;
    @Autowired
    EntrepriseManager  entrepriseManager ;

    @Override
    public void run(String... args) throws Exception {

        // List<Quotes> quotes = quotesManager.getAllQuotes();
        // List<ProductLine> productLines =productLineManager.getAllProductLines();
        // ProductLine p=productLines.get(0) ;
        // System.out.println(p.getTotalPrice());
        // Quotes q = quotes.get(0);
        // System.out.println(q.getId());
        // System.out.println(productLineManager.sumProductLinesByQuotes(4));
        // System.out.println();
        //System.out.println(productLineManager.sumAllProductLines());
   /*     Entreprise entreprise = new Entreprise();
        entreprise.setName("D&E");
        entreprise.setCapital("100000");
        entreprise.setLogo("/images/company.jpeg");
        entreprise.setIce("5656464");
        entreprise.setDate_Creation(new Date("2019-11-15"));
        entreprise.setPatent("156164598");

*/
    }
}
