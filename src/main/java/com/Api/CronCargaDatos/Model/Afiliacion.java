package com.Api.CronCargaDatos.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "afiliacion")
public class Afiliacion {

    @Id
    @Column(name = "id" )
    private Long id;


    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "activo", nullable = false)
    private Boolean activo;


    @Column(name = "razon_social_id" )
    private Long razon_social_id;

    @Column(name = "sucursal_id" )
    private Long sucursal_id;

    @OneToMany(mappedBy = "afiliacion", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Transaccion_visa> transaccion_visa;




/*
    @ManyToOne
    @JoinColumn(name = "razon_social_id",insertable = false,updatable = false)
    private Razon_Social razonSocial;
 */


    @Override
    public String toString() {
        return "Afiliacion{" +
                "id=" + id +
                ", numero=" + numero +
                ", activo=" + activo +
                ", razon_social_id=" + razon_social_id +
                ", sucursal_id=" + sucursal_id +
                '}';
    }
}
