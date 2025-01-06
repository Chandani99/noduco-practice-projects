package com.noduco.sb_mongo_junit_demo.controllertest;

import com.noduco.sb_mongo_junit_demo.controller.StudentController;
import com.noduco.sb_mongo_junit_demo.model.Student;
import com.noduco.sb_mongo_junit_demo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

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


    @Test
    public void getUserByIdTest() throws Exception {
        when(studentService.getStudentById(studentId)).thenReturn(mockStudent);
        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/student/get-student/{studentId}", studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(studentId))
                .andExpect(jsonPath("$.name").value("Abc"))
                .andExpect(jsonPath("$.course").value("B.Tech"))
                .andExpect(jsonPath("$.clgName").value("MMMUT"));;

        Mockito.verify(studentService, Mockito.times(1)).getStudentById(studentId);
    }
}
