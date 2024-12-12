package Services.Implementation;

import Entities.Employee;
import Entities.Salary;
import Repos.EmployeeRepo;
import Repos.SalaryRepo;
import Services.SalaryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SalaryServiceImpl implements SalaryService {

    SalaryRepo salaryRepo;
    EmployeeRepo employeeRepo;

    public SalaryServiceImpl(SalaryRepo salaryRepo) {
        this.salaryRepo = salaryRepo;
    }

    @Override
    public List<Salary> getAllSalaries() {
        return salaryRepo.findAll();
    }

    @Override
    public Optional<Salary> getSalaryById(int id) {
        return salaryRepo.findById(id);
    }

    @Override
    public Salary saveSalary(Salary salary) {
        return salaryRepo.save(salary);
    }

    @Override
    public void deleteSalary(int id) {
        salaryRepo.deleteById(id);
    }

    @Override
    public List<Salary> getSalaryByUser(int id) {
        try {
            Optional<Employee> employee = employeeRepo.findById(id);
            if (employee.isPresent()) {
                List<Salary> salaries = salaryRepo.findByEmployee(employee);
                if (!salaries.isEmpty()) {
                    return salaries; // Assuming you want the first salary
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Or throw an exception if preferred
    }
}
