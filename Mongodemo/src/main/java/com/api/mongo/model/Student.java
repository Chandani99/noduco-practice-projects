package com.api.mongo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "students")
@RequiredArgsConstructor
@Getter
@Setter
public class Student {


    @Id
    private String id;
    private String name;
    private String email;

    private List<Course> courses = new ArrayList<>();


    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
