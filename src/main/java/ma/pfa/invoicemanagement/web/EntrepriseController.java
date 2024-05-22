package ma.pfa.invoicemanagement.web;

import jakarta.servlet.http.HttpSession;
import ma.pfa.invoicemanagement.dao.entities.Entreprise;
import ma.pfa.invoicemanagement.metier.EntrepriseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class EntrepriseController {
    @Autowired
    EntrepriseManager entrepriseManager ;

    @GetMapping("/rregister")
    public String re() {
        return "RegisterEntreprise"; // Votre page de connexion
    }
    @PostMapping("/register")
    public String registerUser(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "ice") String ice,
            @RequestParam(name = "date_Creation") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date_Creation,
            @RequestParam(name = "patent") String patent,
            @RequestParam(name = "capital") String capital,
            @RequestParam(name = "phoneNumber") String phoneNumber,
            @RequestParam(name = "rc") String rc,
            @RequestParam(name = "identifiant_fiscale") String identifiant_fiscale ,
            @RequestParam(name = "password") String password ,
            @RequestParam(name = "username") String username )
    {



            Entreprise entreprise = new Entreprise();
            entreprise.setName(name);
            entreprise.setIce(ice);
            entreprise.setLogo("/images/company.jpeg");
            entreprise.setDate_Creation(date_Creation);
            entreprise.setPatent(patent);
            entreprise.setCapital(capital);
            entreprise.setPhoneNumber(phoneNumber);
            entreprise.setRc(rc);
            entreprise.setIdentifiant_fiscale(identifiant_fiscale);
            entreprise.setUsername(username);
            entreprise.setPassword(password);
            System.out.println(entreprise.getDate_Creation());

            entrepriseManager.addEntreprise(entreprise);
           return "redirect:/login";

    }




    @GetMapping("login")
   public String login() {
       return "login"; // Votre page de connexion
   }
}
