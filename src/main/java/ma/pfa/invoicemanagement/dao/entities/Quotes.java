package ma.pfa.invoicemanagement.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Quotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quote_Number;

    private Date quote_Date;

    private long totalprice;

    @OneToOne
    private Invoice invoice;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "quotes")
    private Collection<ProductLine> productLines = new ArrayList<>();

}
