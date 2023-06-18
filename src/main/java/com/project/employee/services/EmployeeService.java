package com.project.employee.services;


import com.project.employee.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel createEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> getAllEmployees();

    Boolean deleteEmployee(Long id);

    EmployeeModel getEmployeeById(Long id);

    EmployeeModel updateEmployee(Long id, EmployeeModel employee);
}
