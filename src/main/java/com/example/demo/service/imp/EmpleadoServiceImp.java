/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.imp;

import com.example.demo.dao.EmpleadoDAO;
import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GenesisDanielaVJ
 */
@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    EmpleadoDAO eDAO;
    
    
    @Override
    @Transactional
    public void guardar(Empleado empleado) {
        eDAO.save(empleado);
    }

    @Override
    @Transactional(readOnly = true )
    public Optional<Empleado> encontrar(int id) {
        return eDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listar() {
        return eDAO.findAll();
    }

    @Override
    public void eliminar(int id) {
        eDAO.deleteById(id);
    }
    
}
