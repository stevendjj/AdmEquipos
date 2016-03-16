/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.bean;

import com.demo.impl.DaoEquipoImpl;
import com.demo.model.Equipo;
import com.demo.model.DaoEquipo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 
 */
@ManagedBean(name = "equipoManaged")
@ViewScoped
public class EquipoManagedBean {

    private Equipo equipo=new Equipo();
    private List<Equipo> equipos=new ArrayList<>();
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    private DaoEquipo<Equipo> dao=new DaoEquipoImpl();
    public void guardarEquipo(){
      dao.guardar(equipo);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"AVISO","EQUIPO REGISTRADO CON EXITO!"));
      equipos=dao.listar();
    }
    
    public void listar(){
        equipos=dao.listar();
    }
    
}
