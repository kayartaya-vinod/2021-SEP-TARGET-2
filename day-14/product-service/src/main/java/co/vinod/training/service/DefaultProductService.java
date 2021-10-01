package co.vinod.training.service;

import co.vinod.training.dao.ProductDao;
import co.vinod.training.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("service")
// instructs spring to create an object of this class and keep in the container with the name "service"
public class DefaultProductService implements ProductService {

    // dependency
    @Autowired
    ProductDao dao;

    @Override
    public Product addNewProduct(Product product) {
        // ensure that product's id is null, so that JPA can execute an SQL INSERT command
        product.setProductId(null);
        return dao.save(product); // SQL INSERT is executed
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> op = dao.findById(id);
        return op.isPresent() ? op.get() : null;
    }

    @Override
    public Product updateProduct(Product product) {
        // prefer custom exception over RuntimeException
        if (product.getProductId() == null) {
            throw new RuntimeException("Cannot update product without ID!");
        }
        if (!dao.existsById(product.getProductId())) {
            throw new RuntimeException("Cannot update product. No data found for id " + product.getProductId());
        }

        return dao.save(product); // SQL UPDATE is executed
    }

    @Override
    public Product deleteProduct(Integer id) {
        if (id == null || !dao.existsById(id)) {
            throw new RuntimeException("ID is either null or does not exist in our database");
        }
        // soft delete
        Product p = dao.findById(id).get();
        p.setDiscontinued(1);
        return dao.save(p); // SQL UPDATE is executed to set DISCONTINUED=true

        // hard delete
        // Product p = dao.findById(id).get();
        // dao.delete(p); // SQL DELETE is executed and the record is permanently deleted from the table
        // return p;
    }

    @Override
    public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize) {
        Page<Product> result = dao.findAll(PageRequest.of(pageNum - 1, pageSize));
        return result.hasContent() ? result.getContent() : new ArrayList<>();
        // return result;
    }

    @Override
    public Iterable<Product> getOutOfStockProducts() {
        return dao.findByUnitsInStock(0);
    }

    @Override
    public Iterable<Product> getProductsInPriceRange(Double min, Double max) {
        return dao.findByPriceRange(min, max);
    }
}
