/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import java.util.List;

/**
 *
 * @author Carlos Alberto
 * @param <HojaVidaEQP>
 */
public interface DAOHojaVidaEQP<HojaVidaEQP> {
    void guardar(HojaVidaEQP hojavida);
    List<HojaVidaEQP> listar();
}
