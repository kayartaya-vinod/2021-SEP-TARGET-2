package co.vinod.training.dao;

import co.vinod.training.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// At the runtime, Spring boot creates a class on the fly that implements ProductDao using JPA and
// provides all functionalities
@Repository("dao") // instructs spring to create an instance of this type and keep in container with name "dao"
public interface ProductDao extends PagingAndSortingRepository<Product, Integer> {

    // method convention --> findByXxx --> xxx is the name of the field in the entity class
    public Iterable<Product> findByUnitsInStock(Integer unitsInStock);

    @Query("from Product where unitPrice between ?1 and ?2")
    public Iterable<Product> findByPriceRange(Double min, Double max);
}


// public User findByEmailAndPassword(String email, String password);
// select * from users where email=? and password=?