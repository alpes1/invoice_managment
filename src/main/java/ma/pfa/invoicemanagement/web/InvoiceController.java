package ma.pfa.invoicemanagement.web;

import jakarta.validation.Valid;
import ma.pfa.invoicemanagement.dao.entities.Customer;
import ma.pfa.invoicemanagement.dao.entities.Quotes;
import ma.pfa.invoicemanagement.metier.CustomerManager;
import ma.pfa.invoicemanagement.metier.InvoiceManager;
import ma.pfa.invoicemanagement.metier.QuotesManager;
import ma.pfa.invoicemanagement.dao.entities.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    InvoiceManager invoiceManager;
    @Autowired
    CustomerManager customerManager;
    @Autowired
    QuotesManager quotesManager;


    @GetMapping("/index")
    public String ListInvoice(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "taille", defaultValue = "6") int taille

    ) {
        Page<Invoice> invoices = invoiceManager.getAllInvoice(page, taille);

        int[] pages = new int[invoices.getTotalPages()];
        model.addAttribute("ListInvoices", invoices);
        model.addAttribute("page", page);
        model.addAttribute("pages", pages);

        return "Index";
    }

    @GetMapping("/ajouterFacture")
    public String ajouterInvoiceGet(Model model) {
        List<Customer> customers = customerManager.getAllCustomerList();
        List<Quotes> quotes = quotesManager.getAllQuotesList();

        model.addAttribute("ListCLients", customers);
        model.addAttribute("ListQuotes", quotes);
        model.addAttribute("Invoice", new Invoice());
        return "ajouterFacture";
    }

    @PostMapping("/ajouterFacture")
    public String ajouterInvoicePost(Model model,
                                     @Valid Invoice invoice,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:error.html";
        invoice.setCreated_at(LocalDate.now());
        invoice.setUpdated_at(LocalDate.now());
        invoiceManager.addInvoice(invoice);
        return "redirect:index";
    }

    /*
     * @PostMapping("/ajouterfacture.html")
     * public String ajouterFactureAction(Model model ,
     *
     * @RequestParam(name = "id") int id ,
     *
     * @RequestParam(name = "InvoiceNumber") Integer InvoiceNumber,
     *
     * @RequestParam(name = "invoiceDate")Date invoiceDate ,
     *
     * @RequestParam(name = "Designation") String Designation,
     *
     * @RequestParam(name = "quantite") int qte ,
     *
     * @RequestParam(name="price") double price ,
     *
     * @RequestParam(name="totalPrice")double totalPrice,
     *
     * @RequestParam(name="logo") MultipartFile logo
     * ) throws IOException {
     *
     * StringBuilder fileNames = new StringBuilder();
     * Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY,
     * logo.getOriginalFilename());
     * fileNames.append(logo.getOriginalFilename());
     * Files.write(fileNameAndPath, logo.getBytes());
     *
     *
     *
     * // Invoice invoice = new Invoice(id, InvoiceNumber, invoiceDate, Designation,
     * qte, price, totalPrice, new Date(), new Date(), logo.toString(), null);
     * //invoiceManager.addInvoice(invoice);
     * return "redirect:Index";
     * }
     */

    @PostMapping("/ajouter")
    public String ajouterInvoiceAction(@ModelAttribute("InvoiceToBeUpdated") Invoice invoice) {
        invoice.setUpdated_at(LocalDate.now());
        invoiceManager.updateInvoice(invoice);
        return "redirect:/index";
    }

    @GetMapping("/editInvoice")
    public String editnvoice(Model model, @RequestParam(name = "id") Integer id) {
        Invoice invoice = invoiceManager.getInvoiceById(id);

        List<Customer> customers = customerManager.getAllCustomerList();
        List<Quotes> quotes = quotesManager.getAllQuotesList();

        if (invoice != null) {
            model.addAttribute("InvoiceToBeUpdated", invoice);
            model.addAttribute("ListClients", customers);
            model.addAttribute("ListQuotes", quotes);
            return "UpdateInvoice";
        } else {
            return "error";
        }
    }

    @GetMapping("/deleteInvoice")
    public String deleteInvoiceById(Model model, @RequestParam(name = "id") Integer id) {
        if (!invoiceManager.deleteInvoice(id))
            return "error";

        return "redirect:index";

    }

    @GetMapping("/generateInvoiceFromQuotes")
    public String generateInvoiceFromQuotes(Model model, @RequestParam(name = "id") Integer id) {
        Quotes devis = quotesManager.getQuotesById(id);

        if (devis != null) {
            if (devis.getInvoice() == null) {
                Invoice invoice = new Invoice();
                invoice.setQuotes(devis);
                invoice.setInvoiceDate(LocalDate.now());
                invoice.setInvoiceNumber(devis.getQuote_Number());
                invoice.setCustomer(devis.getCustomer());
                invoiceManager.addInvoice(invoice);
                devis.setInvoice(invoice);
                quotesManager.updateQuotes(devis) ;
            }
            return "redirect:/";
        } else {
            return "error";
        }
    }


}
