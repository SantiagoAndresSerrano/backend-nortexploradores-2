/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service.imp;

import com.example.demo.dao.DepartamentoDAO;
import com.example.demo.model.Departamento;
import com.example.demo.service.DepartamentoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Santi & Dani
 */
@Service
public class DepartamentoServiceImp implements DepartamentoService {

    @Autowired
    DepartamentoDAO dDao;

    @Override
    @Transactional(readOnly = true)
    public Optional<Departamento> encontrar(int id) {
        return dDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> listar() {
        return dDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Departamento dpto) {
        dDao.save(dpto);
    }

}
