/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso17;

import lib.Persona;
import libDao.PersonaDao;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pablowsky
 */
public class Caso17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Persona persona0 = new Persona(19406667, '8');
        Persona persona1 = new Persona(19406667, '8', "Pablo", "Esteban", "Bade", "Figueroa", 5675841, 56619039, "p.badef@gmail.com");
        Persona persona2 = new Persona(19004654, '0', "Aurora", "Amada", "Lizama", "Escaff", 77297403, 77297403, "lolito.jkd@hotmail.com");
        System.out.println("TEST DE CONSOLA");
        System.out.println(persona1.getNombre1()+" "+persona1.getApellidoPaterno());
        System.out.println("TEST DE CONSOLA BD");
        PersonaDao perDao1 = new PersonaDao(persona1);
        ResultSet rs1 = perDao1.getPersonaById(1);
        while(rs1.next()){
            System.out.println("Select persona por id "+rs1.getString("nombre1"));
        }
        
        Boolean resp = perDao1.insertPersona(persona2);
        System.out.println(resp);
        ResultSet rs2 = perDao1.getPersonaByRut(persona2.getRut());
//        while(rs2.next()){
//            System.out.println("Select persona por rut: id "+rs2.getString("id"));
//            System.out.println("Select persona por rut: nombre "+rs2.getString("nombre1"));
//        }
//        perDao1.deletePersonaByRut(persona2.getRut());
        System.out.println("Delete persona "+persona2.getRut());
        
        rs2 = perDao1.getPersonaAll();
        while(rs2.next()){
            System.out.println(rs2.getString("id"));
            System.out.println(rs2.getString("nombre1"));
        }
        
        persona2.setApellidoPaterno("NN");
        perDao1.updatePersona(persona2);
    }
    
}
