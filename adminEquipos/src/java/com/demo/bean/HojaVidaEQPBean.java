/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.bean;

import com.demo.impl.DAOHojaVidaEQPImpl;
import com.demo.model.DAOHojaVidaEQP;
import com.demo.model.HojaVidaEQP;
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
public class HojaVidaEQPBean {
   private HojaVidaEQP hojavida= new HojaVidaEQP();
   private List<HojaVidaEQP> lista= new ArrayList<>();

    public HojaVidaEQP getHojavida() {
        return hojavida;
    }

    public void setHojavida(HojaVidaEQP hojavida) {
        this.hojavida = hojavida;
    }

    public List<HojaVidaEQP> getLista() {
        return lista;
    }

    public void setLista(List<HojaVidaEQP> lista) {
        this.lista = lista;
    }
   
   private DAOHojaVidaEQP<HojaVidaEQP> dao = new DAOHojaVidaEQPImpl();
   
   public void guardarHojaVida(){
      dao.guardar(hojavida);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"AVISO","HOJA DE VIDA AGREGADO CON EXITO!"));
      lista=dao.listar();
    }
    
    public void listar(){
        lista=dao.listar();
    }
   
    
}
