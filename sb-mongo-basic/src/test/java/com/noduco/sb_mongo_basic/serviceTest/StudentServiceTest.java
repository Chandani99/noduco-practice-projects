package com.noduco.sb_mongo_basic.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.noduco.sb_mongo_basic.model.Student;
import com.noduco.sb_mongo_basic.reposatory.StudentRepo;
import com.noduco.sb_mongo_basic.service.StudentService;

public class StudentServiceTest {

	private StudentService studentService;
	
	@Mock
	private StudentRepo studentRepo;
	 Optional<Student> mockStudent ;
	 Integer studentId = 1;
	
	 @BeforeEach
	   public void setUp() {
		 Student mockStudent = new Student();
		  mockStudent = new Student(1,"Abc","B.Tech", "MMMUT");
	    }
	 
	@Test
	public void getStudentByIdTest() {
		
		 // Arrange
//       Integer studentId = 1;
//       Student mockStudent = new Student(studentId, "Abc","B.Tech", "MMMUT");
       when(studentRepo.findById(studentId)).thenReturn(mockStudent);

        // Act
        Student result = studentService.getStudentById(studentId);

        // Assert
        assertNotNull(result);
        assertEquals(studentId, result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals("B.tech", result.getCourse());
        verify(studentRepo, Mockito.times(1)).findById(studentId);

	}
	
	@Test
    void addStudentTest() {
    	
		Student newStudent = new Student(2, "xyz","B.Tech", "MMMUT");
		when(studentRepo.save(newStudent)).thenReturn(mockStudent.get());
		
		Student result = studentService.addStudent(newStudent);
        Student mockStudentObj = mockStudent.get();
        
    	assertNotNull(result);
    	assertEquals(mockStudentObj.getId(), result.getId());
    	assertEquals(mockStudentObj.getName(), result.getName());
    	assertEquals(mockStudentObj.getCourse(), result.getCourse());
    	assertEquals(mockStudentObj.getClgName(), result.getClgName());
    	verify(studentRepo, Mockito.times(1)).save(newStudent);
    	
    	
    }
	
	@Test
	void getListOfUsers() {
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
}
