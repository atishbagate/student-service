package com.testOne.basicTesting;

import com.testOne.basicTesting.client.CourseClient;
import com.testOne.basicTesting.dto.CourseDTO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseClient courseClient;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student enrollStudent(Long studentId, Long courseId) {
        // 1. Validate the student exists
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        // 2. Call Course Service to validate the course exists
        CourseDTO course;
        try {
            course = courseClient.getCourseById(courseId);
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("Course not found with id: " + courseId);
        }

        // 3. Enroll the student
        student.setCourseId(course.getId());
        return studentRepository.save(student);
    }
}
