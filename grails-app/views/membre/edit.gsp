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
    <div class="jumbotron">
        <h3>Modification de votre Profil</h3>

        <br style="font-size:0.98em;">
            Ici vous pouvez modifier votre profil ! N'oubliez pas de rentrer votre ancien mot de passe ! <br/> xoxo

    </div>

    <div class="row">
        <div class="col-md-5">
            <div class="panel panel-default">
                <div class="panel-body">
                    <g:form class="form-edit" name="edition-form" url="[action:'edition',controller:'membre']">
                        <fieldset>
                            <input class="form-control" value="${session.getAttribute("user").nom}" name="nom" type="text">
                            <input class="form-control" value="${session.getAttribute("user").prenom}" name="prenom" type="text">
                            <input class="form-control" value="${session.getAttribute("user").ville}" name="ville" type="text">
                            <input class="form-control" value="${session.getAttribute("user").mail}" name="mail" type="email">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="isSosie" value=true
                                           <g:if test="${session.getAttribute("user").isSosie}">
                                               checked
                                           </g:if>
                                    > Êtes-vous le sosie de quelqu'un d'autre ?
                                </label>
                            </div>
                            <input class="form-control" placeholder="Rentrez l'URL de votre nouvelle image"
                                    <g:if test="${session.getAttribute("user").urlPhoto.size() > 0}">
                                        value="${session.getAttribute("user").urlPhoto}"
                                    </g:if>
                                   name="urlPhoto" type="text">
                            <input class="form-control" placeholder="Nouveau mot de passe"
                                   name="mdp" type="password">
                            ${validation}
                            <br/>
                            <g:actionSubmit class="btn btn-lg btn-success btn-block" action="edition" type="submit" id="edit" value="Valider" />
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
        <div class="col-md-5">
            <br/>
            <g:if test="${session.getAttribute("user").urlPhoto.size() > 0}">
                <img src="${session.getAttribute("user").urlPhoto}"
                     width="500" height="340"/>
            </g:if>
            <g:else>
                <img src="/JackiesEtSosies/images/placeholder-membre.png"
                     width="500" height="340"/>
            </g:else>

        </div>
    </div>

</body>
</html>