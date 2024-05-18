package ma.pfa.invoicemanagement.dao.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

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

    private String name ;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format")
    private String email;

    private String phonenumber ;

    private String address ;

    @OneToMany(mappedBy = "customer")
    private Collection<Invoice> invoice ;


    @OneToMany(mappedBy = "customer")

    private Collection<Quotes> quotes ;



}
