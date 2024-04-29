package ma.pfa.invoice_managment.dao.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;

import java.util.Collection;

@Entity
@Table(name = "Client")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String customerName ;
    private String customarEmail ;

    private String phoneNumber ;

    private String Address ;

    @OneToMany(mappedBy = "customer")
    private Collection<Invoice> invoice ;


    @OneToMany(mappedBy = "customer")

    private Collection<Quotes> quotes ;



}
