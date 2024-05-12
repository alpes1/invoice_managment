package ma.pfa.invoice_managment.web;

import jakarta.validation.Valid;
import ma.pfa.invoice_managment.dao.entities.Services;
import ma.pfa.invoice_managment.metier.ProductManager;
import ma.pfa.invoice_managment.metier.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServicesController {
    @Autowired
    ServicesManager servicesManager ;

    @GetMapping("/genererService")
    public String Start () {return "index";}

    @GetMapping("/afficherServices")

    public String ListServices(Model model,
                              @RequestParam(name = "page" ,defaultValue = "0") int page ,
                              @RequestParam(name = "taille" , defaultValue = "10") int taille
    )
    {
        Page<Services> services = servicesManager.getAllServices(page, taille);
        model.addAttribute("Listservices",services);
        model.addAttribute("page",page);
        model.addAttribute("taille",taille);
        return "index";
    }
    @GetMapping("/ajouterService")
    public String ajouterServiceGet(Model model)
    {
        model.addAttribute("service" , new Services() ) ;

         return "ajouterService";
    }
    @PostMapping("/ajouterService")
    public String ajouteService(Model model , @Valid Services service, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "/ajouterService";

        servicesManager.addService(service) ;

        return "redirect:index" ;
    }
}
