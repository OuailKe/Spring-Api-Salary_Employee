package Services.Implementation;

import Entities.Salary;
import Repos.SalaryRepo;
import Services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalaryRepo salaryRepo;

    @Override
    public List<Salary> getAllSalaries() {
        return salaryRepo.findAll();
    }

    @Override
    public Salary getSalaryById(int id) {
        return salaryRepo.findById(id).orElse(null);
    }

    @Override
    public Salary saveSalary(Salary salary) {
        return salaryRepo.save(salary);
    }

    @Override
    public void deleteSalary(int id) {
        salaryRepo.deleteById(id);
    }
}
