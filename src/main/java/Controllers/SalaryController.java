package Controllers;

import Entities.Salary;
import Services.Implementation.SalaryServiceImpl;
import Services.SalaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    private SalaryService salaryService;

    @GetMapping
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @GetMapping("/{Fid}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable("Fid") int Fid) {
        return salaryService.getSalaryById(Fid)
                .map(salary -> ResponseEntity.ok().body(salary))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Salary createSalary(@RequestBody Salary salary) {
        return salaryService.saveSalary(salary);
    }

    @PutMapping("/{Fid}")
    public ResponseEntity<Salary> updateSalary(@PathVariable("Fid") int Fid, @RequestBody Salary salary) {
        if(salaryService.getSalaryById(Fid).isPresent()) {
            salary.setFId(Fid);
            return ResponseEntity.ok().body(salaryService.saveSalary(salary));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{Fid}")
    public ResponseEntity<?> deleteSalary(@PathVariable("Fid") int Fid) {
        if(salaryService.getSalaryById(Fid).isPresent()) {
            salaryService.deleteSalary(Fid);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
