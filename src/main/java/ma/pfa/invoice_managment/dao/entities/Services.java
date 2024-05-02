package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String description ;

    private String type ;

    @Column(name="Prix")
    private double price ;

    @ManyToMany(mappedBy = "services")
    private Collection<Quotes> quotes = new ArrayList<>() ;
}
