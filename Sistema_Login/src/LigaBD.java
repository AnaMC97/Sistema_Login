import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anacoelho
 */
public class LigaBD {
    
    public static Connection ligacao(){
    String url = "jdbc:mysql://localhost:3306/rhcencal?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "";
    Connection liga = null;
        try {
            liga = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro na tentativa de ligação à base de dados");
            //Logger.getLogger(LigaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return liga;
    }
    
    public static void registaUtilizador(String nome, String email, String morada, int telefone, int nif, String login, String password ) throws SQLException{
        String query = "INSERT INTO utilizador(nome, email, morada, telefone, nif, login, password)" + "VALUES(?,?,?,?,?,?,?)";
        Connection liga = ligacao();
        PreparedStatement ps = liga.prepareStatement(query);
        ps.setString(1, nome);
        ps.setString(2, email);
        ps.setString(3, morada);
        ps.setInt(4, telefone);
        ps.setInt(5, nif);
        ps.setString(6, login);
        ps.setString(7, password);
        ps.execute();
        
    }

    static void atualizaUtilizador(String nome, String email, String morada, String telefone, String nif, String pass) throws SQLException {
        Connection c = LigaBD.ligacao();
        String sql = "UPDATE utilizador SET nome=?, email = ?, morada = ?, telefone = ?, nif = ?, login = ?, password = ? WHERE login = '"+Login.log+"'";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(2, nome);
        ps.setString(3, email);
        ps.setString(4, morada);
        ps.setInt(5,Integer.parseInt(telefone));
        ps.setInt(6, Integer.parseInt(nif));
        ps.setString(7,Login.login);
        ps.setString(8, pass);
        //Executa a instrução
        int retorno = ps.executeUpdate();
        if(retorno > 0){
            System.out.printf("Novo registro alterado: ");
        }else{
            System.out.println("Não foi possível alterar os registros!");
        } 
    }

    static void remove(int p) {
        /*String r = Integer.parseInt("DELETE FROM utilizador WHERE login="'+log+'");*/
                
        try {
            PreparedStatement ps=null;
            Connection conexao = LigaBD.ligacao();
            ps = conexao.prepareStatement("DELETE FROM utilizador WHERE idUtilizador =" +p);
            ps.executeUpdate();
            System.out.println("Removed User :" + Login.log);
        } catch (SQLException e) {System.out.println("Error: " + e.getMessage()); }
    }
}
