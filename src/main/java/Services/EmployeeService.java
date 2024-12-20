package Services;

import Entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
    Optional<Employee> getEmployeeByUsername(String username);
}
