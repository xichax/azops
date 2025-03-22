package com.example.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "#{@environment.getProperty('app.collection-name')}")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
}
