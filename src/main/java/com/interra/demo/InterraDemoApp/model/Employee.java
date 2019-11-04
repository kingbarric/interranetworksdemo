/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interra.demo.InterraDemoApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interra.demo.InterraDemoApp.util.ExcelReader;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mac
 */
public class Employee {
    
    private Double id;
    
    private String firstName;
    
    private String middleName;
    
    private String lastName;
           
    private String emailAddress;
    
    private Double phoneNumber;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    
    private String country;
    
    private String address;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }
    
    
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = (int)(37 * hash + this.id);
        hash = 37 * hash + Objects.hashCode(this.emailAddress);
        hash = 37 * hash + Objects.hashCode(this.phoneNumber);
        return hash;
    }

     

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.emailAddress, other.emailAddress)) {
            return false;
        }
        return Objects.equals(this.phoneNumber, other.phoneNumber);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", country=" + country + ", address=" + address + '}';
    }
    
    
    public static List<Employee> loadAllEmployeeData(){
        
        return ExcelReader.loadEmployeeData();
    }
    
}
