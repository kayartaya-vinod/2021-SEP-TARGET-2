package co.vinod.training.programs;

import co.vinod.training.entity.Product;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class JpqlDemo {
    static EntityManager em;

    public static void main(String[] args) {
        em = JpaUtil.createEntityManager();
        // printAllProducts();
        // printProductsBetweenPriceRange(50.0, 150.0);
        // printProductNamesNotInStock();
        printProductDetailsNotInStock();
        em.close();
    }

    static void printProductDetailsNotInStock() {
        String jpql = "select productName, unitPrice, quantityPerUnit from Product where unitsInStock=0";
        TypedQuery<Object[]> qry = em.createQuery(jpql, Object[].class);
        List<Object[]> list = qry.getResultList();
        list.forEach(ar -> System.out.printf("Name = %s, Price = %s, Desc = %s%n", ar[0], ar[1], ar[2]));
    }

    static void printProductNamesNotInStock() {
        String jpql = "select productName from Product where unitsInStock=0";
        TypedQuery<String> qry = em.createQuery(jpql, String.class);
        List<String> list = qry.getResultList();
        list.forEach(log::debug);
    }

    static void printProductsBetweenPriceRange(Double min, Double max) {
        // String jpql = "from Product where unitPrice between ?0 and ?1 order by unitPrice desc";
        String jpql = "from Product where unitPrice between :MIN_PRICE and :MAX_PRICE order by unitPrice desc";
        TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
        qry.setParameter("MIN_PRICE", min);
        qry.setParameter("MAX_PRICE", max);

        List<Product> list = qry.getResultList();
        list.forEach(System.out::println);
    }

    static void printAllProducts() {
        // SELECT * FROM PRODUCTS ORDER BY UNIT_PRICE DESC
        // String jpql = "select p from co.vinod.training.entity.Product p order by p.unitPrice desc";
        String jpql = "from Product order by unitPrice desc";
        TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
        qry.setMaxResults(5);

        List<Product> list = qry.getResultList(); // SQL is sent to server and executed here
        list.forEach(System.out::println);
    }
}
