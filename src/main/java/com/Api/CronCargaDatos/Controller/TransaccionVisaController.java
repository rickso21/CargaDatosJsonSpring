package com.Api.CronCargaDatos.Controller;

import com.Api.CronCargaDatos.Exception.ResourceNotFoundException;
import com.Api.CronCargaDatos.Model.Transaccion_visa;
import com.Api.CronCargaDatos.Repository.TransaccionVisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Transaccion_visa")
public class TransaccionVisaController {

    @Autowired
    private TransaccionVisaRepository transaccionVisaRepository;

    @GetMapping("/consulta_TrVisa")
    public List<Transaccion_visa> getAllTransaccion_visa() {
        return transaccionVisaRepository.findAll();
    }


    @PostMapping("/Inserta_TrVisa")
    public Transaccion_visa createTransaccion_visa(@RequestBody Transaccion_visa transaccionVisa) {
        return transaccionVisaRepository.save(transaccionVisa);

    }

    @PutMapping("/Actualiza_TrVisa/{id}")
    public ResponseEntity<Transaccion_visa> ActualizarDatos(@PathVariable long id, @RequestBody Transaccion_visa transaccion_visa) {
        Transaccion_visa ActualizarDatos = transaccionVisaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaccion not exist whith id:" + id));

        //   transaccion_visa.setId(ActualizarDatos.getId());
        ActualizarDatos.setBuc(transaccion_visa.getBuc());
        ActualizarDatos.setFecha(transaccion_visa.getFecha());
        ActualizarDatos.setTipo(transaccion_visa.getTipo());
        ActualizarDatos.setMonto(transaccion_visa.getMonto());
        ActualizarDatos.setUltimosDigitos(transaccion_visa.getUltimosDigitos());
        ActualizarDatos.setMcc(transaccion_visa.getMcc());
        ActualizarDatos.setPlazos(transaccion_visa.getPlazos());
        ActualizarDatos.setCodigoAutorizacion(transaccion_visa.getCodigoAutorizacion());
        ActualizarDatos.setWeekday(transaccion_visa.getWeekday());
        ActualizarDatos.setStatus(transaccion_visa.getStatus());
        ActualizarDatos.setAfiliacion_id(transaccion_visa.getAfiliacion_id());
        //ActualizarDatos.setBanco_id(transaccion_visa.getBanco_id()); --> tiene restriccion desde la bd llamada cc_transaccion_visa
        ActualizarDatos.setTarjetahabiente_id(transaccion_visa.getTarjetahabiente_id());
        // ActualizarDatos.setTarjeta_id(transaccion_visa.getTarjeta_id());
        // ActualizarDatos.setTh(transaccion_visa.getTh());
        //   ActualizarDatos.setT(transaccion_visa.getT());
        //  ActualizarDatos.setAf(transaccion_visa.getAf());
        //    ActualizarDatos.setCarga_id(transaccion_visa.getCarga_id());

        transaccionVisaRepository.save(ActualizarDatos);
        return ResponseEntity.ok(ActualizarDatos);
    }
    @DeleteMapping("/Eliminar_TrVisa/{afiliacion_id}")
    public ResponseEntity<HttpStatus> deleteTransaccionVisa(@PathVariable long afiliacion_id) {


        Transaccion_visa transaccionVisa = transaccionVisaRepository.findById(afiliacion_id)
            .orElseThrow(() -> new ResourceNotFoundException("Not found transaccion: " + afiliacion_id));


        transaccionVisaRepository.delete(transaccionVisa);


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
