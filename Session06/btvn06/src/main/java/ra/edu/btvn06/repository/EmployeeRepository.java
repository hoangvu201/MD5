package ra.edu.btvn06.repository;

import org.springframework.stereotype.Repository;
import ra.edu.btvn06.data.Data;
import ra.edu.btvn06.model.Employee;

import java.util.List;

@Repository
public class EmployeeRepository {
    public List<Employee> fillAll() {
        return Data.getEmployees();
    }

    public void save(Employee employee) {
        Data.addEmployee(employee);
    }
}
