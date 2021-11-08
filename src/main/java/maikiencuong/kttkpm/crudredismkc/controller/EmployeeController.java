package maikiencuong.kttkpm.crudredismkc.controller;

import maikiencuong.kttkpm.crudredismkc.entity.Employee;
import maikiencuong.kttkpm.crudredismkc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        Employee emp = employeeRepository.findById(id);
        if (emp != null) {
            employeeRepository.delete(emp);
            return "employee id = " + id + " deleted";
        }
        return "delete failed";
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

}
