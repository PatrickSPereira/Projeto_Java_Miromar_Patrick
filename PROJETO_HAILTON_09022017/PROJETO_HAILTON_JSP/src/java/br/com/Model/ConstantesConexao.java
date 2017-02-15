
package br.com.Model;


public class ConstantesConexao {
    
    private String url = "jdbc:mysql://localhost:3306/projeto_hailton_php";
    private String driver = "com.mysql.jdbc.Driver";
    private String usuario = "root";
    private String senha = "root";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
