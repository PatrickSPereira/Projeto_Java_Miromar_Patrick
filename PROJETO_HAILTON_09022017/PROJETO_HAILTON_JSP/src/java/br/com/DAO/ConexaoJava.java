 
package br.com.DAO;

import br.com.Model.ConstantesConexao;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoJava {
    
    public static Connection Conectar(){
        
        Connection con  = null;
        
        
        ConstantesConexao constantes  = new ConstantesConexao();
        
        try {
            Class.forName(constantes.getDriver());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no Driver" + ex);
        }
        
        try {
            con = (Connection) DriverManager.getConnection(constantes.getUrl(), constantes.getUsuario(), constantes.getSenha());
              System.out.println("Conectado com Sucesso");
              
        } catch (SQLException ex) {
            System.out.println("Erro na conexão" + ex);
        }
        
        
        return con;
    }
    
  
    
}
 