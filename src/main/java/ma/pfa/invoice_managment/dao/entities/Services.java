package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Entity

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
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
