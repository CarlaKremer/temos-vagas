
package DAO;

import DTO.EmpresaDTO;
import Util.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpresaDAO {

        Connection con;
        PreparedStatement pstm;
        ResultSet rs;
        
    public void inserir(EmpresaDTO objEmpresaDTO) throws SQLException, ClassNotFoundException{
  
        String sql = "INSERT INTO tbusuario(razao_social,usuario, senha ,cnpj,"
                + "inscricao_estadual,telefone1,telefone2,email,ramo_de_atuacao) VALUES (?,?,?,?,?,?,?,?,?);";
        //Criando conexão
         System.out.println("Chamou a conexao");
        con = new ConexaoUtil().getInstance().getConnection();
        System.out.println("Voltou com a conexão para EmpresaDAO");
          
        System.out.println("Vai começar o Try do pstm");
          
        try{
             System.out.println("começou o try");
           //Ponte entre o java e o banco
           pstm = con.prepareStatement(sql);
           //
            pstm.setString(1, objEmpresaDTO.getRazao_social());
            pstm.setString(2, objEmpresaDTO.getUsuario());
            pstm.setString(3, objEmpresaDTO.getSenha());
            pstm.setString(4, objEmpresaDTO.getCnpj());
            pstm.setString(5, objEmpresaDTO.getInscricao_estadual());
            pstm.setString(6, objEmpresaDTO.getTelefone1());
            pstm.setString(7, objEmpresaDTO.getTelefone2());
            pstm.setString(8, objEmpresaDTO.getEmail());
            pstm.setString(9, objEmpresaDTO.getRamo_de_atuacao());
            
            pstm.execute();
            pstm.close();
            
                  
        } catch (SQLException e){
            System.out.println("erro sql no EmpresaDAO" + e);     
        }    
        con.close();
    }
    public boolean validarLogin(String usuario, String senha) throws SQLException, ClassNotFoundException{
        boolean retorno;
         con = new ConexaoUtil().getInstance().getConnection(); //faz conexao
         
         //Pesquisa no banco pra achar usuario e senha
      
         //String sql = "SELECT * FROM tbusuario where usuario = '" +usuario+ "' and senha = '" +senha+"';";
         String sql = "SELECT usuario FROM tbusuario where usuario = '" +usuario+ "';";
         String usuarioDb ="";
         String senhaDb = "";
         System.out.println(sql);
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         System.out.println("rs: "+rs);
         while(rs.next()){
             usuarioDb = rs.getString("usuario");
             System.out.format("%s", usuarioDb);
         }
         /*try {
            pstm = con.prepareStatement(sql);
             System.out.println("pstm: "+pstm);
             rs = pstm.executeQuery();
             System.out.println("rs: "+rs);
             pstm.close();
        
        } catch (SQLException e) {
             System.out.println("ERRO AQUI" + e);
        }*/
        sql = "SELECT senha FROM tbusuario where usuario = '" +senha+ "';";
        rs = st.executeQuery(sql);
        while(rs.next()){
            senhaDb = rs.getString("senha");
            System.out.format("%s", senhaDb);
        }
        System.out.println("usuarioDb: "+usuarioDb+" usuario: "+usuario+ " senhaDb: "+senhaDb+" senha: "+senha);
        if((usuarioDb.equals(usuario)) && (senhaDb.equals(senha))){

           retorno = true;
        }else{
            retorno = false;
        }
         con.close();
          /*if(rs.next()){
              System.out.println(rs.next());
             //Validou usuário
             return true;
         }else{
             //Não validou usuário
             return false;
         }*/
         return retorno;
    }
    
    public String mandaCodUsuario(String usuario) throws SQLException, ClassNotFoundException{
        con = new ConexaoUtil().getInstance().getConnection(); //faz conexao
        String codUsuario = "";
        String sql = "SELECT cod_usuario FROM tbusuario where usuario = '" +usuario+ "';";
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
             codUsuario = rs.getString("cod_usuario");
         }
        return codUsuario;
    }

}
