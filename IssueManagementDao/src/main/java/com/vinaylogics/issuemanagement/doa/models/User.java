package com.vinaylogics.issuemanagement.doa.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class User extends BaseModel {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String name) {
        super(id, createdAt, updatedAt);
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "User{" +
                "base_model='"+super.toString()+'\''+
                "name='" + name + '\'' +
                '}';
    }
}
