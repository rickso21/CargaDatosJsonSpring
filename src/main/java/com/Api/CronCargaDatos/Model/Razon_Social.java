package com.Api.CronCargaDatos.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "razon_social")
public class Razon_Social {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 127, nullable = false)
    private String nombre;

    @Column(name = "rfc", length = 13, nullable = false)
    private String rfc;

    @Column(name = "direccion", length = 127, nullable = false)
    private String direccion;

    @Column(name = "colonia", length = 127, nullable = false)
    private String colonia;

    @Column(name = "cp")
    private Long cp;


    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "comercio_id")
    private Long comercio_id;

    @ManyToOne
    @JoinColumn(name = "comercio_id",insertable = false,updatable = false)
    private Comercio comercio;




    /*
    @OneToMany(mappedBy = "razon_social", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Afiliacion> afiliacion;


     */
    @Override
    public String toString() {
        return "Razon_Social{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rfc='" + rfc + '\'' +
                ", direccion='" + direccion + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cp=" + cp +
                ", activo=" + activo +

                '}';
    }
}
