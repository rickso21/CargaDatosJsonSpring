package com.Api.CronCargaDatos.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "oferta")
public class Oferta {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 63, nullable = false)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "descripcion", length = 2047)
    private String descripcion;

    @Column(name = "vigencia_inicio", nullable = true)
    private LocalDate vigenciaInicio;

    @Column(name = "vigencia_fin")
    private LocalDate vigenciaFin;

    @Column(name = "terminos_condiciones", length = 8191)
    private String terminosCondiciones;

    @Column(name = "comision")
    private Float comision;

    @Column(name = "compra_minima")
    private Float compraMinima;

    @Column(name = "porcentaje_reembolso")
    private Float porcentajeReembolso;

    @Column(name = "monto_reembolso")
    private Float montoReembolso;

    @Column(name = "tope_evento")
    private Float topeEvento;

    @Column(name = "tope_mensual")
    private Float topeMensual;

    @Column(name = "tope_total")
    private Float topeTotal;

    @Column(name = "eventos_mensuales")
    private Integer eventosMensuales;

    @Column(name = "eventos_totales")
    private Integer eventosTotales;

    @Column(name = "dias_semana")
    private Integer diasSemana;

    @Column(name = "dias_mes")
    private Long diasMes;

    @Column(name = "plazos_validos")
    private Integer plazosValidos;

    @Column(name = "plazos_bonificados")
    private Long plazosBonificados;

    @Column(name = "meses_ultima_compra")
    private Integer mesesUltimaCompra;

    @Column(name = "reiniciar_eventos")
    private Integer reiniciarEventos;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "afiliacion_wl", nullable = false)
    private Boolean afiliacionWL;

    @Column(name = "producto_wl", nullable = false)
    private Boolean productoWL;

    @Column(name = "segmento_wl", nullable = false)
    private Boolean segmentoWL;

    @Column(name = "req_act", nullable = false)
    private Boolean reqAct;

    @Column(name = "comercio_id")
    private Long comercio_id;

    @Column(name = "programa_id")
    private Long programa_id;


    @ManyToOne
    @JoinColumn(name = "comercio_id",insertable = false,updatable = false)
    private Comercio comercio;



    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", vigenciaInicio=" + vigenciaInicio +
                ", vigenciaFin=" + vigenciaFin +
                ", terminosCondiciones='" + terminosCondiciones + '\'' +
                ", comision=" + comision +
                ", compraMinima=" + compraMinima +
                ", porcentajeReembolso=" + porcentajeReembolso +
                ", montoReembolso=" + montoReembolso +
                ", topeEvento=" + topeEvento +
                ", topeMensual=" + topeMensual +
                ", topeTotal=" + topeTotal +
                ", eventosMensuales=" + eventosMensuales +
                ", eventosTotales=" + eventosTotales +
                ", diasSemana=" + diasSemana +
                ", diasMes=" + diasMes +
                ", plazosValidos=" + plazosValidos +
                ", plazosBonificados=" + plazosBonificados +
                ", mesesUltimaCompra=" + mesesUltimaCompra +
                ", reiniciarEventos=" + reiniciarEventos +
                ", status=" + status +
                ", afiliacionWL=" + afiliacionWL +
                ", productoWL=" + productoWL +
                ", segmentoWL=" + segmentoWL +
                ", reqAct=" + reqAct +

                '}';
    }
}
