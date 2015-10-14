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

                    <form>
                        <div class="input-group stylish-input-group">
                            <input type="text" class="form-control"
                                   placeholder="Search">
                            <span class="input-group-addon">
                                <button type="submit">
                                    <span class="fa fa-search"></span>
                                </button>
                            </span>
                        </div>
                    </form>

                </li>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<div class="container">
    <div class="row profile">
        <div class="col-md-3">
            <div class="profile-sidebar">
                <!-- SIDEBAR USERPIC -->
                <div class="profile-userpic">
                    <img src="/JackiesEtSosies/images/placeholder-membre.png"
                         class="img-responsive img-circle" alt="">
                </div>
                <!-- END SIDEBAR USERPIC -->
                <!-- SIDEBAR USER TITLE -->
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">
                        Marcus Doe
                    </div>

                    <div class="profile-usertitle-job">
                        Sosie de Johny Hallidey
                    </div>
                </div>
                <!-- END SIDEBAR USER TITLE -->
                <!-- SIDEBAR MENU -->
                <div class="profile-usermenu">
                    <ul class="nav">
                        <li>
                            <a href="#">
                                <i class="fa fa-user"></i>
                                Profil</a>
                        </li>
                        <li class="active">
                            <a href="#">
                                <i class="fa fa-newspaper-o"></i>
                                Actus</a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-calendar-check-o"></i>
                                Evenements</a>
                        </li>
                        <li>
                            <a href="/JackiesEtSosies/membre/deconnexion">
                                <i class="fa fa-sign-out"></i>
                                Déconnexion</a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-credit-card"></i>
                                Donation</a>
                        </li>
                    </ul>
                </div>
                <!-- END MENU -->
            </div>
        </div>

        <div class="col-md-9" id="timeline">
            <h3 class="text-center">Découvrez ce que vos amis et sosies préférés partagent !</h3>
            <br>
            <g:include controller="post" action="" />
            <div class="qa-message-list" id="wallmessages">
                <g:if test="${posts}">
                    <g:each var="c" in="${posts.sort { -it.date.getTime() } }">
                    <div class="message-item" id="m16">
                        <div class="message-inner">
                            <div class="message-head clearfix">
                                <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=Oleg+Kolesnichenko"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png"
                                        class="img-circle"></a></div>

                            <div class="user-detail">
                                <h5 class="handle">${c.membre.getNom()} ${c.membre.getPrenom()}</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">${c.getDate().format( 'dd MMM yyyy hh:mm' )}</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./membre/profil/">${c.membre.getNom()} ${c.membre.getPrenom()}</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            ${c.getMessage()}
                        </div>
                    </div>
                    </div>
                    </g:each>
                </g:if>
                <div class="message-item" id="m9">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=amiya"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png">
                            </a></div>

                            <div class="user-detail">
                                <h5 class="handle">amiya</h5>

                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Nov 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./index.php?qa=user&qa_1=amiya">amiya</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            Nice theme . Excellent one .
                        </div>
                    </div></div>

                <div class="message-item" id="m7">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=russell"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png">
                            </a></div>

                            <div class="user-detail">
                                <h5 class="handle">russell</h5>

                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 25, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./index.php?qa=user&qa_1=russell">russell</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            Nullam porta leo vitae ipsum feugiat viverra. In sed placerat mi. Nullam euismod, quam in euismod rhoncus, tellus velit posuere tortor, non cursus nunc velit et lacus.
                        </div>
                    </div></div>

                <div class="message-item" id="m6">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=juggornot"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png">
                            </a></div>

                            <div class="user-detail">
                                <h5 class="handle">juggornot</h5>

                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./index.php?qa=user&qa_1=juggornot">juggornot</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            Integer vitae arcu vitae ligula Cras vestibulum suscipit odio ac dapibus. In hac habitasse platea dictumst. Cras pulvinar erat et nunc fringilla, quis molestie
                        </div>
                    </div></div>

                <div class="message-item" id="m5">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=one_eyed"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png">
                            </a></div>

                            <div class="user-detail">
                                <h5 class="handle">one_eyed</h5>

                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./index.php?qa=user&qa_1=one_eyed">one_eyed</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            Nulla dui ante, pulvinar ac auctor vitae, sollicitudin et tortor. Cras vestibulum suscipit odio ac dapibus. In hac habitasse platea dictumst. Cras pulvinar erat et nunc fringilla, quis molestie diam pulvinar.
                        </div>
                    </div></div>

                <div class="message-item" id="m4">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=muboy"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png">
                            </a></div>

                            <div class="user-detail">
                                <h5 class="handle">muboy</h5>

                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./index.php?qa=user&qa_1=muboy">muboy</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus fermentum iaculis mi, non dapibus nulla eleifend sed. Etiam ac commodo leo. <br>
                            Donec non sem id tellus mattis convallis. Morbi dapibus nulla ac dui lacinia,
                        </div>
                    </div></div>

                <div class="message-item" id="m3">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=monu"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png">
                            </a></div>

                            <div class="user-detail">
                                <h5 class="handle">monu</h5>

                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./index.php?qa=user&qa_1=monu">monu</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            Suspendisse varius mi consectetur nulla volutpat, nec fermentum turpis vehicula. Curabitur dapibus odio mauris, vitae accumsan sapien auctor non. Duis tempus ante id nulla vestibulum mattis.
                        </div>
                    </div></div>

                <div class="message-item" id="m2">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=Fynn"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png">
                            </a></div>

                            <div class="user-detail">
                                <h5 class="handle">Fynn</h5>

                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./index.php?qa=user&qa_1=Fynn">Fynn</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            Nunc ante neque, feugiat at dictum ut, dignissim sed sapien. Pellentesque congue eu nisl sit amet cursus. Integer dapibus adipiscing metus ac vehicula. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        </div>
                    </div></div>

                <div class="message-item" id="m1">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a
                                    href="./index.php?qa=user&qa_1=admin"><img
                                        src="/JackiesEtSosies/images/placeholder-membre.png">
                            </a></div>

                            <div class="user-detail">
                                <h5 class="handle">admin</h5>

                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by</span>
                                            <span class="qa-message-who-data"><a
                                                    href="./index.php?qa=user&qa_1=admin">admin</a>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="qa-message-content">
                            Nunc ante neque, feugiat at dictum ut, dignissim sed sapien. Pellentesque congue eu nisl sit amet cursus. Integer dapibus adipiscing metus ac vehicula. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus fermentum iaculis mi, non dapibus nulla eleifend sed. Etiam ac commodo leo. Donec non sem id tellus mattis convallis. Morbi dapibus nulla ac dui lacinia,
                        </div>
                    </div></div>

            </div>
        </div>
    </div>
</div>
</div>
</div>

<script src="${resource(dir: 'js', file: 'jquery-1.11.3.min.js')}"></script>
<script src="${resource(dir: 'js', file: 'bootstrap.min.js')}"></script>
<script src="${resource(dir: 'js', file: 'wall.js')}"></script>
<script src="${resource(dir: 'js', file: 'search.js')}"></script>
</body>
</html>
