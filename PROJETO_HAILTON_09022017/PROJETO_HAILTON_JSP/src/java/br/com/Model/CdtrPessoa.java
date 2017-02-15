 
package br.com.Model;

/**
 *
 * @author miromar
 */
public class CdtrPessoa {
    
    private int pessPk = 0;
    private int cafuPk = 0;
    private int cursPk = 0;
    private String pessNome = "";
    private String pessLattes  = "";
    private String cursoDescricao = "";
    private String cafuDescricao = "";
    private String pessLogin = "";
    private String pessSenha = "";

    public int getPessPk() {
        return pessPk;
    }

    public void setPessPk(int pessPk) {
        this.pessPk = pessPk;
    }

    public int getCafuPk() {
        return cafuPk;
    }

    public void setCafuPk(int cafuPk) {
        this.cafuPk = cafuPk;
    }



    public int getCursPk() {
        return cursPk;
    }

    public void setCursPk(int cursPk) {
        this.cursPk = cursPk;
    }

    public String getPessNome() {
        return pessNome;
    }

    public void setPessNome(String pessNome) {
        this.pessNome = pessNome;
    }

    public String getPessLattes() {
        return pessLattes;
    }

    public void setPessLattes(String pessLattes) {
        this.pessLattes = pessLattes;
    }

    public String getCursoDescricao() {
        return cursoDescricao;
    }

    public void setCursoDescricao(String cursoDescricao) {
        this.cursoDescricao = cursoDescricao;
    }

    public String getCafuDescricao() {
        return cafuDescricao;
    }

    public void setCafuDescricao(String cafuDescricao) {
        this.cafuDescricao = cafuDescricao;
    }

 
    public String getPessLogin() {
        return pessLogin;
    }

    public void setPessLogin(String pessLogin) {
        this.pessLogin = pessLogin;
    }

    public String getPessSenha() {
        return pessSenha;
    }

    public void setPessSenha(String pessSenha) {
        this.pessSenha = pessSenha;
    }
    
    
}
