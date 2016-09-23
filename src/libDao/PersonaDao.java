/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import lib.Persona;
import lib.Sesion;

/**
 *
 * @author Pablowsky
 */
public class PersonaDao {
    private Persona persona;

    public PersonaDao(Persona persona) {
        this.persona = persona;
    }
    
    public ResultSet getPersonaById(int id){
        String sql = String.format("SELECT nombre1 FROM persona WHERE id = %d", id);
        ResultSet rs = Sesion.getInstance().sqlSelect(sql);
        return rs;
    }
    
    public ResultSet getPersonaAll(){
        String sql = String.format("SELECT id, nombre1 FROM persona");
        ResultSet rs = Sesion.getInstance().sqlSelect(sql);
        return rs;
    }
    
    public ResultSet getPersonaByRut(int rut){
        String sql = String.format("SELECT id, nombre1 FROM persona WHERE rut = %d", rut);
        ResultSet rs = Sesion.getInstance().sqlSelect(sql);
        return rs;
    }
    
    public boolean existePersona(int rut) throws SQLException{
        ResultSet rs = getPersonaByRut(rut);
        if (rs.next()) {
            return true;
        }
        return false;
    }
    
    public Boolean insertPersona(Persona p) throws SQLException{
        if (existePersona(p.getRut())) {
            return false;
        }
        String sql = String.format("INSERT INTO persona (id, rut, dv, nombre1, nombre2, apellido_paterno, apellido_materno, telefono, celular, correo, estado)"
                + "VALUES (persona_seq.nextval, %d, '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', 1)", p.getRut(), p.getDv(), p.getNombre1(), p.getNombre2(), p.getApellidoPaterno(), p.getApellidoMaterno(), p.getTelefono(), p.getCelular(), p.getCorreo(), 1);
        return Sesion.getInstance().sqlEjecutar(sql);
    }
    
    public Boolean deletePersona(int id) throws SQLException{
        String sql = String.format("DELETE FROM persona WHERE id = %d", id);
        return Sesion.getInstance().sqlEjecutar(sql);
    }
    
    public Boolean deletePersonaByRut(int rut) throws SQLException{
        System.out.println(rut);
        ResultSet rs = getPersonaByRut(rut);
        if(rs.next()) {
            System.out.println(rs.getString("id"));
            return deletePersona(Integer.parseInt(rs.getString("id")));
        }
        return false;
    }
    
    
    
}
