package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;

import java.util.Collection;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String customerName ;
    private String customarEmail ;

    private String phoneNumber ;

    private String address ;

    @OneToMany(mappedBy = "customer")
    private Collection<Invoice> invoice ;


    @OneToMany(mappedBy = "customer")

    private Collection<Quotes> quotes ;



}
