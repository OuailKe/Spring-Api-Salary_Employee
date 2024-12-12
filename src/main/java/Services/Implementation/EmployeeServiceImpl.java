package Services.Implementation;

import Entities.Employee;
import Repos.EmployeeRepo;
import Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Employee> getAllEmployees() {return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        String UsernamePassword = generateUsernamePassword(employee.getFirstName(),employee.getLastName());
        employee.setUsername(UsernamePassword);
        employee.setPassword(bCryptPasswordEncoder.encode(UsernamePassword));
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }

    private static String generateUsernamePassword(String firstName, String lastName) {
        return firstName.substring(0, 3).toLowerCase() +
                lastName.substring(0, 3).toLowerCase() +
                (int)(Math.random() * 100);
    }
}
