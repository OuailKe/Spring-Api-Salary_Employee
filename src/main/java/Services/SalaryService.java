package Services;

import Entities.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> getAllSalaries();
    Salary getSalaryById(int id);
    Salary saveSalary(Salary salary);
    void deleteSalary(int id);
}
