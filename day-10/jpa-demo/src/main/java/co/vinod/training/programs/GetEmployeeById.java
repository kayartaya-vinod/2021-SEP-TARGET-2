package co.vinod.training.programs;

import co.vinod.training.entity.Employee;
import co.vinod.training.utils.DateUtil;
import co.vinod.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetEmployeeById {

    public static void main(String[] args) {

        Integer id = 3;

        EntityManager em = JpaUtil.createEntityManager();
        Employee emp = em.find(Employee.class, id); // hibernate creates a new object, getting data from db.

        if(emp==null){
            log.debug("No employee data found for id {}", id);
        }
        else{
            log.debug("employee with id {} is {}", id, emp);
            // at this time, emp is a MANAGED object

            // now, emp becomes MANAGED+dirty object
            emp.setHireDate(DateUtil.toDate("2009-10-11"));

            em.getTransaction().begin();
            em.getTransaction().commit();
        }

        em.close(); // connection and other resources are leased!! Very important
    }
}
