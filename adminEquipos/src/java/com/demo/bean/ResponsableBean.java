/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;

import com.demo.impl.DAOResponsableImpl;
import com.demo.model.DAOResponsable;
import com.demo.model.Responsable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Carlos Alberto
 */
@ManagedBean
@ViewScoped
public class ResponsableBean {
   private Responsable responsable= new Responsable();
   private List<Responsable> lista = new ArrayList<>();

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public List<Responsable> getLista() {
        return lista;
    }

    public void setLista(List<Responsable> lista) {
        this.lista = lista;
    }
   
    private DAOResponsable<Responsable> dao= new DAOResponsableImpl();
    
    public void guardarResponsable(){
      dao.guardar(responsable);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"AVISO","RESPONSABLE AGREGADO CON EXITO!"));
      lista=dao.listar();
    }
    
    public void listar(){
        lista=dao.listar();
    }
    
}
