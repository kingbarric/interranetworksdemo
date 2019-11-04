/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interra.demo.InterraDemoApp.util;

import com.interra.demo.InterraDemoApp.model.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; 
 

/**
 *
 * @author mac
 */

 
public class ExcelReader {

//    @Value("${upload.path}")
//   private static String path;
    // private static final String FILE_NAME = "/opt/files/employee_record.xlsx";
    public static List<Employee> employeeModel;

    public static  List<Employee> loadEmployeeData() {

        try {

            FileInputStream excelFile = new FileInputStream(new File(StaticHelpers.FILE_PATH));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            //Skip first row of header
            iterator.next();
            employeeModel = new ArrayList<>();
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();

                Iterator<Cell> cellIterator = currentRow.iterator();

                //  cellIterator.next();
                 Employee emp = new Employee();
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        //  System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {

                    }

                    /**
                     * Assumptions: The excel file is formated to a specific
                     * format that is known by the program , hence no need to
                     * test for different data types with switch or if, rather
                     * column index with well known data is used
                     */
                   
                    switch (currentCell.getColumnIndex()) {
                        case 0:
                            emp.setId(currentCell.getNumericCellValue());
                            break;
                        case 1:
                            emp.setFirstName(currentCell.getStringCellValue());
                            break;

                        case 2:
                            emp.setMiddleName(currentCell.getStringCellValue());
                            break;
                        case 3:
                            emp.setLastName(currentCell.getStringCellValue());
                            break;
                        case 4:
                            emp.setEmailAddress(currentCell.getStringCellValue());
                            break;
                        case 5:
                            emp.setPhoneNumber(currentCell.getNumericCellValue());
                            break;
                        case 6:
                            emp.setDateOfBirth(currentCell.getDateCellValue());
                            break;
                        case 7:
                            emp.setCountry(currentCell.getStringCellValue());
                            break;
                        case 8:
                            emp.setAddress(currentCell.getStringCellValue());
                            break;

                    }
                    
                }
                employeeModel.add(emp);
                

            }
            
            return employeeModel;
        } catch (FileNotFoundException  e) {
        } catch (IOException e) {
        }

        return null;
    }

}
