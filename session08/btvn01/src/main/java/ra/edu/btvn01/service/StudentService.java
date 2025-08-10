package ra.edu.btvn01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.btvn01.model.Student;
import ra.edu.btvn01.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(int id) {
        return studentRepository.findById(id);
    }

    public boolean saveStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public boolean updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }
}
