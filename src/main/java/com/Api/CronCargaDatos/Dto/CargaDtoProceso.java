package com.Api.CronCargaDatos.Dto;

import com.Api.CronCargaDatos.Model.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CargaDtoProceso {

    private Comercio comercio;



    private Sucursal sucursales;


    private List<Sucursal>sucursal;

    private List<Comercio>comercios;

    private List<Afiliacion>afiliaciones;

    private List<Oferta>ofertas;

    private List<Razon_Social>razon_Social;


    private Oferta oferta;


    private Razon_Social razonSocial;

    private Afiliacion afiliacion;

    private Long id_comercio_carga;

    private String nombre_comercio;

    private Integer mcc_comercio;


    private Boolean consorcio_comercio;


    private Boolean activo_comercio;


    private Long categoria_id_comercio;







    //comienza dto de sucursal

    private Long id_sucursal_carga;

    private String nombre_sucursal;


    private Boolean ecom_sucursal;

    private String direccion_sucursal;


    private String colonia_sucursal;


    private Long cp_sucursal;

    private String telefono_sucursal;


    private Float longitud_sucursal;

    private Float latitud_sucursal;


    private Boolean activo_sucursal;


    private Long comercio_id_sucursal;

        //oferta

    private Long id_oferta;


    private String nombre_oferta;


    private Integer tipo_oferta;


    private String descripcion_oferta;


    private LocalDate vigenciaInicio_oferta;


    private LocalDate vigenciaFin_oferta;


    private String terminosCondiciones_oferta;


    private Float comision_oferta;


    private Float compraMinima_oferta;


    private Float porcentajeReembolso_oferta;


    private Float montoReembolso_oferta;


    private Float topeEvento_oferta;

    private Float topeMensual_oferta;

    private Float topeTotal_oferta;

    private Integer eventosMensuales_oferta;

    private Integer eventosTotales_oferta;

    private Integer diasSemana_oferta;

    private Long diasMes_oferta;

    private Integer plazosValidos_oferta;

    private Long plazosBonificados_oferta;

    private Integer mesesUltimaCompra_oferta;

    private Integer reiniciarEventos_oferta;

    private Integer status_oferta;

    private Boolean afiliacionWL_oferta;

    private Boolean productoWL_oferta;

    private Boolean segmentoWL_oferta;

    private Boolean reqAct_oferta;

    private Long comercio_id_oferta;

    private Long programa_id_oferta;



    //razon social

    private Long id_razon_social;

    private String nombre_razon_social;


    private String rfc_razon_social;


    private String direccion_razon_social;


    private String colonia_razon_social;


    private Long cp_razon_social;



    private Boolean activo_razon_social;


    private Long comercio_id_razon_social;


    //afiliacion

    private Long id_afiliacion;

    private Long numero_afiliacion;

    private Boolean activo_afiliacion;

    private Long razon_social_id_afiliacion;


    private Long sucursal_id_afiliacion;



}
