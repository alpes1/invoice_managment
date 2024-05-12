package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToMany(mappedBy ="product" )
    private Collection<Quotes> quotes = new ArrayList<>() ;
}