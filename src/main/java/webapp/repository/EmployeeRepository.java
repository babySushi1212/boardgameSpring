package webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webapp.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
