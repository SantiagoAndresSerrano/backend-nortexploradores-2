/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexp.com.app.service;

import nexp.com.app.model.Paquete;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Santi & Dani
 */
public interface PaqueteService {
        
    public void guardar(Paquete paquete);
    public void eliminar(int id);
    public Optional<Paquete> encontrar(int id);
    public List<Paquete> listar();
}