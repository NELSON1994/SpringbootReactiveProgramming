package com.ewebflux.reactive.dao;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
@Data
public class User {
    @Id
    int id;
    private String name;
    private long salary;
    private boolean status=true;

    //Getters and setters

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", salary=" + salary +  ", user status="+ status+ "]";
    }
}
