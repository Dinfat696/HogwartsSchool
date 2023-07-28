package ru.hogwarts.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//public class StudentServiceTest {
//    private StudentService studentService;
//
//    @BeforeEach
//    void setUp() {
//        studentService = new StudentService();
//    }
//
//    @Test
//    void createStudentTest() {
//        Student actual = studentService.crateStudent(new Student(null, "Ron", 18));
//        assertEquals("Ron", actual.getName());
//        assertNotNull(actual.getId());
//        assertEquals(18, actual.getAge());
//    }
//
//    @Test
//    void findStudentTest() {
//        studentService.crateStudent(new Student(null, "Alex", 20));
//        studentService.crateStudent(new Student(null, "Misha", 24));
//        Student foundStudent = studentService.findStudent(2L);
//        assertEquals(2, foundStudent.getId());
//
//    }
//
//    @Test
//    void editStudentTest() {
//        Student createdStudent = studentService.crateStudent(new Student(null, "Oleg", 22));
//        Student updatedStudent = studentService.editStudent(new Student(createdStudent.getId(), "Misha", 35));
//        assertNotNull(updatedStudent);
//        assertEquals("Misha", updatedStudent.getName());
//        assertEquals(1, studentService.getAll().size());
//
//    }
//
//    @Test
//    void deleteStudentTest() {
//        studentService.crateStudent(new Student(null, "Dashs", 40));
//        studentService.deleteStudent(1L);
//        assertEquals(0, studentService.getAll().size());
//    }
//
//    @Test
//    void getAllStudents() {
//        studentService.crateStudent(new Student(null, "Ivan", 17));
//        studentService.crateStudent(new Student(null, "Pasha", 18));
//        assertEquals(2, studentService.getAll().size());
//    }
//
//    @Test
//    void getStudentsByAge() {
//        studentService.crateStudent(new Student(null, "Dima", 19));
//        studentService.crateStudent(new Student(null, "Vova", 19));
//        studentService.crateStudent(new Student(null, "Ksusha", 21));
//        Collection<Student> getStudentsByAge = studentService.getStudentByAge(19);
//        assertEquals(2, getStudentsByAge.size());
//    }
//}