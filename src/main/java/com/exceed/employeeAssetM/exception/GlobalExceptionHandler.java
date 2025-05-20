package com.exceed.employeeAssetM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AssetNotFoundException.class)
    public ResponseEntity<Object> handleAssetNotFound(AssetNotFoundException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Object> handleDepatNotfound(DepartmentNotFoundException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> generalexception(Exception ex) {
        return buildErrorResponse("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Object> handleinvalidrequest(InvalidRequestException ex){
        return buildErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InvalidDepartmentandEmployeeException .class)
     public ResponseEntity<Object> handlesInvalidrelation(InvalidDepartmentandEmployeeException Ex){
       return buildErrorResponse(Ex.getMessage(),HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<Object> buildErrorResponse(String message,HttpStatus status){
        Map<String ,Object> error =new HashMap<>();
         error.put("timestamp", LocalDateTime.now());
         error.put("status", status.value());
         error.put("error", status.getReasonPhrase());
         error.put("message",message);
         return new ResponseEntity<>(error, status
       );
    }

}