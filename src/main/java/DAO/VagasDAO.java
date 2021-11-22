
package DAO;


import DTO.CandidatoDTO;
import DTO.VagasDTO;
import Util.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VagasDAO {
    ResultSet rs;
    Connection con;
    PreparedStatement pstm;
    ArrayList<VagasDTO> lista = new ArrayList<>();
    ArrayList<VagasDTO> listaCodigo = new ArrayList<>();
    ArrayList<CandidatoDTO> listaCandidato = new ArrayList<>();
    
    public void inserir(VagasDTO objVagasDTO) throws SQLException, ClassNotFoundException{
        
      String sql = "INSERT INTO tbvagas(nome_vaga,descricao_requisitos,bolsa_remuneracao,semestre,curso,conclusao,tipo_vaga,cod_usuario,codigo_vagas) VALUES (?,?,?,?,?,?,?,?,?);";
        //Criando conexão

        con = new ConexaoUtil().getInstance().getConnection();
        try{
             System.out.println("começou o try");
           //Ponte entre o java e o banco
           pstm = con.prepareStatement(sql);
        
            pstm.setString(1, objVagasDTO.getNome_vaga());
            pstm.setString(2, objVagasDTO.getDescricao());
            pstm.setString(3, objVagasDTO.getBolsa());
            pstm.setString(4, objVagasDTO.getSemestre());
            pstm.setString(5, objVagasDTO.getCurso());
            pstm.setString(6, objVagasDTO.getAno_conclusao());
            pstm.setString(7, objVagasDTO.getTipoVaga());
            pstm.setString(8, objVagasDTO.getCodUsuario());
            pstm.setString(9, objVagasDTO.getCod_vagas());
            
            pstm.execute();
            pstm.close();
            
            //System.out.println("/nacabou o try o try/n");
        } catch (SQLException e){
            System.out.println("erro sql no VagasDAO" + e);     
        }    
        con.close();
    }
    
    public ArrayList<VagasDTO> PesquisarVagas()throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM tbvagas";
        //Criando conexão
        con = new ConexaoUtil().getInstance().getConnection();
        try {
             pstm = con.prepareStatement(sql);
             //Retorna info do banco (por linhas)
             rs = pstm.executeQuery(sql);
             
             //Loop para pegar todas as linhas da tabela do banco
             while(rs.next()){
                 VagasDTO objVagasDTO = new VagasDTO();
                 
                 objVagasDTO.setCod_vagas(rs.getString("codigo_vagas"));
                 objVagasDTO.setNome_vaga(rs.getString("nome_vaga"));
                 objVagasDTO.setDescricao(rs.getString("descricao_requisitos"));
                 objVagasDTO.setBolsa(rs.getString("bolsa_remuneracao"));
                 objVagasDTO.setSemestre(rs.getString("semestre"));
                 objVagasDTO.setCurso(rs.getString("curso"));
                 objVagasDTO.setAno_conclusao(rs.getString("conclusao"));
                 objVagasDTO.setTipoVaga(rs.getString("tipo_vaga"));
                 
                 //Passa os valores das linhas do banco pra um vetor 
                 lista.add(objVagasDTO);
             }
             
        } catch (SQLException e) {
            System.out.println("ERRO AQUI PesquisarVagas" + e);     
        }
        //Retorna os valores
         return lista;
    }
    
    public ArrayList<CandidatoDTO> pesquisaVagaListar(String idUsuario,String vagaCricada) throws SQLException, ClassNotFoundException{
  
        System.out.println("Nome vaga no pesquisar"+idUsuario);
     
       String sql ="SELECT c.nome,c.contato,c.codigo_vagas FROM tbvagas v INNER JOIN tbcandidato c ON v.CODIGO_VAGAS= c.codigo_vagas WHERE v.COD_USUARIO= '"+idUsuario+"' AND v.nome_vaga= '"+vagaCricada+"'; ";
      
        //Criando conexão
        con = new ConexaoUtil().getInstance().getConnection();
        try {
             pstm = con.prepareStatement(sql);
             //Retorna info do banco (por linhas)
             rs = pstm.executeQuery(sql);
             
             //Loop para pegar todas as linhas da tabela do banco
             while(rs.next()){
 
                 CandidatoDTO objCandidatoDTO = new CandidatoDTO();
                 
                    objCandidatoDTO.setCodigo_vagas(rs.getString("codigo_vagas"));
                    objCandidatoDTO.setNome(rs.getString("nome"));
                    objCandidatoDTO.setContato(rs.getString("contato"));
                    
               
                 //APENAS USEI PARA TESTAR SE FUNCIONA: 
                
                 //Passa os valores das linhas do banco pra um vetor 
                 listaCandidato.add(objCandidatoDTO);
             }
             
        } catch (SQLException e) {
            System.out.println("ERRO AQUI PesquisaVagaListar" + e);     
        }
        //Retorna os valores
         return listaCandidato;
    }
        public ArrayList<VagasDTO> PesquisarCodigo(String atual)throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM tbvagas WHERE COD_USUARIO = '"+atual+"'";
        //Criando conexão
        con = new ConexaoUtil().getInstance().getConnection();
        try {
             pstm = con.prepareStatement(sql);
             //Retorna info do banco (por linhas)
             rs = pstm.executeQuery(sql);
             
             //Loop para pegar todas as linhas da tabela do banco
             while(rs.next()){
                 VagasDTO objVagasDTO = new VagasDTO();
                 
                 objVagasDTO.setNome_vaga(rs.getString("nome_vaga"));
                 objVagasDTO.setTipoVaga(rs.getString("tipo_vaga"));
                 
                 //Passa os valores das linhas do banco pra um vetor 
                 listaCodigo.add(objVagasDTO);
             }
             
        } catch (SQLException e) {
            System.out.println("ERRO AQUI PesquisarCodigo" + e);     
        }
        //Retorna os valores
         return listaCodigo;
    }
    
    
} 