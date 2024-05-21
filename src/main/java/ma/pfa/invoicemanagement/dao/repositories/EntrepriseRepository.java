package ma.pfa.invoicemanagement.dao.repositories;

import ma.pfa.invoicemanagement.dao.entities.Entreprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
public Entreprise findEntrepriseById(Integer id ) ;
public List<Entreprise> findAll() ;
}
