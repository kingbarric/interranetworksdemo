/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interra.demo.InterraDemoApp.resource;

import com.interra.demo.InterraDemoApp.exceptions.ResourceNotFoundException;
import com.interra.demo.InterraDemoApp.servicefacade.EmployeeFacadeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mac
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

    @Autowired
    private EmployeeFacadeService empService;

    @ApiOperation(value = "find Customer by email", notes = "find employee record by email address of the employee ")

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully called")
        ,
			@ApiResponse(code = 500, message = "error occured")
        ,
			@ApiResponse(code = -1, message = "The resource you were trying to reach is not found")})
    @GetMapping(path = "/findbyemail/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findByEmail(@PathVariable("email") String email) throws ResourceNotFoundException {
        System.out.println(email);
        return empService.findByEmail(email);
    }

    @ApiOperation(value = "find Customer by phonenumber", notes = "find customer record by phone number of the customers ")

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully called")
        ,
			@ApiResponse(code = 500, message = "error occured")
        ,
			@ApiResponse(code = -1, message = "The resource you were trying to reach is not found")})
    @GetMapping(path = "/findbyphonenumber/{phone}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findByPhonenumber(@PathVariable("phone") Double phone) throws ResourceNotFoundException {

        return empService.findByPhoneNumber(phone);
    }

    @ApiOperation(value = "find Customer by email", notes = "find customer record by fistname address of the customers ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully called")
        ,
			@ApiResponse(code = 500, message = "error occured")
        ,
			@ApiResponse(code = -1, message = "The resource you were trying to reach is not found")})
    @GetMapping(path = "/findbyfirstname/{firstname}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findByFirstname(@PathVariable("firstname") String firstname) throws ResourceNotFoundException {

        return empService.findByFirstName(firstname);
    }

    @ApiOperation(value = "find all customer by country", notes = "find customer record by country of the customers ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully called")
        ,
			@ApiResponse(code = 500, message = "error occured")
        ,
			@ApiResponse(code = -1, message = "The resource you were trying to reach is not found")})
    @GetMapping(path = "/findallcustomersbycountry/{country}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findAllCustomersByCountry(@PathVariable("country") String country) throws ResourceNotFoundException {

        return empService.findByAllbyCountry(country);
    }

    @GetMapping(path = "/hello/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String test(@PathVariable("name") String email) throws ResourceNotFoundException {

        return "hello " + email;
    }

}
