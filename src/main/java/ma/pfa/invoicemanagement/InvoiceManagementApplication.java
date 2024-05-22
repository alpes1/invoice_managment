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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InvoiceManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceManagementApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {





}}
