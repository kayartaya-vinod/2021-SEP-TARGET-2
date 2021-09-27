package co.vinod.training.programs;

import co.vinod.training.entity.Employee;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
public class AddNewEmployee {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");
        EntityManager em = emf.createEntityManager();
        // C: persist(..)
        // R: find(..)
        // U: merge(..)
        // D: remove(..)

        log.debug("emf is an instanceof {}", emf.getClass().getName());
        log.debug("em is an instanceof {}", em.getClass().getName());

        Employee emp1 = new Employee("Ajay Kumar", 25000.0, "ajayk@xmpl.com");



        // at this time, emp1 (according to hibernate) as state : Transient
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(emp1); // now, emp1 has state : Managed+new
            tx.commit(); // at this time, SQL DML are generated based on the managed beans' state
            // new-> INSERT, dirty-> UPDATE, marked-for-removal--> DELETE
            log.debug("commit successful");
        } catch (Exception e) {
            log.debug("Couldn't commit; rolling back!", e);
            tx.rollback();
        }

    }
}
