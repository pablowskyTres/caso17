/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author alan
 */
public class Producto {
    
    private int codigo;
    private String descripcion;
    private String fabricante;
    private String componente;
    private int gramaje;
    private int tipo_producto_id;

    public Producto() {
    }
    
    

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public void setGramaje(int gramaje) {
        this.gramaje = gramaje;
    }

    public void setTipo_producto_id(int tipo_producto_id) {
        this.tipo_producto_id = tipo_producto_id;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getComponente() {
        return componente;
    }

    public int getGramaje() {
        return gramaje;
    }

    public int getTipo_producto_id() {
        return tipo_producto_id;
    }
    
    
    
}
