
<%@page import="DTO.EmpresaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <!--fim Navbar-->


    <main>
        <div class="row center">
            <br>
        </div>
        <div class="container center">
            <div class="row">
                <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 100px 0px 100px; border: 1px solid #EEE;">

                    <!-- titulo -->
                    <div class="row">
                        <h4>LOGIN</h4>
                    </div>

                    <!-- dados do login -->
                    <form action="ServeLoginho" method="POST" class="col s12">
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="input_text" type="text" data-length="10" name="usuario">
                                <label for="input_text">Usuário</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12">
                                <input id="password" type="password" class="validate" name="senha">
                                <label for="password">Senha</label>
                            </div>
                        </div>

                        <!-- botões -->
                        <button type="submit" name="btnLogin" class="waves-effect waves-light btn deep-orange lighten-2"><!--<a href="pag_inicial_empresa.html">--></a> Entrar</button>

                        <div class="row cadastre">
                            <label style='float: right;'>
                                <a class='' href="cadastroUsuario.html "><b>Cadastre-se</b></a>
                            </label>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>

    <!--Footer-->
    <footer class="page-footer grey darken-4 center">
        © 2021 Copyright Text
    </footer>
    <!--fim Footer-->

</body>

</html>