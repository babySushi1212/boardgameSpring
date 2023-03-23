package webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    // this also called projection class
    private String employeeName;
    private String employeeEmail;
    private String employeePassword;
}
