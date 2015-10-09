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
    <g:if test="${membre.urlPhoto.equals(null)}">
        <p><img src="/JackiesEtSosies/images/placeholder-membre.png" class="img-responsive"/></p>
    </g:if>
    <g:else>
        <p><img src="${membre.urlPhoto}" class="img-responsive"/></p>
    </g:else>
    <h2>${membre.prenom} ${membre.nom}</h2>
    <g:if test="${membre.isSosie == true}">
        <p>Sosie de ${membre.idStar}</p>
    </g:if>
    <p>Sexe : ${membre.sexe}</p>
    <p>Ville : ${membre.ville}</p>
    <p>Adresse mail : ${membre.mail}</p>
    <g:if test="${membre.id == session.getAttribute("user").id}">
        <g:link controller="membre" action="edit" class="btn btn-primary pull-right">
            Editer mon profil
        </g:link>
    </g:if>
    <g:else>
        <a href="" class="btn btn-success pull-right">Suivre ce membre</a>
    </g:else>
</body>
</html>