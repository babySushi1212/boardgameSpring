package webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpRoleDTO {
    private String employeeName;
    private String employeeEmail;
    private String roleName;
}
