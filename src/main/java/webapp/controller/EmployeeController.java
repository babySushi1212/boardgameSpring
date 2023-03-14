package webapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webapp.dto.EmployeeDTO;
import webapp.dto.OpenHourDTO;
import webapp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired private EmployeeService employeeService;

    @GetMapping("/ls")
    public List<EmployeeDTO> getAllEmployee() {
        return employeeService.getAllEmp();
    }

    @GetMapping("/get-by-id")
    public String getNameById(@RequestParam int id){
        return employeeService.getNameByID(id);
    }

    @PostMapping("/test_post")
    public boolean test_post(@RequestBody EmployeeDTO emp){
        System.out.println("Post Success");
        System.out.printf("%s %s", emp.getEmployeeName(), emp.getEmployeePhone());
        return true;
    }
}
