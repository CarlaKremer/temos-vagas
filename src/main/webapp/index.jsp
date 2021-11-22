
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
    <link rel="stylesheet" href="css/parallax.css">
    <link rel="stylesheet" href="css/font.css">
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
        <!-- Parallax -->
        <div id="index-banner" class="parallax-container">
            <div class="section no-pad-bot">
                <div class="container">
                    <br><br>
                    <h1 class="header left black-text">Temos Vagas</h1>
                    <div class="row left-align">
                        <h5 class="header col s12 deep-orange-text text-lighten-2">Encontre as melhores vagas para conquistar seus sonhos</h5>
                    </div>
                    <br><br>
                </div>
            </div>
            <div class="parallax"><img src="https://images.pexels.com/photos/7675860/pexels-photo-7675860.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" alt="Unsplashed background img 1" style="transform: translate3d(-50%, 220.748px, 0px); opacity: 1;"></div>
        </div>
        <!--fim parallax-->

         <!-- titulo -->
        <div class="section">
            <div class="row container">
                <h2 class="header ">Vagas diponíveis</h2>
                <p class="grey-text text-darken-3 lighten-3 ">Veja quais vagas disponíveis se encaixam em seu perfil</p>
            </div>
        </div>
         
       

        <!-- cards -->
        <div class="container s12 m6">
            <div class="row">
            <%
                try {
                   VagasDAO objVagasDAO = new VagasDAO();
                   ArrayList<VagasDTO> lista = objVagasDAO.PesquisarVagas();
                   
                   for(int num = 0; num < lista.size(); num++){%>
                <!-- card-vaga -->
                <div class="col s12 m6">
                    <div class="card grey lighten-4">
                        <div class="card-content grey-text text-darken-4">
                            <%
                                 //out.print("Código: " + lista.get(num).getCod_vagas()+ "<br>");
                                 
                                 
                                 //out.print("Bolsa: " + lista.get(num).getBolsa()+ "<br>");
                                 //out.print("Semestre: " + lista.get(num).getSemestre()+ "<br>");
                                 //out.print("Curso: " + lista.get(num).getCurso()+ "<br>");
                                 //out.print("Conclusão: " + lista.get(num).getAno_conclusao()+ "<br>");%>
                            <!-- tipo da vaga -->
                            <span class="card-title ">
                               <%out.print(lista.get(num).getNome_vaga()+ "<br>");%>
                            </span>
                            <!-- descricao da vaga -->
                            <p><%out.print(lista.get(num).getDescricao()+ "<br> "+" Curso desejado: " + lista.get(num).getCurso() + ", semestre: " + lista.get(num).getSemestre() +"<br>"+ "Conclusão: " + lista.get(num).getAno_conclusao()+"<br>"+"Remuneração: " + lista.get(num).getBolsa());%></p>
                        </div>
                        <!-- link para se aplicar a vaga -->
                        <form action="ServIndex">
                            <%
                              String codigo_vagas = "";
                              codigo_vagas = lista.get(num).getCod_vagas();
                              System.out.println("index:"+codigo_vagas);
                            %>
                            <input type="hidden" value="<%=codigo_vagas%>" name="hdnCodigo_Vagas">
                            <div class="card-action ">
                                <button class="waves-effect waves-teal btn-flat deep-orange-text text-lighten-2" type="submit" >Aplicar-se</button>
                            </div>
                        </form>
                    </div>
                </div>
                <%
                       }

                    } catch (Exception e) {}
                %>  
                <!-- card-vaga -->
            </div>
        </div>
        <!-- fim cards -->
    </main>


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
