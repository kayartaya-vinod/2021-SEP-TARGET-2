package co.vinod.training.programs;

import co.vinod.training.entity.Category;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetOneCategoryWithCorrespondingProducts {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.createEntityManager();
        Category c = em.find(Category.class, 1); // fetches only category record

        log.debug("Category name = {}", c.getCategoryName());
        log.debug("Category desc = {}", c.getDescription());
        log.debug("Products in this category are:");

        c.getProductList() // fetches products (lazy) at this time
                .forEach(System.out::println);
    }
}
