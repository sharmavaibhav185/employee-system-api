package com.project.employee.services;

import com.project.employee.entity.EmployeeEntity;
import com.project.employee.model.EmployeeModel;
import com.project.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl  implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeModel createEmployee(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employeeModel,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employeeModel;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream()
                .map(employeeEntity -> new EmployeeModel(
                        employeeEntity.getId(),
                        employeeEntity.getFirstName(),
                        employeeEntity.getLastName(),
                        employeeEntity.getEmailId())).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteEmployee(Long id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return true;
    }

    @Override
    public EmployeeModel getEmployeeById(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        EmployeeModel employeeModel= new EmployeeModel();
        BeanUtils.copyProperties(employee,employeeModel);
        return employeeModel;
    }

    @Override
    public EmployeeModel updateEmployee(Long id, EmployeeModel employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        employeeRepository.save(employeeEntity);
        return employee;
    }
}
