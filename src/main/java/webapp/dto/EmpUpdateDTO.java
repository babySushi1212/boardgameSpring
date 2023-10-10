package webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpUpdateDTO {
    // this also called projection class
    private Integer employeeNo;
    private String employeeName;
    private String employeePhone;
}
