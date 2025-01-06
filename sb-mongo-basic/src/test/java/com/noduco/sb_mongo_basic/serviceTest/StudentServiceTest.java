package com.noduco.sb_mongo_basic.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.noduco.sb_mongo_basic.model.Student;
import com.noduco.sb_mongo_basic.reposatory.StudentRepo;
import com.noduco.sb_mongo_basic.service.StudentService;


@RunWith(PowerMockRunner.class)
@PrepareForTest(StudentService.class)
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
        assertEquals(studentId, result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals("B.tech", result.getCourse());
        verify(studentRepo, Mockito.times(1)).findById(studentId);

	}
	
	@Test
    void addStudentTest() {
    	
		Student newStudent = new Student(2, "xyz","B.Tech", "MMMUT");
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
	
//	invoking private mthod using reflection 
	
	
//	@Test
//	void getUsersByName() {
//		
//		List<Student> mockStudents= Arrays.asList(
//                new Student(1, "John Doe", "B.tech","MMMUT"),
//                new Student(2, "Jane Doe", "B.Tech", "BTEUP")
//        );
//		
//		when(studentRepo.findStudentsByName("John Doe")).thenReturn(mockStudents);
//		
//		 Method method;
//		try {
//			method = StudentService.class.getDeclaredMethod("getAllStudentByName", String.class);
//			method.setAccessible(true);
//			 String name = "John Doe";
//				
//			    try {
//					List<Student> resultStudent  = (List<Student>) method.invoke(studentService, name);
//					assertEquals(mockStudents.get(0).getId(), resultStudent.get(0).getId());
//				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
//		 
//		 
//		
//	}
	
	
	 @Test
	  public void mockPrivateMethod_getUsersByNameTest() throws Exception {
		 List<Student> mockStudents= Arrays.asList(
               new Student(1, "John Doe", "B.tech","MMMUT"),
               new Student(2, "Jane Doe", "B.Tech", "BTEUP")
       );

		String name = "John Doe";
		
	    
	    PowerMockito.doReturn(mockStudents).when(studentRepo, "findStudentsByName", name);
	    
	    StudentService mockService = PowerMockito.spy(new StudentService());
	    List<Student> resultStudent = Whitebox.invokeMethod(mockService, "getAllStudentByName", name);
	    
	    assertEquals(mockStudents.get(0).getId(), resultStudent.get(0).getId());
	    PowerMockito.verifyPrivate(mockService, times(1)).invoke("getAllStudentByName");
	  }
}
