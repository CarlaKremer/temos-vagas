
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {
    private static ConexaoUtil conexaoUtil;
    
    public static ConexaoUtil getInstance(){
        if(conexaoUtil == null){
            conexaoUtil = new ConexaoUtil();
        }
        return conexaoUtil;
    }

    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        
    String url = "jdbc:mysql://localhost:3306/temosvagas"; 
    String usuario = "root"; 
    String senha = "1234"; 

          // System.out.println("Dentro do conexaoUtil, vai decalarar o driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
          // System.out.println("mandando o return"); 
        return DriverManager.getConnection(url,usuario,senha);
    }
     
    public static void main (String []args){
        try{    
            System.out.println(getInstance().getConnection());
           if (conexaoUtil != null){
            System.out.println("DEU CERTO" );
            }   
        }catch (Exception e){
            e.printStackTrace();
        }
       
    }
}
