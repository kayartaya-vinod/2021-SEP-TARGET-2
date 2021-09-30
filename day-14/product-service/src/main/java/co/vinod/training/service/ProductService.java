package co.vinod.training.service;

import co.vinod.training.entity.Product;

public interface ProductService {
    public Product getProductById(Integer id);

    public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize);

    public Iterable<Product> getOutOfStockProducts();

    public Iterable<Product> getProductsInPriceRange(Double min, Double max);

}
