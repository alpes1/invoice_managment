package ma.pfa.invoice_managment.dao.repositories;

import ma.pfa.invoice_managment.dao.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
