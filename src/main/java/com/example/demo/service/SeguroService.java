/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Seguro;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Santi & Dani
 */
public interface SeguroService {
    
    public void guardar(Seguro seguro);
    public void eliminar(int id);
    public Optional<Seguro> encontrar(int id);
    public List<Seguro> listar();
            
}
