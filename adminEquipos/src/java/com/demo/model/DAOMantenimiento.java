/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import java.util.List;

/**
 *
 * @author 
 * @param <Mantenimiento>
 */
public interface DAOMantenimiento<Mantenimiento> {
    void guardar(Mantenimiento mantenimiento);
    List<Mantenimiento> listar();
}
