package com.project.employee.controller;

import com.project.employee.model.EmployeeModel;
import com.project.employee.services.EmployeeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel){
        return employeeService.createEmployee(employeeModel);

    }

    @GetMapping("/employees")
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable  Long id ){
        Boolean deleted = employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeModel> getEmployeebyID(@PathVariable Long id){
        EmployeeModel employeeModel=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeModel);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id,@RequestBody EmployeeModel employee){
        employee = employeeService.updateEmployee(id,employee);
        return  ResponseEntity.ok(employee);
    }


}
