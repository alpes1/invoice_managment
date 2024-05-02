package ma.pfa.invoice_managment.metier;

import ma.pfa.invoice_managment.dao.entities.Product;
import ma.pfa.invoice_managment.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface ProductManager {


 public Page<Product> getAllProducts(int page , int taille) ;


 public Product addProduct(Product p) ;

 public Product UpdateProduct(Integer id ) ;

 public Boolean DeleteProduct(Integer id ) ;

 public Page<Product> getProductByName(int page , int taille , String keyword) ;

 public Page<Product> getProductByCategorie(int page , int taille , String keyword) ;
 public Page<Product> getProductByDescription(int page , int taille , String keyword) ;
}
