package Repos;

import Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String username);
}
