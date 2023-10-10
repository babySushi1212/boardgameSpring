package webapp;

import java.util.Arrays;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import webapp.dto.EmployeeDTO;
import webapp.pojo.Employee;
import webapp.repository.EmployeeRepository;


@SpringBootApplication
public class TestApiApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
//        SpringApplication.exit(SpringApplication.run(TestApiApplication.class, args));
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(employeeRepository.findAllDTO());
//        System.out.println(employeeRepository.findJoin());
//        System.out.println(employeeRepository.findEmployeesAndRoles());
//
//        Employee employee = new Employee();
//        employee.setEmployeeNo(11);
//        employee.setEmployeeName("我又行啦");
//        employee.setEmployeePhone("1234567890");
//        employee.setEmployeeAddress("123 Main St");
//        employee.setEmployeeEmail("john.doe@example.com");
//        employee.setEmployeePassword("password");
//        employee.setRoleNo(1);
//        employee.setEmployeeStatus(true);
//        employeeRepository.save(employee);
//
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setEmployeeName("dto-name");
//        employeeDTO.setEmployeePassword("dto-password");
//        employeeDTO.setEmployeeEmail("dto@gmail.com");
//        Employee mappedEmployee = modelMapper.map(employeeDTO
//            , Employee.class);
//        mappedEmployee.setRoleNo(1);
//        System.out.println(mappedEmployee);
//        employeeRepository.save(mappedEmployee);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> { // lambda expression

//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }

        };
    }
}
