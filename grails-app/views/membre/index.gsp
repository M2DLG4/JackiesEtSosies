<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="apple-touch-icon" sizes="57x57" href="/JackiesEtSosies/static/images/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="/JackiesEtSosies/static/images/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/JackiesEtSosies/static/images/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="/JackiesEtSosies/static/images/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/JackiesEtSosies/static/images/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="/JackiesEtSosies/static/images/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="/JackiesEtSosies/static/images/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="/JackiesEtSosies/static/images/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="/JackiesEtSosies/static/images/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192"  href="/JackiesEtSosies/static/images/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/JackiesEtSosies/static/images/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="/JackiesEtSosies/static/images/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/JackiesEtSosies/static/images/favicon-16x16.png">
    <link rel="shortcut icon" href="/JackiesEtSosies/static/images/favicon.ico" type="image/x-icon">
    <link rel="manifest" href="/JackiesEtSosies/static/images/manifest.json">
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
<body class="parallax-index" style="padding-top: 80px;">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <!-- The mobile navbar-toggle button can be safely removed since you do not need it in a non-responsive implementation -->

            <a class="navbar-brand" href="#"><img src="${resource(dir: 'images', file: 'android-icon-36x36.png')}"> Jackie & Sosies</a>
        </div>
        <!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/" class="active">Connexion / Inscription</a></li>
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
                    <g:form class="form-signin" name="connexion-form" url="[action:'connexion',controller:'membre']">
                        <fieldset>
                            <input class="form-control" placeholder="Email"
                                   name="mail" type="email">
                            <input class="form-control" placeholder="●●●●●●●●"
                                   name="mdp" type="password">
                            ${erreur}
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
                    <g:form class="form-signin" name="inscription-form" url="[action:'inscription',controller:'membre']">
                        <fieldset>
                            <input class="form-control" placeholder="Nom"
                                   name="nom" type="text">
                            <input class="form-control" placeholder="Prenom"
                                   name="prenom" type="text">
                            <input class="form-control" placeholder="Votre ville"
                                   name="ville" type="text">
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
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="isSosie" value="true"> Êtes-vous le sosie de quelqu'un d'autre ?
                                </label>
                            </div>
                            <input class="form-control" placeholder="Email"
                                   name="mail" type="email">
                            <input class="form-control" placeholder="●●●●●●●●"
                                   name="mdp" type="password">
                            ${validation}
                            <g:actionSubmit class="btn btn-lg btn-success btn-block" action="inscription" type="submit" id="login" value="S'inscrire" />
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
