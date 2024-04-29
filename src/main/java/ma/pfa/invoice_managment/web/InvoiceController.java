package ma.pfa.invoice_managment.web;


import jakarta.validation.Valid;
import ma.pfa.invoice_managment.dao.entities.Invoice;
import ma.pfa.invoice_managment.metier.InvoiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class InvoiceController {
@Autowired
    InvoiceManager invoiceManager ;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    @GetMapping("")
    public String Start(){return "genererFacture";}

    @GetMapping("index")
    public String ListInvoice(Model model ,
                              @RequestParam(name = "page", defaultValue = "0") int page ,
                              @RequestParam(name = "taille", defaultValue = "10") int taille ,
                              @RequestParam(name="keyword",defaultValue = "") String keyword
                              )
    {
        Page<Invoice> invoices = invoiceManager.getAllInvoice(page, taille) ;


        model.addAttribute("ListInvoices" , invoices);
        model.addAttribute("pages",page);
        model.addAttribute("taille",taille);
        return "index";
    }
    @PostMapping("ajouterOnce")
    public String ajouterInvoice(Model model ,
                                 @Valid Invoice invoice,
                                 BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "ajouterFacture";
        }
        invoiceManager.addInvoice(invoice) ;
        return "redirect:index";
    }
@PostMapping("/ajouterFacturee")
    public String ajouterFactureAction(Model model ,
                                       @RequestParam(name = "id") int id ,
                                       @RequestParam(name = "InvoiceNumber") Integer InvoiceNumber,
                                       @RequestParam(name = "invoiceDate")Date invoiceDate ,
                                       @RequestParam(name = "Designation") String Designation,
                                       @RequestParam(name = "quantite") int qte ,
                                       @RequestParam(name="price") double price ,
                                       @RequestParam(name="totalPrice")double totalPrice,
                                       @RequestParam(name="logo") MultipartFile logo
) throws IOException {

    StringBuilder fileNames = new StringBuilder();
    Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, logo.getOriginalFilename());
    fileNames.append(logo.getOriginalFilename());
    Files.write(fileNameAndPath, logo.getBytes());



   // Invoice invoice = new Invoice(id, InvoiceNumber, invoiceDate, Designation, qte, price, totalPrice, new Date(), new Date(), logo.toString(), null);
    //invoiceManager.addInvoice(invoice);
    return "redirect:Index";
}
    }

