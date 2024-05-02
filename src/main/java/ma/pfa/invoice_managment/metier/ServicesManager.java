package ma.pfa.invoice_managment.metier;

import ma.pfa.invoice_managment.dao.entities.Services;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface ServicesManager {

    public Page<Services> getAllServices(int page , int taille ) ;


    public Services addService(Services s) ;

    public Services UpdateService(Integer id ) ;

    public Boolean DeleteService(Integer id ) ;

    public Page<Services> getSerivceByType(int page , int taille , String keyword) ;
    public Page<Services> getServicesByDescription(int page , int taille , String keyword) ;
}
