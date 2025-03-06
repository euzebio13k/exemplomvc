/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author euzebio
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/exemplomvc?useSSL=false"; 
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String SENHA = "123";
    private static Connection con;        
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            if((con == null) || con.isClosed()){
                con = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
            
        }catch(ClassNotFoundException | SQLException e){
            con = null;
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }
}