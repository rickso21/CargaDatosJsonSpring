package com.Api.CronCargaDatos.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @Column(name = "id")
    private Long id;


    @Column(name = "nombre", length = 63, nullable = false)
    private String nombre;

    @Column(name = "ecom", nullable = false)
    private Boolean ecom;

    @Column(name = "direccion", length = 127)
    private String direccion;

    @Column(name = "colonia", length = 127)
    private String colonia;

    @Column(name = "cp")
    private Long cp;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "longitud")
    private Float longitud;

    @Column(name = "latitud")
    private Float latitud;

    @Column(name = "activo", nullable = false)
    private Boolean activo;



    @Column(name = "comercio_id")
    private Long comercio_id;


    @ManyToOne
    @JoinColumn(name = "comercio_id",insertable = false,updatable = false)
    private Comercio comercio;



    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ecom=" + ecom +
                ", direccion='" + direccion + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cp=" + cp +
                ", telefono='" + telefono + '\'' +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                ", activo=" + activo +
                ", comercio_id=" + comercio_id +
                '}';
    }
}
