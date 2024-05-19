package ma.pfa.invoicemanagement.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class ChartController {

    @GetMapping("/chartData")
    public List<Integer> getChartData() {
        // This is just an example, you can fetch data from your database
        return Arrays.asList(12, 19, 3, 5, 2, 3);
    }
}
