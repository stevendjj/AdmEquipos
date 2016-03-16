/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author docente
 */
public class DbConnectionFactory {
   private static transient Connection conexion; 
   private static String usuario="root";
   private static String password="";
   private static String url="jdbc:mysql://localhost:3306/datosequipos";
   private static String driver="com.mysql.jdbc.Driver";
   
   
   
   public static void connect() throws ClassNotFoundException, SQLException{
       Class.forName(driver);
       conexion=DriverManager.getConnection(url, usuario, password);
   }
   public static Connection getConnection(){
      return conexion;
   }
   
}
