package ma.pfa.invoicemanagement.dao.repositories;

import ma.pfa.invoicemanagement.dao.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
public Entreprise findEntrepriseById(Integer id ) ;
}
