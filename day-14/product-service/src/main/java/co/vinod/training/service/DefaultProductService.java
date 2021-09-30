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
    public Product getProductById(Integer id) {
        Optional<Product> op = dao.findById(id);
        return op.isPresent() ? op.get() : null;
    }

    @Override
    public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize) {
        Page<Product> result = dao.findAll(PageRequest.of(pageNum-1, pageSize));
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
