package ma.pfa.invoicemanagement.web;

import jakarta.validation.Valid;
import ma.pfa.invoicemanagement.dao.entities.Customer;
import ma.pfa.invoicemanagement.metier.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    CustomerManager customerManager ;

    @GetMapping("/listeclient")
    public String listeClient(Model model,
                              @RequestParam(name="page" , defaultValue = "0") int page ,
                              )
    {

    }
    @GetMapping("/ajouterclient")
    public String ajouterCLientGet(Model model )
    {
        model.addAttribute("client" , new Customer() ) ;

        return "ajouterClient";
    }
    @PostMapping("/ajouterclient")
    public String ajouterClientPost(Model model , @Valid Customer customer, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "ajouterClient";

        customerManager.addCustomer(customer);
        return "redirect:/Index";
    }
}
