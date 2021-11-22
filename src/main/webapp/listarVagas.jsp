
<%@page import="DTO.CandidatoDTO"%>
<%@page import="DTO.VagasDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.VagasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Temos Vagas</title>
    <!--JQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/parallax.css">
    <link rel="stylesheet" href="css/font.css">
</head>
<%  
    //ACESSAR PARAMETRO ESTABELECIDOS NO ServListar
    HttpSession sessao = request.getSession();
    String vagaCricada = (String) sessao.getAttribute("NOME");
    String tipoVaga = (String) sessao.getAttribute("TIPO");
    String idUsuario = (String) sessao.getAttribute("CODIGO_USUARIO");
    
    System.out.println("nome da vaga: "+ vagaCricada);
    
    CandidatoDTO objCandidatoDTO = new CandidatoDTO();
    VagasDAO objVagasDAO = new VagasDAO();
    //O MÉTODO pesquisaVagaListar()EM VagasDAO.java PESQUISA UMA VAGA ESPECÍFICA NO BANCO
    ArrayList<CandidatoDTO> listaCandidato = objVagasDAO.pesquisaVagaListar(idUsuario,vagaCricada);
    
%>
<body class="grey lighten-4">
    <!--Navbar-->
    <div class="navbar-fixed ">
        <nav class="grey darken-4">
            <div class="nav-wrapper">
                <div class="container">
                    <!-- web -->
                    <a href="index.jsp" class="brand-logo deep-orange-text text-lighten-2">Temos Vagas</a>
                    <ul class="lista right hide-on-med-and-down ">
                        <li><a href="cadastroUsuario.html" class=" deep-orange-text text-lighten-2">Cadastre-se</a></li>
                        <li><a href="login.jsp" class=" deep-orange-text text-lighten-2">Login</a></li>
                    </ul>
                    <!-- mobile -->
                    <ul id="nav-mobile" class="sidenav">
                        <li><a href="cadastroUsuario.html" class=" deep-orange-text text-lighten-2">Cadastre-se</a></li>
                        <li><a href="login.jsp" class=" deep-orange-text text-lighten-2">Login</a></li>
                    </ul>
                    <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                </div>
            </div>
        </nav>
    </div>
    <!--fim Navbar-->
    <main>
        <div class="container s12 m6">
            
            <br>
            <h5><%=vagaCricada+" - "+ tipoVaga%> </h5>
            <br><br>
            <div class="row">
                <table class="centered responsive-table">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Contato</th>
                            <th>Currículo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--PARA CADA VAGA ENCONTRADA, UMA LINHA NA TABELA-->
                        <%for(int num = 0; num < listaCandidato.size(); num++){%>
                        <tr>
                       
                        <td><%=listaCandidato.get(num).getNome()%></td>
                        <td><%=listaCandidato.get(num).getContato()%></td>
                        <td>nome.pdf</td>
                        </tr><%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
          <%
            /*try {
               for(int num = 0; num < lista.size(); num++){
               
                 out.print("<p>Código: " + lista.get(num).getCod_vagas()+ "</p><br>");
                 out.print("<p>Nome: " + lista.get(num).getNome_vaga()+ "</p><br>");
                 out.print("<p>Descrição: " + lista.get(num).getDescricao()+ "</p><br>");
                 out.print("<p>Bolsa: " + lista.get(num).getBolsa()+ "<br></p>");
                 out.print("<p>Semestre: " + lista.get(num).getSemestre()+ "</p><br>");
                 out.print("<p>Curso: " + lista.get(num).getCurso()+ "</p><br>");
                 out.print("<p>Conclusão: " + lista.get(num).getAno_conclusao()+ "</p><br>");
               }
               
            } catch (Exception e) {
            e.printStackTrace();
            }*/
        %> 
   <!--Footer-->
<footer class="page-footer grey darken-4 center">
    © 2021 Copyright Text
</footer>
<!--fim Footer-->

<!-- parallax init -->
<script>
    $(document).ready(function() {
        $('.parallax').parallax();
    });
</script>
</body>

</html>

