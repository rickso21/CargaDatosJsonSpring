package com.Api.CronCargaDatos.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id

    @Column(name = "id_employee")
    private long id_employee;

    @Column(name = "nombre_employee")
    private String nombre_employee;

}
