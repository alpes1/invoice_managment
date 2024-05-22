package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Entreprise;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface EntrepriseManager {

    public Entreprise getEntrepriseById(Integer id);

    public Entreprise addEntreprise(Entreprise e);

    public Entreprise getFirst() ;
    public Entreprise getEntrepriseByUsername(String username) ;

}
