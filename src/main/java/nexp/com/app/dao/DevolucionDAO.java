/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexp.com.app.dao;

import nexp.com.app.model.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Santi & GenesisDanielaVJ
 */
public interface DevolucionDAO extends JpaRepository<Devolucion, Integer> {

}
