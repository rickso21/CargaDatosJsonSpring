package com.Api.CronCargaDatos.Controller_Final;
import com.Api.CronCargaDatos.Dto.CargaDtoProceso;
import com.Api.CronCargaDatos.Exception.ResourceNotFoundException;
import com.Api.CronCargaDatos.Model.*;
import com.Api.CronCargaDatos.Repository.*;
import com.Api.CronCargaDatos.RespuestasJSON.RespuestaJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/Apps")
public class Principal_Controller {
    @Autowired
    private TransaccionVisaRepository transaccionVisaRepository;
    @Autowired
    AfiliacionRepository afiliacionRepository;
    @Autowired
    RazonSocialRepository razonSocialRepository;
    @Autowired
    OfertaRepository ofertaRepository;
    @Autowired
    SucursalCargaRepository sucursalCargaRepository;
    @Autowired
    ComercioRepository comercioRepository;

    @DeleteMapping("/Eliminar/{afiliacion_id}/{id}")
    public ResponseEntity<RespuestaJSON> Eliminar_Dts(@PathVariable long afiliacion_id,@PathVariable long id) {
        RespuestaJSON respuestaJSON = new RespuestaJSON();
        RespuestaJSON ErrorJSON = new RespuestaJSON();
        RespuestaJSON Eliminado5tablas = new RespuestaJSON();
        RespuestaJSON Eliminado4tablas = new RespuestaJSON();
        RespuestaJSON Eliminado3tablas = new RespuestaJSON();
        RespuestaJSON Eliminado2tablas = new RespuestaJSON();
        RespuestaJSON Eliminado1tablas = new RespuestaJSON();
        RespuestaJSON Eliminacionvinculada  = new RespuestaJSON();
        Optional<Comercio> comercioOptional = comercioRepository.findById(id);
        Optional<Afiliacion> afiliacionOptional = afiliacionRepository.findById(id);
        Optional<Sucursal> sucursalOptional = sucursalCargaRepository.findById(id);

        ErrorJSON.setStatus("Failed");
        ErrorJSON.setMensaje("No se elimino ningun dato revise el VSI o el numero de comercio sea existente");

        RespuestaJSON ErrorJSONComercio = new RespuestaJSON();
        RespuestaJSON ErrorJSONSucursal = new RespuestaJSON();
        RespuestaJSON ErrorJSONOferta = new RespuestaJSON();
        RespuestaJSON ErrorJSONRazonSocial = new RespuestaJSON();
        RespuestaJSON ErrorJSONAfiliacion = new RespuestaJSON();


        respuestaJSON.setStatus("Success");
        respuestaJSON.setMensaje("Se ha eliminado correctamente los datos.");

        Eliminacionvinculada.setStatus("Succes");
        Eliminacionvinculada.setMensaje("Afiliacion de Dato relacionado eliminado correctamente");


        Eliminado5tablas.setStatus("Success");
        Eliminado5tablas.setMensaje("Se ha eliminado afiliacion, razon social oferta, sucursal y comercio");


        Eliminado4tablas.setStatus("Success");
        Eliminado4tablas.setMensaje("Se ha eliminado afiliacion, razon social oferta y  sucursal");


        Eliminado3tablas.setStatus("Success");
        Eliminado3tablas.setMensaje("Se han eliminado correctamente");


        Eliminado2tablas.setStatus("Success");
        Eliminado2tablas.setMensaje("Se ha eliminado afiliacion y razon social");


        Eliminado1tablas.setStatus("Success");
        Eliminado1tablas.setMensaje("Se ha eliminado comercio");

        ErrorJSONComercio.setStatus("Failed");
        ErrorJSONComercio.setMensaje("No se encontraron datos revise que existan las tablas");



        ErrorJSONComercio.setStatus("Failed");

        ErrorJSONSucursal.setMensaje("No se pudo encontrar el id sucursal");
        ErrorJSONSucursal.setStatus("Failed");

        ErrorJSONOferta.setMensaje("No se pudo encontrar el id de oferta");
        ErrorJSONOferta.setStatus("Failed");

        ErrorJSONRazonSocial.setMensaje("No se pudo encontrar el id de razon social");
        ErrorJSONRazonSocial.setStatus("Failed");

        ErrorJSONAfiliacion.setMensaje("No se pudo encontrar el id de afiliacion");
        ErrorJSONAfiliacion.setStatus("Failed");

        try {

            if (afiliacionOptional.isPresent()) {
                Afiliacion afiliacion = afiliacionOptional.get();
                transaccionVisaRepository.deleteAll(afiliacion.getTransaccion_visa());
                afiliacionRepository.delete(afiliacion);
            }

            Afiliacion afiliacion = afiliacionRepository.findById(afiliacion_id).orElseThrow(() -> new ResourceNotFoundException("Not found Oferta: " + id));
            afiliacionRepository.delete(afiliacion);


            if (comercioOptional.isPresent()) {
                Comercio comercio = comercioOptional.get();
                razonSocialRepository.deleteAll(comercio.getRazonSocial());
            }

            if (comercioOptional.isPresent()) {
                Comercio comercio = comercioOptional.get();
                ofertaRepository.deleteAll(comercio.getOferta());
            }

            if (comercioOptional.isPresent()) {
                Comercio comercio = comercioOptional.get();
                sucursalCargaRepository.deleteAll(comercio.getSucursal());
                comercioRepository.delete(comercio);
            }


            return ResponseEntity.status(HttpStatus.OK).body(respuestaJSON);


        } catch (Exception e) {

            try {
                Afiliacion afiliacion = afiliacionRepository.findById(afiliacion_id).orElseThrow(() -> new ResourceNotFoundException("Not found Oferta: " + id));
                afiliacionRepository.deleteById(afiliacion_id);
                return ResponseEntity.status(HttpStatus.OK).body(Eliminacionvinculada);

            } catch (Exception qq) {



                try {
                    Afiliacion afiliacion = afiliacionRepository.findById(afiliacion_id).orElseThrow(() -> new ResourceNotFoundException("Not found Oferta: " + id));
                    afiliacionRepository.deleteById(afiliacion_id);

                    if (comercioOptional.isPresent()) {
                        Comercio comercio = comercioOptional.get();
                        razonSocialRepository.deleteAll(comercio.getRazonSocial());
                    }
                    if (comercioOptional.isPresent()) {
                        Comercio comercio = comercioOptional.get();
                        ofertaRepository.deleteAll(comercio.getOferta());
                    }

                    if (comercioOptional.isPresent()) {
                        Comercio comercio = comercioOptional.get();
                        sucursalCargaRepository.deleteAll(comercio.getSucursal());
                        comercioRepository.delete(comercio);
                    }

                    return ResponseEntity.status(HttpStatus.OK).body(Eliminado4tablas);


                } catch (Exception i) {

                    try {
                        if (comercioOptional.isPresent()) {
                            Comercio comercio = comercioOptional.get();
                            razonSocialRepository.deleteAll(comercio.getRazonSocial());
                        }
                        if (comercioOptional.isPresent()) {
                            Comercio comercio = comercioOptional.get();
                            ofertaRepository.deleteAll(comercio.getOferta());
                        }

                        if (comercioOptional.isPresent()) {
                            Comercio comercio = comercioOptional.get();
                            sucursalCargaRepository.deleteAll(comercio.getSucursal());
                            comercioRepository.delete(comercio);
                        }

                        return ResponseEntity.status(HttpStatus.OK).body(Eliminado3tablas);


                    } catch (Exception l) {

                        try {
                            if (comercioOptional.isPresent()) {
                                Comercio comercio = comercioOptional.get();
                                ofertaRepository.deleteAll(comercio.getOferta());
                            }
                            if (comercioOptional.isPresent()) {
                                Comercio comercio = comercioOptional.get();
                                sucursalCargaRepository.deleteAll(comercio.getSucursal());
                                comercioRepository.delete(comercio);
                            }
                            return ResponseEntity.status(HttpStatus.OK).body(Eliminado2tablas);
                        } catch (Exception a) {
                            try {
                                if (comercioOptional.isPresent()) {
                                    Comercio comercio = comercioOptional.get();
                                    sucursalCargaRepository.deleteAll(comercio.getSucursal());
                                    comercioRepository.delete(comercio);
                                }
                                return ResponseEntity.status(HttpStatus.OK).body(Eliminado1tablas);

                            } catch (Exception s) {
                                return ResponseEntity.status(HttpStatus.OK).body(Eliminacionvinculada);

                            }
                        }
                    }

                }

            }


        }
    }
    @PostMapping("/Inserta_Carga")
    public ResponseEntity<RespuestaJSON>crear1(@RequestBody CargaDtoProceso cargaDtoProceso)  {

        RespuestaJSON respuestaJSON = new RespuestaJSON();
        RespuestaJSON ErrorJSONComercio = new RespuestaJSON();

        RespuestaJSON respuesta4tablas = new RespuestaJSON();

        RespuestaJSON respuesta3tablas = new RespuestaJSON();

        RespuestaJSON respuesta2tablas = new RespuestaJSON();

        RespuestaJSON respuesta1tabla = new RespuestaJSON();


        List<Comercio> comercio = cargaDtoProceso.getComercios();
        List<Oferta> oferta = cargaDtoProceso.getOfertas();
        List<Razon_Social> razonSocial = cargaDtoProceso.getRazon_Social();
        //Afiliacion afiliacion = cargaDtoProceso.getAfiliacion();
        List<Afiliacion> afiliacion = cargaDtoProceso.getAfiliaciones();
        List<Sucursal> sucursal=cargaDtoProceso.getSucursal();

        respuestaJSON.setStatus("Success");
        respuestaJSON.setMensaje("Operacion realizada correctamente.");
        ErrorJSONComercio.setStatus("Failed");
        ErrorJSONComercio.setMensaje("No se pudo insertar los datos de ninguna tabla revise la informacion cargada");

        respuesta4tablas.setStatus("Success");
        respuesta4tablas.setMensaje("Solo se insertaron datos en comercio, sucursal, oferta y razon social");

        respuesta3tablas.setStatus("Success");
        respuesta3tablas.setMensaje("Solo se insertaron datos en comercio, sucursal y oferta");

        respuesta2tablas.setStatus("Success");
        respuesta2tablas.setMensaje("Solo se insertaron datos en comercio y sucursal");

        respuesta1tabla.setStatus("Success");
        respuesta1tabla.setMensaje("Solo se insertaron datos en comercio");


        try{
            comercioRepository.saveAll(comercio);
            sucursalCargaRepository.saveAll(sucursal);
            ofertaRepository.saveAll(oferta);
            razonSocialRepository.saveAll(razonSocial);
            afiliacionRepository.saveAll(afiliacion);

            return ResponseEntity.status(HttpStatus.OK).body(respuestaJSON);

        }catch (Exception e){

            try{
                comercioRepository.saveAll(comercio);
                sucursalCargaRepository.saveAll(sucursal);
                ofertaRepository.saveAll(oferta);
                razonSocialRepository.saveAll(razonSocial);
                return ResponseEntity.status(HttpStatus.OK).body(respuesta4tablas);

            }catch (Exception l){
                try{
                    comercioRepository.saveAll(comercio);
                    sucursalCargaRepository.saveAll(sucursal);
                    ofertaRepository.saveAll(oferta);
                    return ResponseEntity.status(HttpStatus.OK).body(respuesta3tablas);

                }catch (Exception s){

                    try{
                        comercioRepository.saveAll(comercio);
                        sucursalCargaRepository.saveAll(sucursal);
                        return ResponseEntity.status(HttpStatus.OK).body(respuesta2tablas);

                    }catch (Exception q){

                        try{
                            comercioRepository.saveAll(comercio);
                            return ResponseEntity.status(HttpStatus.OK).body(respuesta1tabla);

                        }catch (Exception a){

                            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorJSONComercio);
                        }

                    }

                }


            }
        }
        }

}