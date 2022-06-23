package com.example.firebase_auth;

public class Contact {
    public String name;
    public String age;
    public Contact(){

    }
    public Contact(String name,String age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }

    public String getAge(){
        return  age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
