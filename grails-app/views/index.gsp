<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Jackies et Sosies</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${resource(dir: 'css', file: 'bootstrap-yeti.min.css')}"
          type="text/css">
    <link rel="stylesheet"
          href="${resource(dir: 'css', file: 'font-awesome.min.css')}"
          type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}"
          type="text/css">
    <style>
    body.parallax-index {
        background-color: #444;
        background: url(${resource(dir: 'images', file: 'index-background.jpg')});
        background-size: 31%;
    }
    </style>
</head>

<body class="parallax-index">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <!-- The mobile navbar-toggle button can be safely removed since you do not need it in a non-responsive implementation -->
            <a class="navbar-brand" href="#">Jackie & Sosies</a>
        </div>
        <!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/" class="active">Connexion / Inscription</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<!-- Static navbar -->
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-haspopup="true"
                       aria-expanded="false">Dropdown <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../navbar/">Default</a></li>
                <li class="active"><a href="./">Static top <span
                        class="sr-only">(current)</span></a></li>
                <li><a href="../navbar-fixed-top/">Fixed top</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<div class="container">

    <!-- Main component for a primary marketing message or call to action -->
    <div class="jumbotron">
        <h3>Bienvenue sur Jackie & Sosies Network !</h3>

        <p style="font-size:0.98em;">
            La communauté de sosies et leurs adminirateurs vous souhaitent une agréable visite dès lors que vous vous serez inscrit !
        </p>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row-fluid user-row">
                        Connexion
                    </div>
                </div>

                <div class="panel-body">
                    <g:form class="form-signin" name="connexion-form" url="[action:'list',controller:'book']">
                        <fieldset>
                            <label class="panel-login">
                                <div class="login_result"></div>
                            </label>
                            <input class="form-control" placeholder="Email"
                                   id="username" type="email">
                            <input class="form-control" placeholder="●●●●●●●●"
                                   id="password" type="password">
                            <br></br>
                            <input class="btn btn-lg btn-success btn-block"
                                   type="submit" id="login" value="Se connecter">
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row-fluid user-row">
                        Inscription
                    </div>
                </div>

                <div class="panel-body">
                    <g:form class="form-signin" name="inscription-form" url="[action:'list',controller:'book']">
                        <fieldset>
                            <label class="panel-login">
                                <div class="login_result"></div>
                            </label>
                            <input class="form-control" placeholder="Nom"
                                   name="nom" type="text">
                            <input class="form-control" placeholder="Prenom"
                                   name="nom" type="text">
                            <input class="form-control" placeholder="●●●●●●●●"
                                   name="mdp" type="password">
                            <input class="form-control" placeholder="Email"
                                   name="mail" type="email">
                            <input class="form-control" placeholder="Votre ville"
                                   name="ville" type="text">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="isSosie"> Etes vous le sosie de quelqu'un d'autre ?
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="sexe" value="H"> Homme
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="sexe" value="F"> Femme
                                </label>
                            </div>
                            <br></br>
                            <input class="btn btn-lg btn-success btn-block"
                                   type="submit" id="login" value="S'inscrire">
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
    </div>

</div> <!-- /container -->

<script src="${resource(dir: 'js', file: 'jquery-1.11.3.min.js')}"></script>
<script src="${resource(dir: 'js', file: 'bootstrap.min.js')}"></script>
<script src="${resource(dir: 'js', file: 'TweenLite.min.js')}"></script>
<script src="${resource(dir: 'js', file: 'parallax.js')}"></script>
</body>
</html>
