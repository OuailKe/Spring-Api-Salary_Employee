package Services;

import Entities.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryService {
    List<Salary> getAllSalaries();
    Optional<Salary> getSalaryById(int id);
    Salary saveSalary(Salary salary);
    void deleteSalary(int id);
}
