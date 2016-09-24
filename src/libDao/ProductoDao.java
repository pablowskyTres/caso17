/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.Producto;
import lib.Sesion;

/**
 *
 * @author alan
 */
public class ProductoDao {
    
    private Producto producto;

    public ProductoDao(Producto producto) 
    {
        this.producto= producto;
    }
    
    public ResultSet getProductoAll()
    {
    String sql = String.format("select codigo,descripcion,"
                                + "fabricante,componente,"
                                + "gramaje,tipo_producto_id from producto ");
   ResultSet rs= Sesion.getInstance().sqlSelect(sql);
   return rs;
    
    }
   /* public boolean InsertProducto(Producto pro) throws SQLException
    {
    
    String ql =String.format("insert into producto(codigo,descripcion,"
                                + "fabricante,componente,"
                                + "gramaje,tipo_producto_id)values( '%s', '%s', '%s', '%s', %d, %d, '%s')");
   
    return Sesion.getInstance().sqlEjecutar(sql);
    }   */
}
