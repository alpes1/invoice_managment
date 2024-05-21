package ma.pfa.invoicemanagement.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ma.pfa.invoicemanagement.dao.entities.Customer;
import ma.pfa.invoicemanagement.dao.entities.Product;
import ma.pfa.invoicemanagement.dao.entities.ProductLine;
import ma.pfa.invoicemanagement.dao.entities.Quotes;
import ma.pfa.invoicemanagement.metier.CustomerManager;
import ma.pfa.invoicemanagement.metier.ProductLineManager;
import ma.pfa.invoicemanagement.metier.ProductManager;
import ma.pfa.invoicemanagement.metier.QuotesManager;

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

    // Crud Actions

    @GetMapping("/listedevis")
    public String ListProducts(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "taille", defaultValue = "10") int taille) {

        Page<Quotes> devis = quotesManager.getAllQuotes(page, taille);


        model.addAttribute("ListDevis", devis);
        model.addAttribute("ListProductLines", productLineManager);

        model.addAttribute("page", page);
        model.addAttribute("taille", taille);
        return "listeDevis";
    }


    @GetMapping("/ajouterdevis")
    public String ajouterDevisGet(Model model) {
        List<Product> products = productManager.getAllProductsList();
        List<Customer> customers = customerManager.getAllCustomerList();

        model.addAttribute("ListOfcustomers", customers);
        model.addAttribute("ListProduit", products);
        model.addAttribute("devis", new Quotes());

        return "ajouterDevis";

    }


    @PostMapping("/ajouterdevis")
    public String ajouterDevisPost(Model model,
            @RequestParam(name = "quote_Number") int quote_number,
            @RequestParam(name = "quote_Date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date quote_Date,
            @RequestParam(name = "customer") Integer customer,
            @RequestParam(name = "product") List<Integer> products,
            @RequestParam(name = "quantity") List<Integer> quantities,
            @RequestParam(name = "price") List<Double> prices)

    {
        Customer cs = customerManager.getCustomerById(customer);

        Quotes quotes = new Quotes();
        quotes.setQuote_Number(quote_number);
        quotes.setQuote_Date(quote_Date);
        quotes.setCustomer(cs);

        Quotes createdQuotes = quotesManager.addQuotes(quotes);
        long  totalprice = 0 ;
        int numberOfProductLines = products.size();
        for (int i = 0; i < numberOfProductLines; i++) {
            Product product = productManager.getProductById(products.get(i)) ;
            totalprice += prices.get(i) * quantities.get(i) * ( (product.getTaux_tva()/100) + 1 );
            ProductLine productLine = new ProductLine();
            productLine.setProduct(product);
            productLine.setQuotes(createdQuotes);
            productLine.setQuantity(quantities.get(i));
            productLine.setPrice(prices.get(i));
            productLineManager.addProductLine(productLine);
        }
        quotes.setTotalprice(totalprice);
        quotesManager.updateQuotes(quotes);
        return "redirect:/listedevis";
    }

    @GetMapping("/deletedevis")
    public String deleteProduit(Model model, @RequestParam(name = "id") Integer id) {
        if (productManager.deleteProduct(id)) {
            return "redirect:/listeproduit";
        } else {
            return "error";
        }
    }

    @GetMapping("/editdevis")
    public String editProduit(Model model, @RequestParam(name = "id") Integer id) {
       Quotes quotes = quotesManager.getQuotesById(id);
        if (quotes != null) {
            model.addAttribute("quotes",quotes);
            return "updateDevis";
        } else {
            return "error";
        }
    }

    @PostMapping("/updatedevis")
    public String ajouterProductAction(@ModelAttribute("QuotesToBeUpdated") Quotes quotes) {
        quotesManager.updateQuotes(quotes);
        return "redirect:/listedevis";
    }

}
