package ra.edu.btvn06.data;

import lombok.Getter;
import ra.edu.btvn06.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    @Getter
    public static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Nguyễn Văn A", "a@gmail.com", "Developer"),
            new Employee("Trần Thị B", "b@gmail.com", "Tester"),
            new Employee("Lê Văn C", "c@gmail.com", "Manager")
    ));

    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
