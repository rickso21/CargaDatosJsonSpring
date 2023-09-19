package com.Api.CronCargaDatos.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "transaccion_visa")
public class Transaccion_visa {

    @Column(name = "id" )
    private Long id;

    @Column(name = "buc", nullable = false )
    private Long buc;

    @Column(name = "fecha", nullable = false )
    private LocalDate fecha;


    @Column(name = "tipo")
    private Integer tipo;


    @Column(name = "monto", nullable = false )
    private Float monto;

    @Column(name = "ultimos_digitos")
    private Integer ultimosDigitos;


    @Column(name = "mcc" )
    private Integer mcc;

    @Column(name = "plazos")
    private Integer plazos;

    @Column(name = "codigo_autorizacion")
    private Long codigoAutorizacion;



    @Column(name = "weekday", nullable = false )
    private Byte weekday;

    @Column(name = "status", nullable = false )
    private Integer status;
    @Id
    @Column(name = "afiliacion_id" )
    private Long afiliacion_id;

    @Column(name = "banco_id")
    private Long banco_id;

    @Column(name = "tarjetahabiente_id")
    private Long tarjetahabiente_id;


    @Column(name = "tarjeta_id" )
    private Long tarjeta_id;


    @Column(name = "th" )
    private Long th;

    @Column(name = "t" )
    private Long t;

    @Column(name = "af" )
    private Long af;

    @Column(name = "carga_id" )
    private Long carga_id;

    @ManyToOne
    @JoinColumn(name = "afiliacion_id",insertable = false,updatable = false)
    private Afiliacion afiliacion;


    @Override
    public String toString() {
        return "Transaccion_visa{" +
                "id=" + id +
                ", buc=" + buc +
                ", fecha=" + fecha +
                ", tipo=" + tipo +
                ", monto=" + monto +
                ", ultimosDigitos=" + ultimosDigitos +
                ", mcc=" + mcc +
                ", plazos=" + plazos +
                ", codigoAutorizacion=" + codigoAutorizacion +
                ", weekday=" + weekday +
                ", status=" + status +
                ", afiliacion_id=" + afiliacion_id +
                ", banco_id=" + banco_id +
                ", tarjetahabiente_id=" + tarjetahabiente_id +
                ", tarjeta_id=" + tarjeta_id +
                ", th=" + th +
                ", t=" + t +
                ", af=" + af +
                ", carga_id=" + carga_id +
                '}';
    }
}
