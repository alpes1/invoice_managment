package ma.pfa.invoice_managment.metier;

import jakarta.persistence.Id;
import ma.pfa.invoice_managment.dao.entities.Product;
import ma.pfa.invoice_managment.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductManagerMetier implements ProductManager{

    @Autowired
    ProductRepository productRepository ;
    @Override
    public Page<Product> getAllProducts(int page, int taille) {

        return productRepository.findAll(PageRequest.of(page,taille));

    }



    @Override
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product UpdateProduct(Integer id) {
        return null;
    }

    @Override
    public Boolean DeleteProduct(Integer id) {
        return null;
    }

    @Override
    public Page<Product> getProductByName(int page, int taille, String keyword) {
        return productRepository.findProductByName(keyword,PageRequest.of(page,taille)) ;
    }

    @Override
    public Page<Product> getProductByCategorie(int page, int taille, String keyword) {
        return productRepository.findProductByCategory(keyword,PageRequest.of(page,taille)) ;
    }

    @Override
    public Page<Product> getProductByDescription(int page, int taille, String keyword) {
        return productRepository.findProductByDescription(keyword,PageRequest.of(page,taille)) ;
    }
}
