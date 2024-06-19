package ma.pfa.invoicemanagement.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String name ;

    private String logo ;

    private String ice ;

    private Date date_Creation ;

    private String patent ;

    private String capital ;

    private String phoneNumber ;

    private String rc ;

    private String identifiant_fiscale ;

    private String password;

    private String username;


}
