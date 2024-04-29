package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Entity
@Table(name = "Facture")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer invoiceNumber;
    private Date invoiceDate ;
    private String Designation ;
    private int qte ;
    private double price ;
    private double totalPrice ;
    private Date created_at ;
    private Date updated_at ;

    private String logo;

    @ManyToOne
    private Customer customer ;

    @OneToOne(mappedBy = "invoice")
    private Quotes quotes ;

}
