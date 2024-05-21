package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Entreprise;
import ma.pfa.invoicemanagement.dao.repositories.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntrepriseManagerMetier implements EntrepriseManager{

@Autowired
    EntrepriseRepository entrepriseRepository ;
    @Override
    public Entreprise getEntrepriseById(Integer id) {
        return entrepriseRepository.findEntrepriseById(id) ;
    }
}
