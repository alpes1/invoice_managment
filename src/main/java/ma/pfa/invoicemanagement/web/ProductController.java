package ma.pfa.invoicemanagement.web;

import jakarta.validation.Valid;
import ma.pfa.invoicemanagement.dao.entities.Product;
import ma.pfa.invoicemanagement.metier.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    ProductManager productManager;

    @GetMapping("/listeproduit")
    public String ListProducts(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "taille", defaultValue = "15") int taille) {
        Page<Product> products = productManager.getAllProduct(page, taille);
        model.addAttribute("ListProduct", products);
        model.addAttribute("page", page);
        model.addAttribute("taille", taille);
        return "listeProduit";
    }

    @GetMapping("/ajouterproduit")
    public String ajouterProduitGet(Model model) {
        model.addAttribute("product", new Product());
        return "ajouterProduit";
    }

    @PostMapping("/ajouterproduit")
    public String ajouterProduitPost(Model model, @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "error";
        productManager.addProduct(product);
        return "redirect:/listeproduit";
    }

    @GetMapping("/deleteProduit")
    public String deleteProduit(Model model, @RequestParam(name = "id") Integer id) {
        if (productManager.deleteProduct(id)) {
            return "redirect:/listeproduit";
        } else {
            return "error";
        }
    }

    @GetMapping("/editproduit")
    public String editProduit(Model model, @RequestParam(name = "id") Integer id) {
        Product product = productManager.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "updateproduct";
        } else {
            return "error";
        }
    }

    @PostMapping("/updateproduct")
    public String ajouterProductAction(@ModelAttribute("ProductToBeUpdated") Product product) {
        productManager.UpdateProduct(product);
        return "redirect:/listeproduit";
    }

}