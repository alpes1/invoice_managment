package ma.pfa.invoice_managment.metier;

import ma.pfa.invoice_managment.dao.entities.Services;
import ma.pfa.invoice_managment.dao.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ServicesManagerMetier implements ServicesManager {

    @Autowired
    ServicesRepository servicesRepository;

    public Page<Services> getAllServices(int page , int taille )
    {
        return servicesRepository.findAll(PageRequest.of(page,taille));
    };


    public Services addService(Services s)
    {
        return servicesRepository.save(s) ;
    };

    public Services UpdateService(Integer id ) {return null ;};

    public Boolean DeleteService(Integer id ) {return null ;};

    public Page<Services> getSerivceByType(int page , int taille , String keyword)
    {
        return servicesRepository.findServiceByType(keyword,PageRequest.of(page,taille));
    };
    public Page<Services> getServicesByDescription(int page , int taille , String keyword)
    {
        return servicesRepository.findServicesByDescription(keyword, PageRequest.of(page,taille));
    };
}
