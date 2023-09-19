package com.Api.CronCargaDatos.Controller;

import com.Api.CronCargaDatos.Exception.ResourceNotFoundException;
import com.Api.CronCargaDatos.Model.Employee;
import com.Api.CronCargaDatos.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }


    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }



    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee no exist's with id"+id));

        return ResponseEntity.ok(employee);

    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with"+id));

        updateEmployee.setNombre_employee(employeDetails.getNombre_employee());
        /*
        updateEmployee.setFirstname(employeDetails.getFirstname());
        updateEmployee.setLastname(employeDetails.getLastname());
        updateEmployee.setEmailid(employeDetails.getEmailid());


         */
        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus>deleteEmployee(@PathVariable long id){

        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
