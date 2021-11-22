<%-- 
    Document   : cria_vaga
    Created on : 21 de nov de 2021, 15:59:50
    Author     : carla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Candidatar-se</title>
    <!--JQuery-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/login.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
    <!--End Navbar-->
    <%
        String usuario = (String) session.getAttribute("USUARIO");
        String codUsuario = (String) session.getAttribute("COD");
        System.out.println("usuario: " + usuario);
    %>

    <main>
        <div class="container">
            <div class="col m6">
                <!-- titulo -->
                <br>
                <h5>
                    Tipo de vaga a ser cadastrada:
                </h5>
                <form action="ServVaga" method="POST">
                    <input type="hidden" value="<%=codUsuario%>" name="hdnCod">
                    <!-- select -->
                    <div class="input-field col s12">
                        <select name="tipo_vaga">
                            <option value="" disabled selected>Tipo</option>
                            <option value="Estagio">Estágio</option>
                            <option value="Trainee">Trainee</option>
                            <option value="Servicos">Serviços</option>
                            <option value="Cargos especificos">Cargos específicos</option>
                        </select>
                    </div>
                    <h5>Descrição da Vaga:</h5>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="vaga" type="text" class="validate" name="nome_vaga">
                            <label for="first_name">Nome vaga</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <textarea id="descricao" class="materialize-textarea" name = "descricao"></textarea>
                            <label for="textarea1">Descrição vaga/requisitos</label>
                        </div>
                    </div>
                    <div class="row">
                         <div class="input-field col s4">
                            <input id="bolsa" type="text" class="validate" name="bolsa">
                            <label for="first_name">Bolsa/Remuneração</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="Semestre" type="text" class="validate" name="semestre">
                            <label for="first_name">Semestre desejado</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="ano_conclusao" type="date" class="validate" name="ano_conclusao">
                            <label for="first_name">Ano de conclusão de curso:</label>
                        </div>

                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="curso" type="text" class="validate" name="curso">
                            <label for="first_name">Curso</label>
                        </div>
                    </div>
                    <!-- botão -->
                    <button class="btn waves-effect waves-light right deep-orange lighten-2" type="submit" name="action">Próximo
                        <i class="material-icons right">send</i>
                      </button>
                    <!-- fim botao-->
                    <br>
                    <br>
                    <br>
                </form>

            </div>


        </div>
    </main>

    <!--Footer-->

    <footer class="page-footer grey darken-4 center">
        © 2021 Copyright Text
    </footer>
    <!--End Footer-->

    <script>
        $(document).ready(function() {
            $('select').formSelect();
        })
    </script>

</body>

</html>