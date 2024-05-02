package ma.pfa.invoice_managment.web;

import jakarta.validation.Valid;
import ma.pfa.invoice_managment.dao.entities.Product;
import ma.pfa.invoice_managment.dao.entities.Quotes;
import ma.pfa.invoice_managment.metier.ProductManager;
import ma.pfa.invoice_managment.metier.QuotesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    ProductManager productManager ;

    @GetMapping("/genererProduct")
    public String Start () {return "index";}

    @GetMapping("/afficherproduct")

    public String ListProduct(Model model,
                               @RequestParam(name = "page" ,defaultValue = "0") int page ,
                               @RequestParam(name = "taille" , defaultValue = "10") int taille
    )
    {
        Page<Product> products = productManager.getAllProducts(page, taille);
        model.addAttribute("ListProduct",products);
        model.addAttribute("page",page);
        model.addAttribute("taille",taille);
        return "index";
    }
    @PostMapping("/addProduct")
    public String ajouteProduct(Model model , @Valid Product product, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "/addProduct";

        productManager.addProduct(product) ;

        return "redirect:index" ;
    }



}
