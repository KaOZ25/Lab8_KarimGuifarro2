package lab8_karimguifarro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Dba {
    private String base_datos;
    private Connection dbcon;
    public Statement query;
    
    public Dba(String base_datos){
        this.base_datos=base_datos;
    }

    public void setBase_datos(String base_datos) {
        this.base_datos = base_datos;
    }        
    
   public void conectar(){
        try {
            
            String driver = "jdbc:ucanaccess://";
            dbcon = DriverManager.getConnection(driver+base_datos,"","");
            query = dbcon.createStatement();
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        } catch (Exception e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }
   
   public void desconectar() {
        try {
            query.close();
            dbcon.close();
        } catch (Exception e) {
        }
    }
   
   public void commit(){
       try{
           dbcon.commit();
       }catch(Exception e){
           e.printStackTrace();
       }
   }
    
    
}
