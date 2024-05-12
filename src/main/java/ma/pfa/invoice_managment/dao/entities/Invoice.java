package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer invoiceNumber;

    private LocalDate invoiceDate ;
    private String Designation ;
    private int qte ;
    @Min(0)
    private double price ;
    private Double totalPrice ;
    private LocalDate created_at ;
    private LocalDate updated_at ;


    @ManyToOne
    private Customer customer ;

    @OneToOne(mappedBy = "invoice")
    private Quotes quotes ;

    public Invoice(Integer invoiceNumber, LocalDate invoiceDate, String designation, int qte, double price, Double totalPrice, Object o, LocalDate now, Customer customer, Quotes quotes) {
    }
}
