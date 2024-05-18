package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductManager {


 public Page<Product> getAllProducts(int page , int taille) ;

 public List<Product> getAllProductsList() ;

 public Product addProduct(Product p) ;

 public Product UpdateProduct(Product product) ;

 public Boolean DeleteProduct(Integer id ) ;

 public Page<Product> getProductByName(int page , int taille , String keyword) ;

 public Page<Product> getProductByCategorie(int page , int taille , String keyword) ;
 public Page<Product> getProductByDescription(int page , int taille , String keyword) ;

 public Product getProductById(Integer id ) ;
 public Page<Product> getAllProduct(int page , int taille) ;

 public boolean deleteProduct(Integer id ) ;
}
