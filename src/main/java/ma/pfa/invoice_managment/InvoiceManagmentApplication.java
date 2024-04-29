package ma.pfa.invoice_managment;

import ma.pfa.invoice_managment.dao.entities.Invoice;
import ma.pfa.invoice_managment.metier.InvoiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class InvoiceManagmentApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceManagmentApplication.class, args);
    }
    @Autowired
    InvoiceManager invoiceManager ;
    @Override

    public void run(String... args) throws Exception {
        List<Invoice> invoices = invoiceManager.getAllInvoice();
        invoices.forEach(x -> System.out.println(x.getInvoiceNumber() + " " + x.getInvoiceDate() + " " + x.getId() + " " + x.getDesignation() + " " + x.getTotalPrice() + " " + x.getPrice()));

        invoices.forEach(x -> System.out.println(x.getLogo()));
    }
}
