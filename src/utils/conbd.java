/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class conbd {
    private static final String user="root" ;
   private static final  String password="" ;
    private static final String url="jdbc:mysql://localhost:3306/huntkingdom" ; 
 public static Connection connect()
   {
       try {
  
           Class.forName("com.mysql.jdbc.Driver");
                   Connection conn=DriverManager.getConnection(url, user, password);
       
       return conn;
               } catch (ClassNotFoundException|SQLException e) {
            System.err.println("condb : "+e.getMessage());
       }
       return null ;
   }
   
}
