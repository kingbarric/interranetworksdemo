/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interra.demo.InterraDemoApp.facadeimplementation;

import com.interra.demo.InterraDemoApp.model.Employee;
import com.interra.demo.InterraDemoApp.servicefacade.EmployeeFacadeService;
import com.interra.demo.InterraDemoApp.util.MessageResponses;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author mac
 */
@Service
public class EmployeeFacadeImpl implements EmployeeFacadeService{
    
     
    
    /**
     * 
     * @param email
     * @return ResponseEntity Containing customer with the specified Email
     */
    @Override
    public ResponseEntity findByEmail(String email) {
    
           
                 List<Employee> emps = Employee.loadAllEmployeeData(); 
                    List<Employee> employee = emps.stream().filter(filter -> filter.getEmailAddress().equalsIgnoreCase(email))
                    .collect(Collectors.toList());// convert list to stream and filter and return list
          
            if (employee.isEmpty()) {  
                return ResponseEntity.ok(MessageResponses.response(MessageResponses.CODE_ERROR, MessageResponses.MESSAGE_NOT_FOUND)); 
                
            } else {
                return ResponseEntity.ok(employee.get(0));                
            }         
    }
    
    /**
     * 
     * @param fn
     * @return ResponseEntity Containing Customer with the specified Fistname number
     */
    @Override
     public ResponseEntity findByFirstName(String fn) {
    
           
                 List<Employee> emps = Employee.loadAllEmployeeData(); 
                    List<Employee> employee = emps.stream().filter(filter -> filter.getFirstName().equalsIgnoreCase(fn))
                    .collect(Collectors.toList());// convert list to stream and filter and return list
          
            if (employee.isEmpty()) {  
                return ResponseEntity.ok(MessageResponses.response(MessageResponses.CODE_ERROR, MessageResponses.MESSAGE_NOT_FOUND)); 
                
            } else {
                return ResponseEntity.ok(employee.get(0));                
            }         
    }
     
     /**
      * 
      * @param phone
      * @return ResponseEntity Containing employee with the specified phone number
      */
    @Override
      public ResponseEntity findByPhoneNumber(Double phone) {
    
           
                 List<Employee> emps = Employee.loadAllEmployeeData(); 
                    List<Employee> employee = emps.stream().filter(filter -> filter.getPhoneNumber().equals(phone))
                    .collect(Collectors.toList());// convert list to stream and filter and return list
          
            if (employee.isEmpty()) {  
                return ResponseEntity.ok(MessageResponses.response(MessageResponses.CODE_ERROR, MessageResponses.MESSAGE_NOT_FOUND)); 
                
            } else {
                return ResponseEntity.ok(employee.get(0));                
            }         
    }
     
      /**
       * 
       * @param country
       * @return Return responseEntity with customer from same country
       */
    @Override
       public ResponseEntity findByAllbyCountry(String country) { 
                 List<Employee> emps = Employee.loadAllEmployeeData(); 
                    List<Employee> employee = emps.stream().filter(filter -> filter.getCountry().equalsIgnoreCase(country))
                    .collect(Collectors.toList());// convert list to stream and filter and return list
           
                return ResponseEntity.ok(employee);                
                     
    }
    
}
