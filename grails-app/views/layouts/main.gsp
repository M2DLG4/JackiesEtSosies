<!DOCTYPE html>
<html>
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
    <link rel="apple-touch-icon" sizes="57x57" href="${resource(dir: 'images', file: 'apple-icon-57x57.png')}">
    <link rel="apple-touch-icon" sizes="60x60" href="${resource(dir: 'images', file: 'apple-icon-60x60.png')}">
    <link rel="apple-touch-icon" sizes="72x72" href="${resource(dir: 'images', file: 'apple-icon-72x72.png')}">
    <link rel="apple-touch-icon" sizes="76x76" href="${resource(dir: 'images', file: 'apple-icon-76x76.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-icon-114x114.png')}">
    <link rel="apple-touch-icon" sizes="120x120" href="${resource(dir: 'images', file: 'apple-icon-120x120.png')}">
    <link rel="apple-touch-icon" sizes="144x144" href="${resource(dir: 'images', file: 'apple-icon-144x144.png')}">
    <link rel="apple-touch-icon" sizes="152x152" href="${resource(dir: 'images', file: 'apple-icon-152x152.png')}">
    <link rel="apple-touch-icon" sizes="180x180" href="${resource(dir: 'images', file: 'apple-icon-180x180.png')}">
    <link rel="icon" type="image/png" sizes="192x192"  href="${resource(dir: 'images', file: 'android-icon-192x192.png')}">
    <link rel="icon" type="image/png" sizes="32x32" href="${resource(dir: 'images', file: 'favicon-32x32.png')}">
    <link rel="icon" type="image/png" sizes="96x96" href="${resource(dir: 'images', file: 'favicon-96x96.png')}">
    <link rel="icon" type="image/png" sizes="16x16" href="${resource(dir: 'images', file: 'favicon-16x16.png')}">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="stylesheet"
          href="${resource(dir: 'css', file: 'bootstrap-yeti.min.css')}"
          type="text/css">
    <link rel="stylesheet"
          href="${resource(dir: 'css', file: 'font-awesome.min.css')}"
          type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}"
          type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'timeline.css')}"
          type="text/css">
    <style>

    </style>
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <!-- The mobile navbar-toggle button can be safely removed since you do not need it in a non-responsive implementation -->
            <a class="navbar-brand" href="#"><img
                    src="${resource(dir: 'images', file: 'android-icon-36x36.png')}"> Jackie & Sosies
            </a>
        </div>
        <!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right col-md-3">
                <li>

                    <g:form class="form-edit" name="edition-form" url="[action:'index',controller:'recherche']">
                        <div class="input-group stylish-input-group">
                            <input type="text" class="form-control" name="text"
                                   placeholder="Rechercher un membre">
                            <span class="input-group-addon">
                                <button type="submit">
                                    <span class="fa fa-search"></span>
                                </button>
                            </span>
                        </div>
                    </g:form>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<div class="container">
    <g:if test="${flash.error}">
        <div class="alert alert-danger alert-dismissible fade in" style="display: block" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
            ${flash.error}
        </div>
    </g:if>
    <g:if test="${flash.message}">
        <div class="alert alert-success alert-dismissible fade in" role="alert" style="display: block">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
            ${flash.message}
        </div>
    </g:if>
    <div class="row profile">
        <div class="col-md-3">
            <div class="profile-sidebar">
                <!-- SIDEBAR USERPIC -->
                <div class="profile-userpic">
                    <g:if test="${session.getAttribute("user").urlPhoto.equals(null)}">
                        <p><img src="${resource(dir: 'images', file: 'placeholder-membre.png')}" class="img-responsive img-circle"/></p>
                    </g:if>
                    <g:else>
                        <p><img src="${session.getAttribute("user").urlPhoto}" class="img-responsive img-circle"/></p>
                    </g:else>
                </div>
                <!-- END SIDEBAR USERPIC -->
                <!-- SIDEBAR USER TITLE -->
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">
                        ${session.getAttribute("user").prenom} ${session.getAttribute("user").nom}
                    </div>
                    <div class="profile-usertitle-job">
                        <g:if test="${session.getAttribute("user").isSosie}">
                            <p>Sosie de ${session.getAttribute("user").idStar.prenom} ${session.getAttribute("user").idStar.nom}</p>
                        </g:if>
                    </div>
                </div>
                <!-- END SIDEBAR USER TITLE -->
                <!-- SIDEBAR MENU -->
                <div class="profile-usermenu">
                    <ul class="nav">
                        <g:set var="pageId" value="${params.controller}-${params.action}"/>
                        <li <g:if test="${pageId == 'membre-profil'}"> class="active"</g:if>>
                            <g:link controller="membre" action="profil" id="${session.getAttribute("user").id}">
                                <i class="fa fa-user"></i>
                                Profil
                            </g:link>
                        </li>
                        <li <g:if test="${pageId == 'post-news'}"> class="active"</g:if>>
                            <g:link controller="post" action="news">
                                <i class="fa fa-newspaper-o"></i>
                                Fil d'actualités
                            </g:link>
                        </li>
                        <li>

                            <g:link controller="membre" action="deconnexion">
                                <i class="fa fa-sign-out"></i>
                                Déconnexion
                            </g:link>
                        </li>

                    </ul>
                </div>
                <!-- END MENU -->
            </div>
        </div>

        <div class="col-md-9">
            <g:layoutBody/>
        </div>

    </div>
</div>

<script src="${resource(dir: 'js', file: 'jquery-1.11.3.min.js')}"></script>
<script src="${resource(dir: 'js', file: 'bootstrap.min.js')}"></script>
<script src="${resource(dir: 'js', file: 'wall.js')}"></script>

</body>
</html>