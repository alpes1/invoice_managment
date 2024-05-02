package ma.pfa.invoice_managment.web;

import jakarta.validation.Valid;
import ma.pfa.invoice_managment.metier.QuotesManager;
import ma.pfa.invoice_managment.dao.entities.Quotes;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuotesController {

    @Autowired
    QuotesManager quotesManager ;

    @GetMapping("/genererQuote")
    public String Start () {return "genererQuotes";}

    @GetMapping("/afficherQuotes")

    public String ListerQuotes(Model model,
                               @RequestParam(name = "page" ,defaultValue = "0") int page ,
                               @RequestParam(name = "taille" , defaultValue = "10") int taille,
                               @RequestParam(name = "keyword" , defaultValue = "") String keyword

    )
    {
         Page<Quotes> quotes = quotesManager.getAllQuotes(page, taille);
         model.addAttribute("ListQuotes",quotes);
         model.addAttribute("page",page);
         model.addAttribute("taille",taille);
         return "index";
    }
    @PostMapping("/addQuote")
    public String ajouteQuotes(Model model , @Valid Quotes quote, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "/addQuote";

        quotesManager.addQuotes(quote) ;

        return "redirect:index" ;
    }

}
