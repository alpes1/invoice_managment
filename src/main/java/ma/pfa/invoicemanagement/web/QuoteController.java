package ma.pfa.invoicemanagement.web;

import ma.pfa.invoicemanagement.dao.entities.Customer;
import ma.pfa.invoicemanagement.dao.entities.Product;
import ma.pfa.invoicemanagement.dao.entities.ProductLine;
import ma.pfa.invoicemanagement.dao.entities.Quotes;
import ma.pfa.invoicemanagement.metier.CustomerManager;
import ma.pfa.invoicemanagement.metier.ProductLineManager;
import ma.pfa.invoicemanagement.metier.ProductManager;
import ma.pfa.invoicemanagement.metier.QuotesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class QuoteController {

    @Autowired
    QuotesManager quotesManager;
    @Autowired
    ProductManager productManager;
    @Autowired
    CustomerManager customerManager;
    @Autowired
    ProductLineManager productLineManager;


    //Crud Actions

    @GetMapping("/ajouterDevis")
    public String ajouterDevisGet(Model model) {
        List<Product> products = productManager.getAllProductsList();
        List<Customer> customers = customerManager.getAllCustomerList();

        Quotes quote = new Quotes();
        model.addAttribute("devis", quote);
        model.addAttribute("devisId", quote.getId());


        model.addAttribute("ListOfcustomers", customers);

        //model.addAttribute("productLine" ,p ) ;

        model.addAttribute("ListProduit", products);


        return "ajouterDevis";

    }

    @PostMapping("/ajouterDevis")
    public String ajouterDevisPost(Model model,
                                   @RequestParam(name = "quotes_number") int quotes_number,
                                   @RequestParam(name = "quote_date") Date quote_Date,

                                   @RequestParam(name = "customer_id") Integer customer_id


                                    )




    {
      /*  Customer cs = customerManager.getCustomerById(customer_id);
        Quotes quotes = new Quotes(quotes_number,quote_Date,null,null,null,null,null,cs) ;

        quotesManager.addQuotes(quotes);

        for (ProductLine p : productlines) {
            productLine.setQuotes(quotes);
            productLine.setQuantity(3);
            productLineManager.addProductLine(productLine);
        }*/


        return "redirect:index";
    }

}
