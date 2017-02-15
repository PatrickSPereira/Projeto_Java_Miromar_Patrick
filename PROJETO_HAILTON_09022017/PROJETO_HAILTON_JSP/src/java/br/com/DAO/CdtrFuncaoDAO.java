package br.com.DAO;

import br.com.Model.CdtrFuncao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CdtrFuncaoDAO {

    private Connection con = ConexaoJava.Conectar();    
    PreparedStatement prep = null;
    String sql = "";
    
    /** Este método insert cadastra a Descrição da função
     * @param cdtrFuncao */
    public void insert(br.com.Model.CdtrFuncao cdtrFuncao){
         sql = "INSERT INTO CDTR_FUNCAO(CAFU_DESCRICAO) VALUES (?)";
    
        try {
            prep = con.prepareStatement(sql);
            
            prep.setString(1, cdtrFuncao.getCafuDescricao());
            prep.execute();
            prep.close();                        
            
        } catch (SQLException ex) {
            System.out.println("Erro no Insert" + ex);
        }            
    }
    /**O método update altera a descrição de uma função já existente
     * @param cdtrFuncao */
    public void update(br.com.Model.CdtrFuncao cdtrFuncao){
        
       
        
        sql = "ALTER TABLE CDTR_FUNCAO SET CAFU_DESCRICAO = ? WHERE CAFU_PK = ?";
        
        try {
            prep.setString(1, cdtrFuncao.getCafuDescricao());
            prep.setInt(2,cdtrFuncao.getCafuPk());                                    
            prep.execute();
            prep.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro na alteração" + ex);
        }                
    }
    /**O método getByAll gera uma lista com todos as funções cadastradas 'SELECT * FORM CDTR_FUNÇÃO'
     * @return  */
    public List<CdtrFuncao> getByAll(){
        List<CdtrFuncao> lista =  new ArrayList<>();
        
        sql = "SELECT * FROM CDTR_FUNCAO";
        
        try {
            prep = con.prepareStatement(sql);
            
            ResultSet res = prep.executeQuery();
            while(res.next()){
                CdtrFuncao cdtrFuncao = new CdtrFuncao();
                
                cdtrFuncao.setCafuPk(res.getInt("CAFU_PK"));
                cdtrFuncao.setCafuDescricao(res.getString("CAFU_DESCRICAO"));                                        
                lista.add(cdtrFuncao);                
            }
            prep.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Funcoes" + ex);
        }                
        return lista;                
    }
    
    /** Este metódo getById busca uma função pelo ID que neste caso é  a CAFU_PK
     * @param id
     * @return */
    public CdtrFuncao getById(int id){
        CdtrFuncao cdtrFuncao = null;
        
        sql = "SELECT * FROM CDTR_FUNCAO WHERE CAFU_PK = ?";
        try {
            prep = con.prepareStatement(sql);
            prep.setInt(1, id);
            ResultSet res = prep.executeQuery();
            if(res.next()){
            cdtrFuncao = new CdtrFuncao();
            cdtrFuncao.setCafuPk(res.getInt("cafu_pk"));
            cdtrFuncao.setCafuDescricao(res.getString("cafu_descricao"));
            }
            prep.close();
                
        } catch (SQLException ex) {
            System.out.println("Erro na busca por ID " +ex);
        }
        
        
        return cdtrFuncao;
    }
     /** Este método busca por nome as funções cadastradas
     * @param nome
     * @return */
    public List<CdtrFuncao> getByName(String nome){
        List<CdtrFuncao> lista = new ArrayList<>();
        sql = "SELECT * FROM CDTR_FUNCAO WHERE CAFU_DESCRICAO LIKE ? ";
        try {
            prep = con.prepareStatement(sql);
            prep.setString(1,"%"+nome+"%");
            ResultSet res = prep.executeQuery();
            while(res.next()){
                CdtrFuncao cdtrFuncao = new CdtrFuncao();
                cdtrFuncao.setCafuPk(res.getInt("cafu_pk"));
                cdtrFuncao.setCafuDescricao(res.getString("cafu_descricao"));
                lista.add(cdtrFuncao);
            }
            prep.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro na busca pelo nome "+ex);
        }
        return lista;
    }

}
