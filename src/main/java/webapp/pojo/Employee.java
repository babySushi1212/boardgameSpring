package webapp.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok: Gene getter/setter by @getter/@setter
@AllArgsConstructor // Lombok: Auto gene args constructor
@NoArgsConstructor // Lombok: read above
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_NO")
    private int employeeNo;

    @Column(name = "EMPLOYEE_NAME", nullable = false, length = 10)
    private String employeeName;

    @Column(name = "EMPLOYEE_PHONE", length = 20)
    private String employeePhone;

    @Column(name = "EMPLOYEE_ADDRESS", length = 100)
    private String employeeAddress;

    @Column(name = "EMPLOYEE_EMAIL", nullable = false, length = 50, unique = true)
    private String employeeEmail;

    @Column(name = "EMPLOYEE_PASSWORD", nullable = false, length = 40)
    private String employeePassword;

    @Column(name = "ROLE_NO")
    private int roleNo;

    @Column(name = "EMPLOYEE_STATUS")
    private boolean employeeStatus;

    // constructors, getters, and setters
}
