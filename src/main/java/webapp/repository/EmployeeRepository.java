package webapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import webapp.dto.EmpRoleDTO;
import webapp.dto.EmployeeDTO;
import webapp.dto.EmployeeProjection;
import webapp.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // projection
    @Query("SELECT new webapp.dto.EmployeeDTO(employeeName, employeeEmail, employeePassword)" +
        " FROM Employee")
    List<EmployeeDTO> findAllDTO();

    // use projection class (DTO)
    @Query("SELECT new webapp.dto.EmpRoleDTO(e.employeeName, e.employeeEmail, r.roleName) " +
        "FROM Employee e JOIN Role r ON e.roleNo = r.roleNo")
    List<EmpRoleDTO> findJoin();

    // use projection interface
    @Query("SELECT e.employeeName, e.employeeEmail, r.roleName FROM Employee e JOIN Role r ON e.roleNo = r.roleNo")
    List<EmployeeProjection> findEmployeesAndRoles();

}
