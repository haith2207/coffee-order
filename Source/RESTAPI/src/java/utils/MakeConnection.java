/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huy Trinh
 */
public class MakeConnection {

    public static Connection makeConnection() {
        Connection result = null;
        try {

            ResourceBundle rb = ResourceBundle.getBundle("utils/config");
            String driver = rb.getString("driver");
            String url = rb.getString("url");
            String username = rb.getString("uname");
            String password = rb.getString("pwd");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            result = con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MakeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

}
