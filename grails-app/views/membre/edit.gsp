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
                                    <input type="checkbox" id="isSosie" onclick="afficher();" name="isSosie" value=true
                                           <g:if test="${session.getAttribute("user").isSosie}">
                                               checked
                                           </g:if>
                                    > Êtes-vous le sosie de quelqu'un d'autre ?
                                </label>
                            </div>
                            <p id="champ_cache">
                                Star dont vous êtes sosie :<br/>
                                <select class="form-control" name="star">
                                    <g:if test="${session.getAttribute("user").isSosie}">
                                        <option value=${session.getAttribute("user").idStar.id}>
                                            ${session.getAttribute("user").idStar.nom}
                                            ${session.getAttribute("user").idStar.prenom}
                                        </option>
                                    </g:if>
                                    <g:else>
                                        <option value="">Veuillez sélectionner une star</option>
                                    </g:else>
                                    <g:each var="star" in="${listStar}">
                                        <g:if test="${session.getAttribute("user").idStar?.id != star.id}">
                                            <option value=${star.id}>${star.nom} ${star.prenom}</option>
                                        </g:if>
                                    </g:each>
                                </select>
                            </p>

                            <g:javascript>
                                if (document.getElementById("isSosie").checked)
                                    document.getElementById("champ_cache").style.display = "block";
                                else
                                    document.getElementById("champ_cache").style.display = "none";

                                function afficher()
                                {
                                    var coche = document.getElementById("isSosie")

                                    if(coche.checked)
                                    {
                                        document.getElementById("champ_cache").style.display = "block";
                                    }
                                    else
                                    {
                                        document.getElementById("champ_cache").style.display = "none";
                                    }
                                }
                            </g:javascript>
                            <input class="form-control" placeholder="Rentrez l'URL de votre nouvelle image"
                                    <g:if test="${session.getAttribute("user").urlPhoto && session.getAttribute("user").urlPhoto.size() > 0}">
                                        value="${session.getAttribute("user").urlPhoto}"
                                    </g:if>
                                   name="urlPhoto" type="text">
                            <input class="form-control" placeholder="Nouveau mot de passe"
                                   name="mdp" type="password">
                            <br/>
                            <g:actionSubmit class="btn btn-lg btn-success btn-block" action="edition" type="submit" id="edit" value="Valider" />
                            <a  class="btn btn-lg btn-danger btn-block" href="#" data-toggle="modal" data-target="#myModal">
                                    <i class="fa fa-ban"></i>
                                    Supprimer votre compte</a>

                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">Suppression de votre compte</h4>
                                        </div>
                                        <div class="modal-body">
                                            Attention, si vous validez, votre compte sera supprimé définitivement.</br>
                                            Si vous ne souhaitez pas supprimer votre compte, cliquer sur Annuler

                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                                            <g:link controller="membre" action="suppression">
                                                <button type="button" class="btn btn-primary">Valider</button>
                                            </g:link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
        <div class="col-md-5">
            <br/>
            <g:if test="${session.getAttribute("user").urlPhoto && session.getAttribute("user").urlPhoto.size() > 0}">
                <img src="${session.getAttribute("user").urlPhoto}"/>
            </g:if>
            <g:else>
                <img src="${resource(dir: 'images', file: 'placeholder-membre.png')}" class="img-responsive"/>
            </g:else>

        </div>
    </div>

</body>
</html>