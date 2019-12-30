
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP7900
 */
public class PersonaDAO implements Validar {
    Connection con;
    Conexion cn=new  Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;

    @Override
    public int validar(Persona per) {
        String sql= "select * from persona where Nombres=? AND Correo=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getNom());
            ps.setString(2, per.getCorreo());
            rs=ps.executeQuery();
            while(rs.next()) {
                r=r+1;
                per.setNom(rs.getString("Nombres"));
                per.setCorreo(rs.getString("Correo"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            
        }catch (Exception e){
            return 0;
        }
    }
    
}
