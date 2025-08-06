package ra.edu.btvn06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.btvn06.model.Employee;
import ra.edu.btvn06.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.fillAll();
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }
}
