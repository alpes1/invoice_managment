package ma.pfa.invoicemanagement.metier;

import ma.pfa.invoicemanagement.dao.entities.Product;
import ma.pfa.invoicemanagement.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class ProductManagerMetier implements ProductManager{

    @Autowired
    ProductRepository productRepository ;
    @Override
    public Page<Product> getAllProducts(int page, int taille) {

        return productRepository.findAll(PageRequest.of(page,taille));

    }


    @Override
    public List<Product> getAllProductsList()
    {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product UpdateProduct(Product product) {
        return productRepository.save(product);
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

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Page<Product> getAllProduct(int page, int taille) {
        return productRepository.findAll(PageRequest.of(page,taille));
    }

    @Override
    public boolean deleteProduct(Integer id) {
        try {

            productRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }
}
