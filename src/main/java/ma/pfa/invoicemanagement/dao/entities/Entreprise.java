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
    Integer id ;

    String name ;

    String Logo ;

    String Ice ;

    Date date_Creation ;

    String Patent ;

    String Capital ;



}
