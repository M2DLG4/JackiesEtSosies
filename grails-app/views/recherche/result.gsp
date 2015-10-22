<!DOCTYPE html>
<html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta name="layout" content="main"/>
</head>

<body>

<h3>Resultats de la recherche
    <span class="pull-right">${resultatRecherche.size()} résultat(s)</span>
</h3>

<hr>
<div class="row">
<g:each var="membre" in="${resultatRecherche}">
    <div class="col-md-6 well well-sm">
        <div class="col-md-4">

            <g:if test="${membre.urlPhoto && membre.urlPhoto.size() > 0}">
                <img src="${membre.urlPhoto}" class="img-responsive img-circle" style="max-height: 100px;"/>
            </g:if>
            <g:else>
                <img src="/JackiesEtSosies/images/placeholder-membre.png" class="img-responsive img-circle"/>
            </g:else>
        </div>
        <div class="col-md-8">
            <p class="profile-usertitle-name">
                ${membre.prenom}
                ${membre.nom}
            </p>
            <g:if test="${membre.isSosie}">
                Sosie de ${membre.idStar.prenom} ${membre.idStar.nom}
            </g:if>
            <br>
            <br>

            <g:link controller="membre" action="profil" id="${membre.id}" class="btn btn-info btn-sm pull-right">
                Visiter le profil
            </g:link>
        </div>
    </div>
</g:each>
</div>
</body>
</html>