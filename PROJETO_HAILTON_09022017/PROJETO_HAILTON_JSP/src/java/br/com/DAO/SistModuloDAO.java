 
package br.com.DAO;

import br.com.Model.SistModulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miromar
 */
public class SistModuloDAO {
    
    
    private Connection con =  ConexaoJava.Conectar();
    PreparedStatement prep = null;
     String sql = "";
    
     /**Cadastra os Modulos do Sistema
     * @param simoModulo
     */
    public void insert(SistModulo simoModulo){
       
        sql  = "INSERT INTO SIST_MODULO(SIMO_DESCRICAO) VALUES (?)";
        
        try {
            prep = con.prepareStatement(sql);
            
            prep.setString(1, simoModulo.getSimoDescricao());
            prep.execute();
            prep.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Erro no insert" +ex);
        }
       
    }
    /**O método update altera a descrição de um modulo já existente
     * @param simoModulo */
      public void update(SistModulo simoModulo){
       
        sql  = "UPDATE SIST_MODULO SET SIMO_DESCRICAO = ? WHERE  SIMO_PK = ?";
        
        try {
            prep = con.prepareStatement(sql);
            
            prep.setString(1, simoModulo.getSimoDescricao());
            prep.setInt(2,simoModulo.getSimoPk() );
            prep.execute();
            prep.close();
            
            
        } catch (SQLException ex) {
            System.out.println("Erro no insert" +ex);
        }
       
    }
      /**O método getByAll gera uma lista com todos os modulos cadastrados 'SELECT * FORM SIST_MODULO
     * @return  */
      public List<SistModulo> getByAll(){
          List<SistModulo> lista = new ArrayList<>();
          
          sql = "SELECT * FROM SIST_MODULO";
        try {
            prep = con.prepareStatement(sql);
            ResultSet res = prep.executeQuery();
            while(res.next()){
                SistModulo sistModulo = new SistModulo();
                sistModulo.setSimoPk(res.getInt("simo_pk"));
                sistModulo.setSimoDescricao(res.getString("simo_descricao"));
               lista.add(sistModulo);
            }
            prep.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro no Select "+ ex);
        }
          
          return lista;
      }
       /** Este metódo getById busca um modulo pelo ID que neste caso é  a SIMO_PK
     * @param id
     * @return  */
      public SistModulo getById(int id){
          SistModulo sistModulo = null;
          
          sql = "SELECT * FROM SIST_MODULO WHERE SIMO_PK = ?";
        try {
            prep = con.prepareStatement(sql);
            prep.setInt(1, id);
            ResultSet res = prep.executeQuery();
            if(res.next()){
                sistModulo = new SistModulo();
                
                sistModulo.setSimoDescricao(res.getString("simo_descricao"));
                sistModulo.setSimoPk(res.getInt("simo_pk"));
            }
            prep.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro na busca por ID "+ ex);
        }
          
          return sistModulo;
     
      
      }
       /** Este método busca por nome os modulos cadastradas
     * @param nome
     * @return  */
      public List<SistModulo> getByName(String nome){
          List<SistModulo> lista = new ArrayList<>();
          
          
          sql = "SELECT FROM SIST_MODULO WHERE SIMO_DESCRICAO LIKE ?";
        try {
            prep = con.prepareStatement(sql);
            prep.setString(1,"%"+nome+"%");
            
            ResultSet res = prep.executeQuery();
            while(res.next()){
                SistModulo sistModulo = new SistModulo();
                sistModulo.setSimoPk(res.getInt("SIMO_PK"));
                sistModulo.setSimoDescricao(res.getString("SIMO_DESCRICAO"));
                lista.add(sistModulo);
            }
            prep.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro na busca por nome "+ ex);
        }
          
          
          return lista;
      }
        
    
}
