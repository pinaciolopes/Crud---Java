
package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public Connection conetaBD(){
        
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/cadastro?useSSL=false";
            String user = "root";
            String password ="";
            
            conn = DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            System.out.println("Deu ruim "+e.getMessage() );
        }
        return conn;
    }
  }   

