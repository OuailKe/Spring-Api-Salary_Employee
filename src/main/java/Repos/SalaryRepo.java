package Repos;

import Entities.Employee;
import Entities.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepo extends JpaRepository<Salary, Integer> {

}
