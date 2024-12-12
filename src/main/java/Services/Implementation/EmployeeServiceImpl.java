package Services.Implementation;

import Entities.Employee;
import Repos.EmployeeRepo;
import Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }
}
