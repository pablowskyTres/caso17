/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablowsky
 */
public class Sesion {
    
    private static Sesion bd;
    private static String myDriver = "oracle.jdbc.driver.OracleDriver";
    private static String myUrl = "jdbc:oracle:thin:@localhost:1521:XE";
    private Statement stmt;
    String user = "Proyecto";
    String clave = "123456";
    private Connection cnn;
    
    private Sesion() {
        try {
            Class.forName(myDriver);;
            cnn = DriverManager.getConnection(myUrl, user, clave);
            stmt = cnn.createStatement();
        } catch (ClassNotFoundException ex) {
            new Exception("Class Not Found" + ex.getMessage());
        } catch (SQLException ex) {
            new Exception("Sql Conexion " + ex.getMessage());
        }
    }
    
    public static Sesion getInstance() {
        if (bd == null) {
            bd = new Sesion();
        }
        return bd;
    }
    
    private void commit() throws SQLException{
        stmt.executeUpdate("commit");
    }

    public boolean sqlEjecutar(String sql) throws SQLException {
        int rs = 0;
        try {
            rs = stmt.executeUpdate(sql);
//            cnn.commit();
            boolean resp = (rs > 0) ? true : false;
            commit();
//            cnn.close();
            return resp;

        } catch (SQLException ex) {
            new Exception("Sql Ejecutar " + ex.getMessage());
            return false;
        }
    }

    public ResultSet sqlSelect(String sql) {
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            new Exception("Sql Select " + ex.getMessage());
        }
        return null;
    }
    
}
