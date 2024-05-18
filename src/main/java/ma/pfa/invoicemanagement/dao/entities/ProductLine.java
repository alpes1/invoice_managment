package ma.pfa.invoicemanagement.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    int quantity ;
    @ManyToOne
    private Quotes quotes ;

    @ManyToOne
    private Product product ;


}
