<%@page import="java.util.ArrayList"%>
<%@page import="DTO.VagasDTO"%>
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
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="css/parallax.css">
    <link rel="stylesheet" href="font.css">
</head>

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
        <!-- Verifica se a seção foi criada para mostrar a página -->
        <%
            String usuario = (String) session.getAttribute("USUARIO");
            String codUsuario = (String) session.getAttribute("COD");
            System.out.print(codUsuario + "LÀ EM CIMA");
            if(usuario == null){
            response.sendRedirect("login.jsp");
            }
        %>
        
         <!--Fim da verificação -->  
    
        <!-- Parallax -->
        <div id="index-banner" class="parallax-container">
            <div class="section no-pad-bot">
                <div class="container">
                    <br><br>
                    <h1 class="header left black-text"><%=usuario%></h1>
                    <div class="row left-align">
                        <h5 class="header col s12 deep-orange-text text-lighten-2">Seja bem vindo de volta! </h5>
                    </div>
                    <br><br>
                </div>
            </div>
            <div class="parallax">
                <img src=" https://images.pexels.com/photos/7675860/pexels-photo-7675860.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940 " alt="Unsplashed background img 1 " style="transform: translate3d(-50%, 220.748px, 0px); opacity: 1; "></div>
        </div>
        <!--fim parallax-->

        <!-- cards de vagas disponíveis -->
        <!-- titulo -->
        
        <div class="section ">
            <div class="row container ">
                <h2 class="header">Vagas cadastradas</h2>
                <p class="grey-text text-darken-3 lighten-3 ">Veja quais vagas você cadastrou nos últimos dias</p>
            </div>
        </div>
        <!-- cards -->

        <div class="container s12 m6 ">
            <div class="row ">
                <!-- card-vaga -->
                
                <%
                    
                    try{
                        
                        VagasDAO objVagasDAO = new VagasDAO();
                        ArrayList<VagasDTO> lista = objVagasDAO.PesquisarCodigo(codUsuario);
                    
                            for(int num = 0; num < lista.size(); num++){
                                
                                
                %>
                            
                            
                <div class="col s12 m6 ">
                    <div class="card grey lighten-4 ">
                        <div class="card-content grey-text text-darken-4 ">
                            <!-- tipo da vaga -->
                            <span class="card-title ">
                               <%
                               out.print(lista.get(num).getTipoVaga() + " - " + lista.get(num).getNome_vaga());
                               %> 
                               
                            </span>
                            <!-- descricao da vaga -->
                            <p></p>
                        </div>
                        <!-- link para se aplicar a vaga -->
                        <form action = "ServListar">
                            <!--UTILIZEI UM INPUT HIDDEN PARA IDENTIFICAR E  ENVIAR AO SERVLET QUAL A VAGA QUE O USUÁRIO CLICOU: -->
                            <input value="<%=lista.get(num).getNome_vaga()%>" id="nomeVaga" type="hidden"name="hdnNomeVaga">
                            <input value="<%=lista.get(num).getTipoVaga()%>" id="nomeVaga" type="hidden"name="hdnTipoVaga">
                            <input value="<%=codUsuario%>" id="nomeVaga" type="hidden"name="hdnCodUsuario">
                            
                            <div class="card-action ">
                                <button class="waves-effect waves-teal btn-flat deep-orange-text text-lighten-2" type="submit" >Ver candidatos</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- card-vaga -->
                <%      }
                    }catch(Exception e) {}%>
              
                <!--fim Cadastrar nova vaga-->
              
            </div>
        </div>
        <!-- fim cards -->
        <!-- fim de vagas disponíveis -->
        <!--Cadastrar nova vaga-->
        <section class="adicionar-vaga ">
            <div class="container ">
                <div class="row right ">
                    <div class="col ">
                        <a href="cria_vaga.jsp" class="waves-effect waves-light btn-large red deep-orange lighten-1 "><i class="material-icons left ">add</i>Adicionar Vaga</a>
                    </div>
                </div>
            </div>
        </section>
        <!--fim Cadastrar nova vaga-->

        <br><br><br><br>


    </main>


    <!--Footer-->
    <footer class="page-footer grey darken-4 center ">
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