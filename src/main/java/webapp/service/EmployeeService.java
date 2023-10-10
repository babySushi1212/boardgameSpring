package webapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.dto.EmpUpdateDTO;
import webapp.dto.EmployeeDTO;
import webapp.dto.OpenHourDTO;
import webapp.pojo.Employee;
import webapp.repository.EmployeeRepository;
import webapp.repository.OpenHourRepository;

@Service // 1.託管
public class EmployeeService {

    @Autowired // DI
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String getNameByID(int id){
        System.out.println(employeeRepository.getReferenceById(id).getEmployeeName());
        return employeeRepository.getReferenceById(id).getEmployeeName();
    }

    public List<EmployeeDTO> getAllEmp(){
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.LOOSE);
        return employeeRepository.findAll()
            .stream()
            .map(this::EntityToDTO)
            .collect(Collectors.toList());
    }

    private EmployeeDTO EntityToDTO(Employee employee) {
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.LOOSE);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }

    public Integer updateEmployee(EmpUpdateDTO dto) {
        return employeeRepository.updateEmployeePartial(
                dto.getEmployeeNo(), // 1
                dto.getEmployeeName(), // chris
                dto.getEmployeePhone() // 09888
        );
    }
}
