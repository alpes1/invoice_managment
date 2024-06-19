package ma.pfa.invoicemanagement.web;

import ma.pfa.invoicemanagement.dao.entities.Invoice;
import ma.pfa.invoicemanagement.dao.entities.Product;
import ma.pfa.invoicemanagement.dao.entities.ProductLine;
import ma.pfa.invoicemanagement.dao.entities.Quotes;
import ma.pfa.invoicemanagement.metier.InvoiceManager;
import ma.pfa.invoicemanagement.metier.ProductLineManager;
import ma.pfa.invoicemanagement.metier.ProductManager;
import ma.pfa.invoicemanagement.metier.QuotesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    ProductLineManager productLineManager ;
    @Autowired
    ProductManager productManager ;

    @Autowired
    InvoiceManager invoiceManager;
    @Autowired
    QuotesManager quotesManager;
    @GetMapping("/dashboard")
    public String  totalsells(Model model)
    {
         double sum = productLineManager.sumAllProductLines() ;

         List<Double> listSells = new ArrayList<>() ;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for (int month = 1; month <= 12; month++) {
            Double totalPrice = quotesManager.getTotalPriceByYearAndMonth(currentYear,month);
            if (totalPrice == null) {
                totalPrice = 0.0;
            }
            listSells.add(totalPrice);
        }


        model.addAttribute("totalsells" ,sum) ;
        List<Quotes> quotes = quotesManager.getAllQuotes();

        model.addAttribute("totalQuotes", quotes.size());

        model.addAttribute("listSells" , listSells) ;

        List<Product> products = productManager.getAllProductsList() ;
        List<String> product_name = new ArrayList<>() ;
        List<Double> product_sold = new ArrayList<>() ;

        int soldP =0 ;
        for(Product p : products)
        {
            product_name.add(p.getName());
            double sold =0 ;

            for(ProductLine pl : p.getProductLines() )
            {
                if(pl.getQuotes().getInvoice() != null)
                    sold+=pl.getQuantity();
                    soldP+=pl.getQuantity();

            }
            product_sold.add(sold);
        }
        model.addAttribute("product_sold" , product_sold) ;
        model.addAttribute("produitVendus" , soldP) ;
        model.addAttribute("product_name" , product_name) ;


        return "Dashboard";

    }


}
