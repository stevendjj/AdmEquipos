/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.impl;

import com.demo.db.DbConnectionFactory;
import com.demo.model.DAOHojaVidaEQP;
import com.demo.model.HojaVidaEQP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Alberto
 */
public class DAOHojaVidaEQPImpl implements DAOHojaVidaEQP<HojaVidaEQP> {
    
    public DAOHojaVidaEQPImpl() {
        try {
            DbConnectionFactory.connect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOHojaVidaEQPImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar(HojaVidaEQP hojavida) {
         Connection connection = DbConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("Insert into hojavidaeqp(codigo,memoria,vel_memoria,procesador,vel_procesador,discoD,capa_discoD,sistemaOperativo,version_so,paqueteOffice,version_Office,antivirus,otros) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1,hojavida.getCodigo());
            pst.setString(2, hojavida.getMemoria());
            pst.setString(3, hojavida.getVel_memoria());
            pst.setString(4, hojavida.getProcesador());
            pst.setString(5, hojavida.getVel_procesador());
            pst.setString(6, hojavida.getDiscoD());
            pst.setString(7, hojavida.getCap_discoD());
            pst.setString(8, hojavida.getSistemaOperativo());
            pst.setString(9, hojavida.getVersion_so());
            pst.setString(10, hojavida.getPaqueteOffice());
            pst.setString(11, hojavida.getVersion_Office());
            pst.setString(12, hojavida.getAntivitus());
            pst.setString(13, hojavida.getOtros());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<HojaVidaEQP> listar() {
        List<HojaVidaEQP> lista=new ArrayList<>();
        try {
            Connection connection = DbConnectionFactory.getConnection();
            PreparedStatement pst = connection.prepareStatement("Select codigo,memoria,vel_memoria,procesador,vel_procesador,discoD,cap_discoD,sistemaOperativo,version_so,paqueteOffice,version_Office,antivirus,otros  from hojavidaeqp"); 
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HojaVidaEQP hojaVidaEQP=new HojaVidaEQP();
                hojaVidaEQP.setCodigo(rs.getInt("codigo"));
                hojaVidaEQP.setMemoria(rs.getString("memoria"));
                hojaVidaEQP.setVel_memoria(rs.getString("vel_memoria"));
                hojaVidaEQP.setProcesador(rs.getString("procesador"));
                hojaVidaEQP.setVel_procesador(rs.getString("vel_procesador"));
                hojaVidaEQP.setDiscoD(rs.getString("discoD"));
                hojaVidaEQP.setCap_discoD(rs.getString("cap_dicsoD"));
                hojaVidaEQP.setSistemaOperativo(rs.getString("sistemaOperativo"));
                hojaVidaEQP.setVersion_so(rs.getString("version_so"));
                hojaVidaEQP.setPaqueteOffice(rs.getString("paqueteOffice"));
                hojaVidaEQP.setVersion_Office(rs.getString("version_Office"));
                hojaVidaEQP.setAntivitus(rs.getString("antivirus"));
                hojaVidaEQP.setOtros(rs.getString("otros"));
                lista.add(hojaVidaEQP);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
    }
    
}
