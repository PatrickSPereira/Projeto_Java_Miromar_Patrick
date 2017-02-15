 
package br.com.DAO;

import br.com.Model.CdtrPessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miromar
 */
public class CdtrPessoaDAO {
    
    private Connection con = ConexaoJava.Conectar();
    String sql = "";
    PreparedStatement prep = null;
    
      /**
        Cadastra pessoas  
     * @param cdtrPessoa */   
    public void insert(CdtrPessoa cdtrPessoa){
  
         sql = "INSERT INTO CDTR_PESSOA(CAFU_PK,CURS_PK,PESS_NOME,PESS_LATTES,PESS_LOGIN,PESS_SENHA)"
                 + " VALUES(?,?,?,?,?,?)";
    
        try {
            prep = con.prepareStatement(sql);
            
            prep.setInt(1,cdtrPessoa.getCafuPk());
            prep.setInt(2, cdtrPessoa.getCursPk());
            prep.setString(3, cdtrPessoa.getPessNome());
            prep.setString(4, cdtrPessoa.getPessLattes());
            prep.setString(5, cdtrPessoa.getPessLogin());
            prep.setString(6, cdtrPessoa.getPessSenha());
            
            prep.execute();
            prep.close();
            
            
            
        } catch (SQLException ex) {
            System.out.println("Erro no Insert" + ex);
        }
    
        
    }
    
    public void update(CdtrPessoa cdtrPessoa){
        
        /**
        Alterar dados da pessoa
        */
        
         sql = "ALTER TABLE CDTR_PESSOA SET CAFU_PK = ?,CURS_PK = ?,"
                + "PESS_NOME = ?, PESS_LATTES = ?, PESS_LOGIN = ?, PESS_SENHA = ? "
                 + "WHERE PESS_PK = ? ";
        
        try {
            prep.setInt(1,cdtrPessoa.getCafuPk());
            prep.setInt(2, cdtrPessoa.getCursPk());
            prep.setString(3, cdtrPessoa.getPessNome());
            prep.setString(4, cdtrPessoa.getPessLattes());
            prep.setString(5, cdtrPessoa.getPessLogin());
            prep.setString(6, cdtrPessoa.getPessSenha());
            
            prep.setInt(7, cdtrPessoa.getPessPk());
            
            prep.execute();
            prep.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro na alteração" + ex);
        }
        
        
    }
    /**O metodo getByAll faz um select * from CDTR_PESSOA, mas trazendo as descrições
     ao inves das chaves primarias
     * @return */
      public List<CdtrPessoa> getByAll(){
        List<CdtrPessoa> lista = new ArrayList<>();
        
        sql = "                 SELECT CAFU_DESCRICAO AS FUNCAO,"
                + "             PESS_LOGIN AS LOGIN," +
"				CURS_DESCRICAO AS CURSO,"
                + "             PESS_NOME AS NOME ," +
"                               PESS_LATTES AS LATTES " +
"				FROM CDTR_PESSOA,CDTR_CURSO,CDTR_FUNCAO " +
"				WHERE CDTR_PESSOA.CAFU_PK = CDTR_FUNCAO.CAFU_PK " +
"                               AND CDTR_PESSOA.CURS_PK = CDTR_CURSO.CURS_PK";
        
        
        try {
            prep = con.prepareStatement(sql);
              ResultSet res = prep.executeQuery();
              
              while(res.next()){
                  CdtrPessoa pessoa = new CdtrPessoa();
                  
                  pessoa.setPessNome(res.getString("NOME"));
                  pessoa.setCafuDescricao(res.getString("FUNCAO"));
                  pessoa.setPessLogin(res.getString("LOGIN"));
                  pessoa.setCursoDescricao(res.getString("CURSO"));
                  pessoa.setPessLattes(res.getString("LATTES"));
                  
                  lista.add(pessoa);
                 
              }
               prep.close();
              
        } catch (SQLException ex) {
            System.out.println(ex);
        }
      
        
        
        
        return lista;
    }
    
    
    
    
     /**
        Busca todos os dados da pessoa de acordo com a tabela        
     * @return 
        */
    public List<CdtrPessoa> selecionar_todos_dados_pessoa(){
       
        List<CdtrPessoa> lista =  new ArrayList<>();
        
       sql = "SELECT * FROM CDTR_PESSOA";
        
        try {
            prep = con.prepareStatement(sql);
            
            ResultSet res = prep.executeQuery();
            while(res.next()){
                CdtrPessoa cdtr_pessoa = new CdtrPessoa();
                
                cdtr_pessoa.setPessPk(res.getInt("pess_pk"));
                cdtr_pessoa.setCafuPk(res.getInt("cafu_pk"));
                cdtr_pessoa.setPessLogin(res.getString("pess_login"));
                cdtr_pessoa.setPessSenha(res.getString("pess_senha"));
                cdtr_pessoa.setCursPk(res.getInt("curs_pk"));
                cdtr_pessoa.setPessNome(res.getString("pess_nome"));
                cdtr_pessoa.setPessLattes(res.getString("pess_lattes"));
                        
                lista.add(cdtr_pessoa);
                
            }
            prep.close();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Pessoas" + ex);
        }                
        return lista;                
    }
    
    public CdtrPessoa getByLogin(CdtrPessoa cdtrPessoa){
        CdtrPessoa retornoLogin = null;
        
        sql = "SELECT PESS_LOGIN,PESS_SENHA FROM CDTR_PESSOA "
                + "WHERE PESS_LOGIN = ? AND PESS_SENHA = ? ";
        
        
        try {
             prep = con.prepareStatement(sql);
             prep.setString(1, cdtrPessoa.getPessLogin());
             prep.setString(2, cdtrPessoa.getPessSenha());
             
             ResultSet res = prep.executeQuery();
             if(res.next()){
                 retornoLogin = new CdtrPessoa();
                 retornoLogin.setPessLogin(res.getString("PESS_LOGIN"));
                 retornoLogin.setPessLogin(res.getString("PESS_SENHA"));
             }
             prep.close();
             System.out.println("Login com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro no Login"+ ex);
        }
        
        
        return retornoLogin;
    }
    
//    public CdtrPessoa getByName(String nome){
//        CdtrPessoa cdtrPessoa = null;
//        sql = "SELECT PESS_NOME * FROM CDTR_PESSOA WHERE PESS_LOGIN = ?";
//        
//        try {
//            prep = con.prepareStatement(sql);
//            prep.setString(1, nome);
//            ResultSet res  = prep.executeQuery();
//            while(res.next()){
//                 cdtrPessoa = new CdtrPessoa();
//                 cdtrPessoa.setPessNome(res.getString("pess_nome"));
//            }
//             
//            
//            
//        } catch (SQLException ex) {
//            System.out.println("Erro na busca por nome" +ex);
//        }
//        
//      
//        return cdtrPessoa;
//    }
    
    /*
        String sql  = "      SELECT  PESS.PESS_PK " +
                      "             ,PESS_NOME AS NOME " +
                      "             ,PESS_LATTES AS LATTES " +
                      "             ,CURS.CURS_DESCRICAO AS CURSO " +
                      "             ,CAFU_DESCRICAO AS FUNCAO " +
                      "             ,CALO_LOGIN AS LOGIN " +
                      "        FROM CDTR_PESSOA PESS " +
                      "   LEFT JOIN CDTR_CURSO CURS " +
                      "          ON CURS.CURS_PK = PESS.CURS_PK " +
                      "   LEFT JOIN CDTR_LOGIN CALO " +
                      "          ON CALO.CALO_PK = PESS.CALO_PK " +
                      "   LEFT JOIN CDTR_FUNCAO CAFU " +
                      "          ON CAFU.CAFU_PK = PESS.CAFU_PK ";
        */
    
  
}
