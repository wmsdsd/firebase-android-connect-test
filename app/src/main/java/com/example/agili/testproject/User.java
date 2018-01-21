package com.example.agili.testproject;

/**
 * Created by agili on 2017-12-24.
 */

public class User {

    public String User;
    public Long age;
    public String name;

    public User(){}

    public User(Long age, String name){
        this.age = age;
        this.name = name;
    }

    public Long getAge(){
        return this.age;
    }
    public void setAge(Long age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

}
