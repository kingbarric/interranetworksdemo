/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interra.demo.InterraDemoApp.servicefacade;

import com.interra.demo.InterraDemoApp.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author mac
 */

 
public interface EmployeeFacadeService {
   // public ResponseEntity findByEmail(String email) throws ResourceNotFoundException;
     public ResponseEntity findByEmail(String email);
     public ResponseEntity findByFirstName(String fn);
      public ResponseEntity findByPhoneNumber(Double phone) ;
       public ResponseEntity findByAllbyCountry(String country);
}
