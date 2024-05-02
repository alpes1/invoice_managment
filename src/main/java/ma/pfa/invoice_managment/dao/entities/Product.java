package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Produit")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    @Column(name = "Categorie")
    private String category ;

    private String description ;
    @Column(name = "prix Unitaire")
    private Double price ;

    @ManyToMany(mappedBy ="product" )
    private Collection<Quotes> quotes = new ArrayList<>() ;



}
