/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest;

import com.example.demo.model.Pasajero;
import com.example.demo.model.Calificacion;
import com.example.demo.service.CalificacionService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GenesisDanielaVJ
 */
@RestController
@RequestMapping("/calificacion")
@CrossOrigin(origins = "http://localhost:4200/")
@Slf4j
public class CalificacionRest {

    @Autowired
    CalificacionService cser;

    @GetMapping
    public ResponseEntity<List<Calificacion>> getCalificacion() {
        return ResponseEntity.ok(cser.listar());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Calificacion> eliminarCalificacion(@PathVariable int id) {

        Calificacion c = cser.encontrar(id).orElse(null);

        cser.eliminar(id);

        return ResponseEntity.ok(c);
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> encontrarCalificacion(@PathVariable int id) {

        Calificacion c = cser.encontrar(id).orElse(null);

        if (c == null) {
            return new ResponseEntity<ObjectError>(new ObjectError("id","No existe el id"), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody @Valid Calificacion c, BindingResult br) {

        if (br.hasErrors()) {
            return new ResponseEntity<List<ObjectError>>(br.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        cser.guardar(c);
        return ResponseEntity.ok(c);
    }
    
    
}
