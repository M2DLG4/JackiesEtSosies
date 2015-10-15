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
    <div class="row" style="background-color: #f4f3f8 ">
        <div class="col-md-3">
            <h2>${membre.prenom} ${membre.nom}</h2>
            <p>Sexe : ${membre.sexe}</p>
            <p>Ville : ${membre.ville}</p>
            <p>${membre.mail}</p>
        </div>
        <div class="col-md-3">
            <br/>
            <g:if test="${membre.urlPhoto.equals(null)}">
                <p><img src="/JackiesEtSosies/images/placeholder-membre.png" class="img-responsive"/></p>
            </g:if>
            <g:else>
                <p><img src="${membre.urlPhoto}" class="img-responsive"/></p>
            </g:else>
        </div>
        <g:if test="${membre.isSosie == true}">
        <div class="col-md-3">
            <br/>
            <p><img src="${membre.idStar.urlPhoto}" class="img-responsive"/></p>
        </div>
        <div class="col-md-3">
            <h3>Sosie de ${membre.idStar.prenom} ${membre.idStar.nom}</h3>
        </div>
        </g:if>
    </div>
    <br/><br/>
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