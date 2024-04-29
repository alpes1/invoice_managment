package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id ;

    private String Description ;

    private String Type ;

    @Column(name="Prix")
    private double price ;

    @ManyToMany(mappedBy = "service")
    private Collection<Quotes> quotes = new ArrayList<>() ;
}
