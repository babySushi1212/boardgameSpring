package webapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import webapp.dto.EmpRoleDTO;
import webapp.dto.EmployeeDTO;
import webapp.dto.EmployeeProjection;
import webapp.pojo.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // projection
    @Query("SELECT new webapp.dto.EmployeeDTO(employeeName, employeeEmail, employeePhone) FROM Employee")
    List<EmployeeDTO> findAllDTO();

    // use projection class (DTO)
    @Query("SELECT new webapp.dto.EmpRoleDTO(e.employeeName, e.employeeEmail, r.roleName) " +
        "FROM Employee e JOIN Role r ON e.roleNo = r.roleNo")
    List<EmpRoleDTO> findJoin();

    // use projection interface
    @Query("SELECT e.employeeName, e.employeeEmail, r.roleName FROM Employee e JOIN Role r ON e.roleNo = r.roleNo")
    List<EmployeeProjection> findEmployeesAndRoles();

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.employeeName = :employeeName," +
            " e.employeePhone = :employeePhone WHERE e.employeeNo = :employeeNo")
    Integer updateEmployeePartial(@Param("employeeNo") Integer employeeNo,
                               @Param("employeeName") String employeeName,
                               @Param("employeePhone") String employeePhone);
}
