package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Produit")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id ;

    private String name ;

    @Column(name = "Categorie")
    private String Category ;

    private String Description ;
    @Column(name = "prix Unitaire")
    private Double Price ;

    @ManyToMany(mappedBy ="product" )
    private Collection<Quotes> quotes = new ArrayList<>() ;



}
