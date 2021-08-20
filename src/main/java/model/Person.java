package model;

//JavaBean

import java.io.Serializable;

//1. implements serializable
//2. No args constructor
//3. private members w/ getters and setters
public class Person implements Serializable {
    private String firstName;
    private String lastName;

    public Person(){

    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
