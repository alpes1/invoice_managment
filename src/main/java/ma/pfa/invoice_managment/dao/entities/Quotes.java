package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Devis")
@Data
public class Quotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;
    @Column(name = "Date_Devis")
    Date Quote_Date ;

    @OneToOne
    private Invoice invoice ;

    @ManyToOne
    private Customer customer ;

    @ManyToMany
    private Collection<Product> product ;

    @ManyToMany
    private Collection<Service> service ;
}
