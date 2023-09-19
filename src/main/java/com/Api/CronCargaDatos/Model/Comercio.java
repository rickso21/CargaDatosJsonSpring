package com.Api.CronCargaDatos.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "comercio")
public class Comercio {

    @Id
    @Basic(optional = false)

    @Column(name = "id")
    private Long id_comercio;

    @Column(name = "nombre", length = 63, nullable = false)
    private String nombre;

    @Column(name = "mcc", nullable = false)
    private Integer mcc;

    @Column(name = "consorcio", nullable = false)
    private Boolean consorcio;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @Column(name = "categoria_id")
    private Long categoria_id;


    @OneToMany(mappedBy = "comercio", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Sucursal>sucursal;

    @OneToMany(mappedBy = "comercio", cascade =
            CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Oferta>oferta;


    @OneToMany(mappedBy = "comercio", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Razon_Social>razonSocial;

    @Override
    public String toString() {
        return "Comercio{" +
                "id_comercio=" + id_comercio +
                ", nombre='" + nombre + '\'' +
                ", mcc=" + mcc +
                ", consorcio=" + consorcio +
                ", activo=" + activo +

                '}';
    }
}
