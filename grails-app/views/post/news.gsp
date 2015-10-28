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
<div class="row">

    <div class="row" id="new_message">
        <g:form accept-charset="UTF-8" url="[action:'sharedPost',controller:'post']">
            <div class="col-md-10 col-md-offset-1 well">
                <textarea class="form-control" name="message"
                          placeholder="Tapez votre message"
                          rows="5" required></textarea>

                <div style="margin-top:10px">
                    <h6 class="pull-right "><span
                            class="nb_carac_remaining">320</span> caractères restants
                    </h6>

                    <button id="post-message" class="btn btn-info"
                            type="submit">Poster</button>
                </div>
                <br /> ${error}
            </div>
        </g:form>
    </div>
    <div class="col-md-9" id="timeline">
        <h3>Votre fil d'actualités :</h3>
        <br>
        <div class="qa-message-list" id="wallmessages">
            <g:if test="${posts}">
                <g:each var="post" in="${posts }">
                    <div class="message-item" id="m16">
                        <div class="message-inner">
                            <div class="message-head clearfix">
                                <div class="avatar pull-left">
                                    <g:if test="${post.getMembre().urlPhoto.equals(null)}">
                                        <p><img src="${resource(dir: 'images', file: 'placeholder-membre.png')}" class="img-responsive img-circle"/></p>
                                    </g:if>
                                    <g:else>
                                        <p><img src="${post.getMembre().urlPhoto}" class="img-responsive img-circle"/></p>
                                    </g:else>
                                </div>
                                <g:if test="${post.getMembre().getId() == session.getAttribute("user").getId()}">
                                    <g:link controller="post" action="supprimer" id="${post.getId()}">
                                        <span class="glyphicon glyphicon-remove" style="color: black;float:right"></span>
                                    </g:link>
                                </g:if>
                                <div class="user-detail">
                                    <h5 class="handle">
                                        <g:link controller="membre" action="profil" id="${post.getMembre().id}">
                                            ${post.getMembre().prenom} ${post.getMembre().nom}
                                        </g:link>
                                    </h5>
                                    <div class="post-meta">
                                        <div class="asker-meta">
                                            <span class="qa-message-what"></span>
                                            <span class="qa-message-when">
                                                <span class="qa-message-when-data">le ${post.getDate().format( 'dd MMM yyyy hh:mm' )}</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="qa-message-content">
                                ${post.getMessage()}
                            </div>
                        </div>
                    </div>
                </g:each>
            </g:if>
            </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
