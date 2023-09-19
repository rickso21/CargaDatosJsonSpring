package com.Api.CronCargaDatos.Controller;


import com.Api.CronCargaDatos.Exception.ResourceNotFoundException;
import com.Api.CronCargaDatos.Model.Sucursal;
import com.Api.CronCargaDatos.Repository.SucursalCargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Sucursal")
public class SucursalController {

    @Autowired
    SucursalCargaRepository sucursalCargaRepository;

    @GetMapping("/Consulta_Sucursal")
    public List<Sucursal> getAllSucursal() {
        return sucursalCargaRepository.findAll();
    }


    @PostMapping("/Insertar_Sucursal")
    public Sucursal createSucursal(@RequestBody Sucursal sucursal) {

        return sucursalCargaRepository.save(sucursal);
    }


    @PutMapping("/Actualiza_Sucursal/{id}")
    ResponseEntity<Sucursal> ActualizarDatos(@PathVariable long id, @RequestBody Sucursal sucursal) {
        Sucursal ActualizarDatos = sucursalCargaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal not exist whith id:" + id));

        ActualizarDatos.setNombre(sucursal.getNombre());
        ActualizarDatos.setEcom(sucursal.getEcom());
        ActualizarDatos.setDireccion(sucursal.getDireccion());
        ActualizarDatos.setColonia(sucursal.getColonia());
        ActualizarDatos.setCp(sucursal.getCp());
        ActualizarDatos.setTelefono(sucursal.getTelefono());
        ActualizarDatos.setLongitud(sucursal.getLongitud());
        ActualizarDatos.setLatitud(sucursal.getLatitud());
        ActualizarDatos.setActivo(sucursal.getActivo());
        ActualizarDatos.setComercio_id(sucursal.getComercio_id());

        sucursalCargaRepository.save(ActualizarDatos);
        return ResponseEntity.ok(ActualizarDatos);
    }

    @DeleteMapping("/Eliminar_Sucursal/{id}")
    public ResponseEntity<HttpStatus> deleteSucursal(@PathVariable long id) {

        Sucursal sucursal = sucursalCargaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Sucursal: " + id));

        sucursalCargaRepository.delete(sucursal);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

