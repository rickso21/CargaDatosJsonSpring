package com.Api.CronCargaDatos.Repository;

import com.Api.CronCargaDatos.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
