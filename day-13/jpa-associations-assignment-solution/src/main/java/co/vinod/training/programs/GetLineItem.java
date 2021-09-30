package co.vinod.training.programs;

import co.vinod.training.entity.LineItem;
import co.vinod.training.entity.LinkeItemPK;
import co.vinod.training.utils.JpaUtil;

import javax.persistence.EntityManager;

public class GetLineItem {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.createEntityManager();
        LineItem li = em.find(LineItem.class, new LinkeItemPK(10248, 42));
        System.out.println(li);
    }
}
