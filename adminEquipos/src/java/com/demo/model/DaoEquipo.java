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
 * @param <Equipo>
 */
public interface DaoEquipo<Equipo> {
    void guardar(Equipo equipo);
    void actualizar(Equipo equipo);
    List<Equipo> listar();
    void eliminar(Equipo equipo);
    
}
