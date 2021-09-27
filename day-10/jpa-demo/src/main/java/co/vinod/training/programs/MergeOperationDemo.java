package co.vinod.training.programs;

import co.vinod.training.entity.Employee;
import co.vinod.training.utils.DateUtil;
import co.vinod.training.utils.JpaUtil;

import javax.persistence.EntityManager;

public class MergeOperationDemo {
    public static void main(String[] args) {

        // whenever we create object, it is always a TRANSIENT object
        Employee emp1 = new Employee(34, "Kishore K", DateUtil.toDate("2010-01-02"),
                25600.0, "kishorek34@gmail.com");


        EntityManager em = JpaUtil.createEntityManager();
        em.merge(emp1);
        // first an SQL SELECT is executed to get the data based on emp1.id
        // if found, emp1 is considered as a dirty object (only if the fields have different value than in the table)
        // if not found, emp1 is considered as a new object
        // and emp1 now is a MANAGED object

        // during the commit, appropriate SQL statement is created and executed
        em.getTransaction().begin();
        em.getTransaction().commit();

    }
}
