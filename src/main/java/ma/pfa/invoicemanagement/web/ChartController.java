/*
package ma.pfa.invoicemanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@Controller
public class ChartController {

    @GetMapping("/chart")
    public String getChart(Model model) {
        Double totalsells = 12345.67; // Exemple de valeur, vous pouvez calculer ou récupérer cette valeur depuis la base de données

        // Exemple de données pour le graphique
        List<Integer> chartData = Arrays.asList(65, 59, 80, 81, 56, 55, totalsells.intValue());

        model.addAttribute("totalsells", totalsells);
        model.addAttribute("chartData", chartData);

        return "Dashboard"; // Assurez-vous que le nom du template est correct
    }
}*/
