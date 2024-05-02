package ma.pfa.invoice_managment.dao.repositories;

import ma.pfa.invoice_managment.dao.entities.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<Services,Integer> {

    Page<Services> findServiceByType(String keyword , Pageable pageable) ;

    Page<Services> findServicesByDescription(String keyword , Pageable pageable) ;


}
