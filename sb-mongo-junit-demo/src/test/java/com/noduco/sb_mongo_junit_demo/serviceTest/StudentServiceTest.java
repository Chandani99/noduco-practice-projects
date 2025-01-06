package com.noduco.sb_mongo_junit_demo.serviceTest;


import com.noduco.sb_mongo_junit_demo.model.Student;
import com.noduco.sb_mongo_junit_demo.repo.StudentRepo;
import com.noduco.sb_mongo_junit_demo.service.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.spy;



@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;
    Student mockStudent ;
    Integer studentId = 1;

    @BeforeEach
    public void setUp() {

        mockStudent = new Student(1,"Abc","B.Tech", "MMMUT");
    }

    @Test
    public void getStudentByIdTest() {

        // Arrange

        when(studentRepo.findById(studentId)).thenReturn(Optional.of(mockStudent));

        // Act
        Student result = studentService.getStudentById(studentId);


        // Assert
        assertNotNull(result);
        Assertions.assertEquals(studentId, result.getId());
        Assertions.assertEquals("Abc", result.getName());
        Assertions.assertEquals("B.Tech", result.getCourse());
        verify(studentRepo, Mockito.times(1)).findById(studentId);

    }


    @Test
    void addStudentTest() {

        Student newStudent = new Student(1, "Abc","B.Tech", "MMMUT");
        when(studentRepo.save(newStudent)).thenReturn(mockStudent);

        Student result = studentService.addStudent(newStudent);


        assertNotNull(result);
        assertEquals(mockStudent.getId(), result.getId());
        assertEquals(mockStudent.getName(), result.getName());
        assertEquals(mockStudent.getCourse(), result.getCourse());
        assertEquals(mockStudent.getClgName(), result.getClgName());
        verify(studentRepo, Mockito.times(1)).save(newStudent);


    }

    @Test
    void getListOfUsersTest() {
        List<Student> mockStudents= Arrays.asList(
                new Student(1, "John Doe", "B.tech","MMMUT"),
                new Student(2, "Jane Doe", "B.Tech", "BTEUP")
        );

        when(studentRepo.findAll()).thenReturn(mockStudents);

        List<Student> resultStudents = studentService.getAllStudent();

        assertNotNull(resultStudents);
        assertEquals(mockStudents.get(0).getId(), resultStudents.get(0).getId());
        verify(studentRepo, Mockito.times(1)).findAll();
    }

    @Test
    void getListOfStudentsByNameTest() {
        List<Student> mockStudents= Arrays.asList(
                new Student(1, "John Doe", "B.tech","MMMUT"),
                new Student(2, "Jane Doe", "B.Tech", "BTEUP")
        );
        String name = "John Doe";
        when(studentRepo.findStudentsByName(name)).thenReturn(mockStudents);

        List<Student> resultStudents = studentService.getStudentsByNamePublic(name);

        assertNotNull(resultStudents);
        assertEquals(mockStudents.get(0).getId(), resultStudents.get(0).getId());
        verify(studentRepo, Mockito.times(1)).findAll();
    }

}
