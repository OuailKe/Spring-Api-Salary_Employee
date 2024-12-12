package Repos;

import Entities.Employee;
import Entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaryRepo extends JpaRepository<Salary, Integer> {
List<Salary> findByEmployee(Optional<Employee> employee);
}
