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
    <link rel="stylesheet" href="css/style.css">
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
    <%
        String codVagas = (String) session.getAttribute("CODVAGAS");
    %>
        
    <main>
        <div class="container s12 m6" id="form_candidatar">
            
            <!-- descrição vaga a se candidatar -->
            <h4>Vaga: </h4>
            
              <!-- Dados do candidato -->
              <form action="ServCandidato" method="POST">
                <input type="hidden" value="<%=codVagas%>" name="Codigo_Vagas">
                <div class="row s12">
                    <div class="input-field col m6">
                        <input  id="nome" type="text" class="validate" name="nome" required>
                        <label for="first_name">Nome</label>
                    </div>

                    <div class="input-field col s6">
                        <i class="material-icons prefix">phone</i>
                        <input id="icon_telephone" type="tel" class="validate" name="contato" required>
                        <label for="icon_telephone">Contato</label>
                      </div>
                </div>

                <div class="file-field input-field">
                    <p>Anexar currículo em formato PDF</p>
                    <div class="btn deep-orange lighten-2">
                      <span>Arquivo</span>
                      <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  
                  <button class="btn waves-effect waves-light right deep-orange lighten-2" type="submit" name="action">Enviar
                    <i class="material-icons right">send</i>
                  </button>
            </form>
        </div>

    </main>

     <!--Footer-->
    <footer class="page-footer grey darken-4 center ">
        © 2021 Copyright Text
    </footer>
    <!--fim Footer-->
        
</body>
</html>