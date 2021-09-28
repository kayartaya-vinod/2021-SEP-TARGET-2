package co.vinod.training.programs;

import co.vinod.training.entity.Product;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetOneProductWithCategory {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.createEntityManager();
        Product p = em.find(Product.class, 55); // fetches both product + category using join (eager)
        log.debug("Product name = {}", p.getProductName());
        log.debug("Category name = {}", p.getCategory().getCategoryName());

    }
}
