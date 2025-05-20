package com.exceed.employeeAssetM.exception;

public class DepartmentNotFoundException  extends RuntimeException{
    public DepartmentNotFoundException(String message){
        super(message);
    }
}
