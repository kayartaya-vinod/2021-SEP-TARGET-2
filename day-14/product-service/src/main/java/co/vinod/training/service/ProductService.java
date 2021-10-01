package co.vinod.training.service;

import co.vinod.training.entity.Product;

public interface ProductService {

    // CRUD operations

    public Product addNewProduct(Product product);

    public Product getProductById(Integer id);

    public Product updateProduct(Product product);

    public Product deleteProduct(Integer id); // soft or hard delete ??

    // QUERY operations

    public Iterable<Product> getAllProducts(Integer pageNum, Integer pageSize);

    public Iterable<Product> getOutOfStockProducts();

    public Iterable<Product> getProductsInPriceRange(Double min, Double max);

}
