/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author carla
 */
import DTO.CandidatoDTO;
import Util.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CandidatoDAO {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;

    public void inserir(CandidatoDTO objCandidatoDTO) throws SQLException, ClassNotFoundException{

       String sql = "INSERT INTO tbcandidato(nome,contato,codigo_vagas) VALUES (?,?,?);"; 
       con = new ConexaoUtil().getInstance().getConnection();

        try {
            pstm = con.prepareStatement(sql);

            pstm.setString(1, objCandidatoDTO.getNome());
            pstm.setString(2, objCandidatoDTO.getContato());
            pstm.setString(3, objCandidatoDTO.getCodigo_vagas());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("erro sql no CandidatoDAO" + e);
        }
    }

}