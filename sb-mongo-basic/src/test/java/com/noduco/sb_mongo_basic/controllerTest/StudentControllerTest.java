package com.noduco.sb_mongo_basic.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.noduco.sb_mongo_basic.controller.StudentController;
import com.noduco.sb_mongo_basic.model.Student;
import com.noduco.sb_mongo_basic.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest{

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    Student mockStudent ;
	Integer studentId = 1;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
        mockStudent = new Student(1,"Abc","B.Tech", "MMMUT");
    }
   
    
    public void getUserByIdTest() throws Exception {
    	 when(studentService.getStudentById(studentId)).thenReturn(mockStudent);
    	// Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/student//get-student", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(studentId))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.course").value("B.Tech"))
                .andExpect(jsonPath("$.clgName").value("MMMUT"));;

        Mockito.verify(studentService, Mockito.times(1)).getStudentById(studentId);
    }

}