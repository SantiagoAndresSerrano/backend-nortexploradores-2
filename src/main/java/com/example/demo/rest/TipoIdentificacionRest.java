/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest;

import com.example.demo.model.TipoIdentificacion;
import com.example.demo.service.TipoIdentificacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Santi & Dani
 */
@RestController
@RequestMapping("/tipoIdentificacion")
@CrossOrigin(origins = "http://localhost:4200/")
public class TipoIdentificacionRest {

    @Autowired
    TipoIdentificacionService tiSer;

    @GetMapping
    public ResponseEntity<List<TipoIdentificacion>> getTipoIdentificacion() {
        return ResponseEntity.ok(tiSer.listar());
    }
    
   
}