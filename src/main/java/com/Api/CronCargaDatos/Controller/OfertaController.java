package com.Api.CronCargaDatos.Controller;

import com.Api.CronCargaDatos.Exception.ResourceNotFoundException;
import com.Api.CronCargaDatos.Model.Oferta;
import com.Api.CronCargaDatos.Repository.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Oferta")
public class OfertaController {

    @Autowired
    OfertaRepository ofertaCargaRepository;


    @GetMapping("/Consulta_Oferta")
    public List<Oferta> getAllOferta() {
        return ofertaCargaRepository.findAll();
    }


    @PostMapping("/Insertar_Oferta")
    public Oferta createOferta(@RequestBody Oferta ofertaCarga) {

        return ofertaCargaRepository.save(ofertaCarga);
    }


    @PutMapping("/Actualiza_Oferta/{id}")
    ResponseEntity<Oferta> ActualizarDatos(@PathVariable long id, @RequestBody Oferta ofertaCarga) {
        Oferta ActualizarDatos = ofertaCargaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oferta not exist whith id:" + id));

        ActualizarDatos.setNombre(ofertaCarga.getNombre());
        ActualizarDatos.setTipo(ofertaCarga.getTipo());
        ActualizarDatos.setDescripcion(ofertaCarga.getDescripcion());
        ActualizarDatos.setVigenciaInicio(ofertaCarga.getVigenciaInicio());
        ActualizarDatos.setVigenciaFin(ofertaCarga.getVigenciaFin());
        ActualizarDatos.setTerminosCondiciones(ofertaCarga.getTerminosCondiciones());
        ActualizarDatos.setComision(ofertaCarga.getComision());
        ActualizarDatos.setCompraMinima(ofertaCarga.getCompraMinima());
        ActualizarDatos.setPorcentajeReembolso(ofertaCarga.getPorcentajeReembolso());
        ActualizarDatos.setTopeEvento(ofertaCarga.getTopeEvento());
        ActualizarDatos.setTopeMensual(ofertaCarga.getTopeMensual());
        ActualizarDatos.setTopeTotal(ofertaCarga.getTopeTotal());
        ActualizarDatos.setEventosMensuales(ofertaCarga.getEventosMensuales());
        ActualizarDatos.setEventosTotales(ofertaCarga.getEventosTotales());
        ActualizarDatos.setDiasSemana(ofertaCarga.getDiasSemana());
        ActualizarDatos.setDiasMes(ofertaCarga.getDiasMes());
        ActualizarDatos.setPlazosValidos(ofertaCarga.getPlazosValidos());
        ActualizarDatos.setPlazosBonificados(ofertaCarga.getPlazosBonificados());
        ActualizarDatos.setMesesUltimaCompra(ofertaCarga.getMesesUltimaCompra());
        ActualizarDatos.setReiniciarEventos(ofertaCarga.getReiniciarEventos());
        ActualizarDatos.setStatus(ofertaCarga.getStatus());
        ActualizarDatos.setAfiliacionWL(ofertaCarga.getAfiliacionWL());
        ActualizarDatos.setProductoWL(ofertaCarga.getProductoWL());
        ActualizarDatos.setSegmentoWL(ofertaCarga.getSegmentoWL());
        ActualizarDatos.setReqAct(ofertaCarga.getReqAct());
        ActualizarDatos.setComercio_id(ofertaCarga.getComercio_id());
        ActualizarDatos.setPrograma_id(ofertaCarga.getPrograma_id());

        ofertaCargaRepository.save(ActualizarDatos);

        return ResponseEntity.ok(ActualizarDatos);


    }


    @DeleteMapping("/Eliminar_Oferta/{id}")
    public ResponseEntity<HttpStatus> deleteOferta(@PathVariable long id) {

        Oferta ofertaCarga = ofertaCargaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found oferta: " + id));

        ofertaCargaRepository.delete(ofertaCarga);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
