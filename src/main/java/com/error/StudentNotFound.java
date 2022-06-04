package com.error;

public class StudentNotFound extends EntityNotFoundException{

    public StudentNotFound(){
        super("Student Does Not Exist!");
    }
}
