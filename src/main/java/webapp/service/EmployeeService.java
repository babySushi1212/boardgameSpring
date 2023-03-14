package webapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.dto.EmployeeDTO;
import webapp.dto.OpenHourDTO;
import webapp.pojo.Employee;
import webapp.repository.EmployeeRepository;

@Service
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
}
