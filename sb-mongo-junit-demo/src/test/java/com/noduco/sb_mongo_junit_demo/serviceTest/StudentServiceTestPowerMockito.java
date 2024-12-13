package com.noduco.sb_mongo_junit_demo.serviceTest;

import com.noduco.sb_mongo_junit_demo.model.Student;
import com.noduco.sb_mongo_junit_demo.repo.StudentRepo;
import com.noduco.sb_mongo_junit_demo.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames =  "com.noduco.sb_mongo_junit_demo.*")
public class StudentServiceTestPowerMockito {

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
    public void mockPrivateMethodTest() throws Exception {

        StudentService mock = PowerMockito.spy(new StudentService());
        PowerMockito.doReturn("New Message from Mock!").when(mock,"privateMessage");

        String privateMessage = Whitebox.invokeMethod(mock, "privateMessage");

        Assertions.assertEquals(privateMessage, "New Message from Mock!");
    }

//    @Test
//    public void mockPrivateMethodTest2New() throws Exception {
//
//        StudentService mock = spy(new StudentService());
//        when(mock,"privateMessage").thenRturn("New Message from Mock!");
//        Object returnValue = mock.privateMethodCaller();
//
//        String privateMessage = Whitebox.invokeMethod(mock, "privateMessage");
//
//        Assertions.assertEquals(privateMessage, "New Message from Mock!");
//    }
}
