package ma.pfa.invoicemanagement.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

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

    private LocalDate created_at ;

    private LocalDate updated_at ;

    @ManyToOne
    private Customer customer ;

   @OneToMany(mappedBy = "invoice")
   private Collection<ProductLine> productLines = new ArrayList<>();

    @OneToOne(mappedBy = "invoice")

    private Quotes quotes ;

}
