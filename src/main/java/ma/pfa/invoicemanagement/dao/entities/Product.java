package ma.pfa.invoicemanagement.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.pfa.invoicemanagement.metier.ProductManager;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    private String category ;

    private String description ;

    private Double price ;

    private Double taux_tva ;


    @OneToMany(mappedBy = "product")
    private Collection<ProductLine> productLines = new ArrayList<>();


}