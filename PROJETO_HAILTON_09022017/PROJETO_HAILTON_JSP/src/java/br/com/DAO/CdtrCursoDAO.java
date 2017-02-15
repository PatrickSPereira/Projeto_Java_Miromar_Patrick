package br.com.DAO;

import br.com.Model.CdtrCurso;
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
public class CdtrCursoDAO {

   private Connection con = ConexaoJava.Conectar();
   PreparedStatement prep = null;
   String sql = "";
    
    /** Este método insert cadastra a Descrição do curso
     * @param cdtrCurso **/
    public void insert(CdtrCurso cdtrCurso) {
        
        sql = "INSERT INTO CDTR_CURSO(CURS_DESCRICAO) VALUE (?)";

        try {
            prep = con.prepareStatement(sql);
            prep.setString(1, cdtrCurso.getCursDescricao());
            prep.execute();
            prep.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Insert " + ex);
        }

    }
    /**O método update altera a descição de um curso já existente
     * @param cdtrCurso */
    public void update(CdtrCurso cdtrCurso) {

        sql = "UPDATE CDTR_CURSO SET CURS_DESCRICAO = ? WHERE CURS_PK = ?";

        try {
            prep = con.prepareStatement(sql);
            prep.setString(1, cdtrCurso.getCursDescricao());
            prep.setInt(2, cdtrCurso.getCursPk());
            prep.execute();
            prep.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Insert " + ex);
        }

    }
/**O método getByAll gera uma lista com todos os cursos cadastradoS 'SELECT * FORM CDTR_CURSO'
     * @return lista de cursos */
    public List<CdtrCurso> getByAll() {
        List<br.com.Model.CdtrCurso> lista = new ArrayList<>();

        sql = "SELECT * FROM CDTR_CURSO";

        try {
            prep = con.prepareStatement(sql);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                CdtrCurso cdtrCurso = new CdtrCurso();
                cdtrCurso.setCursDescricao(res.getString("curs_descricao"));
                cdtrCurso.setCursPk(res.getInt("curs_pk"));
                lista.add(cdtrCurso);
            }
            prep.close();

        } catch (SQLException ex) {
            System.out.println("Erro no Select " + ex);
        }

        return lista;
    }
    
/** O método getById busca o curso pelo ID que neste caso é CURS_PK
     * @param id
     * @return */
    public CdtrCurso getByID(int id) {

        CdtrCurso cdtrCurso = null;

        sql = "SELECT * FROM CDTR_CURSO WHERE CURS_PK = ?";

        try {
            prep = con.prepareStatement(sql);
            prep.setInt(1, id);

            ResultSet res = prep.executeQuery();
            if (res.next()) {
                cdtrCurso = new CdtrCurso();
                cdtrCurso.setCursPk(res.getInt("curs_pk"));
                cdtrCurso.setCursDescricao(res.getString("curs_descricao"));
            }
            prep.close();

        } catch (SQLException ex) {
            System.out.println("Erro na busca por ID " + ex);
        }

        return cdtrCurso;
    }
    
    /** Este método busca por nome os cursos cadastrado
     * @param nome
     * @return */
    public List<CdtrCurso> getByName(String nome){
         List<CdtrCurso> lista = new ArrayList<>();
         
         sql = "SELECT * FROM CDTR_CURSO WHERE CURS_DESCRICAO LIKE ?";
        
         
        try {
            prep = con.prepareStatement(sql);
            prep.setString(1, "%"+nome+"%");
            
            ResultSet res =  prep.executeQuery();
            while(res.next()){
                CdtrCurso cdtrCurso = new CdtrCurso();
                cdtrCurso.setCursPk(res.getInt("curs_pk"));
                cdtrCurso.setCursDescricao(res.getString("curs_descricao"));
                lista.add(cdtrCurso);
            }
            prep.close();
        } catch (SQLException ex) {
            System.out.println("Erro na busca por nome "+ ex);
        }
         
         
         
        return lista;
        
    }
       

}
