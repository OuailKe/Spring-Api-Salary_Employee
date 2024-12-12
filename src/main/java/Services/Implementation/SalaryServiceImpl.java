package Services.Implementation;

import Entities.Salary;
import Repos.SalaryRepo;
import Services.SalaryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SalaryServiceImpl implements SalaryService {

    SalaryRepo salaryRepo;

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
}
