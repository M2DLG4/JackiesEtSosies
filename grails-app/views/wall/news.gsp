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

    /* Profile container */
    .profile {
        margin: 20px 0;
    }

    /* Profile sidebar */
    .profile-sidebar {
        padding: 20px 0 10px 0;
        background: #fff;
    }

    .profile-userpic img {
        float: none;
        margin: 0 auto;
        width: 50%;
        height: 50%;
    }

    .profile-usertitle {
        text-align: center;
        margin-top: 20px;
    }

    .profile-usertitle-name {
        color: #5a7391;
        font-size: 16px;
        font-weight: 600;
        margin-bottom: 7px;
    }

    .profile-usertitle-job {
        text-transform: uppercase;
        color: #5b9bd1;
        font-size: 12px;
        font-weight: 600;
        margin-bottom: 15px;
    }

    .profile-userbuttons {
        text-align: center;
        margin-top: 10px;
    }

    .profile-userbuttons .btn {
        text-transform: uppercase;
        font-size: 11px;
        font-weight: 600;
        padding: 6px 15px;
        margin-right: 5px;
    }

    .profile-userbuttons .btn:last-child {
        margin-right: 0px;
    }

    .profile-usermenu {
        margin-top: 30px;
    }

    .profile-usermenu ul li {
        border-bottom: 1px solid #f0f4f7;
    }

    .profile-usermenu ul li:last-child {
        border-bottom: none;
    }

    .profile-usermenu ul li a {
        color: #93a3b5;
        font-size: 14px;
        font-weight: 400;
    }

    .profile-usermenu ul li a i {
        margin-right: 8px;
        font-size: 14px;
    }

    .profile-usermenu ul li a:hover {
        background-color: #fafcfd;
        color: #5b9bd1;
    }

    .profile-usermenu ul li.active {
        border-bottom: none;
    }

    .profile-usermenu ul li.active a {
        color: #5b9bd1;
        background-color: #f6f9fb;
        border-left: 2px solid #5b9bd1;
        margin-left: -2px;
    }

    /* Profile Content */
    .profile-content {
        padding: 20px;
        background: #fff;
        min-height: 460px;
    }
    </style>
</head>

<body>
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
                <li class="active"><a href="../../../web-app">Static top <span
                        class="sr-only">(current)</span></a></li>
                <li><a href="../navbar-fixed-top/">Fixed top</a></li>
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
                    <img src="/JackiesEtSosies/static/images/placeholder-membre.png"
                         class="img-responsive img-circle" alt="">
                </div>
                <!-- END SIDEBAR USERPIC -->
                <!-- SIDEBAR USER TITLE -->
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">
                        Marcus Doe
                    </div>

                    <div class="profile-usertitle-job">
                        Developer
                    </div>
                </div>
                <!-- END SIDEBAR USER TITLE -->
                <!-- SIDEBAR BUTTONS -->
                <div class="profile-userbuttons">
                    <button type="button"
                            class="btn btn-success btn-sm">Follow</button>
                    <button type="button"
                            class="btn btn-danger btn-sm">Message</button>
                </div>
                <!-- END SIDEBAR BUTTONS -->
                <!-- SIDEBAR MENU -->
                <div class="profile-usermenu">
                    <ul class="nav">
                        <li class="active">
                            <a href="#">
                                <i class="glyphicon glyphicon-home"></i>
                                Overview</a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="glyphicon glyphicon-user"></i>
                                Account Settings</a>
                        </li>
                        <li>
                            <a href="#" target="_blank">
                                <i class="glyphicon glyphicon-ok"></i>
                                Tasks</a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="glyphicon glyphicon-flag"></i>
                                Help</a>
                        </li>
                    </ul>
                </div>
                <!-- END MENU -->
            </div>
        </div>

        <div class="col-md-9" id="timeline">
            <h3 class="text-center">Découvrez ce que vos amis et sosies préférés partagent !</h3>
            <br>
            <div class="row" id="new_message">
                <form accept-charset="UTF-8" action="" method="POST">
                <div class="col-md-10 col-md-offset-1 well">
                    <textarea class="form-control" name="new_message" placeholder="Type in your message" rows="5"></textarea>
                    <div style="margin-top:10px">
                        <h6 class="pull-right "><span class="nb_carac_remaining">320</span> characters remaining</h6>
                        <button class="btn btn-info" type="submit">Post New Message</button>
                    </div>
                </div>
                </form>
            </div>
            <div class="qa-message-list" id="wallmessages">
                <div class="message-item" id="m16">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=Oleg+Kolesnichenko"><img src="/JackiesEtSosies/static/images/placeholder-membre.png" class="img-circle"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">Oleg Kolesnichenko</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Jan 21</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=Oleg+Kolesnichenko">Oleg Kolesnichenko</a></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="qa-message-content">
                            Yo!
                        </div>
                    </div></div>

                <div class="message-item" id="m9">
                    <div class="message-inner">
                        <div class="message-head clearfix">
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=amiya"><img src="/JackiesEtSosies/static/images/placeholder-membre.png"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">amiya</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Nov 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=amiya">amiya</a></span>
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
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=russell"><img src="/JackiesEtSosies/static/images/placeholder-membre.png"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">russell</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 25, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=russell">russell</a></span>
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
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=juggornot"><img src="/JackiesEtSosies/static/images/placeholder-membre.png"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">juggornot</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=juggornot">juggornot</a></span>
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
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=one_eyed"><img src="/JackiesEtSosies/static/images/placeholder-membre.png"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">one_eyed</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=one_eyed">one_eyed</a></span>
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
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=muboy"><img src="/JackiesEtSosies/static/images/placeholder-membre.png"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">muboy</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=muboy">muboy</a></span>
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
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=monu"><img src="/JackiesEtSosies/static/images/placeholder-membre.png"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">monu</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=monu">monu</a></span>
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
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=Fynn"><img src="/JackiesEtSosies/static/images/placeholder-membre.png"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">Fynn</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=Fynn">Fynn</a></span>
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
                            <div class="avatar pull-left"><a href="./index.php?qa=user&qa_1=admin"><img src="/JackiesEtSosies/static/images/placeholder-membre.png"></a></div>
                            <div class="user-detail">
                                <h5 class="handle">admin</h5>
                                <div class="post-meta">
                                    <div class="asker-meta">
                                        <span class="qa-message-what"></span>
                                        <span class="qa-message-when">
                                            <span class="qa-message-when-data">Oct 24, 2013</span>
                                        </span>
                                        <span class="qa-message-who">
                                            <span class="qa-message-who-pad">by </span>
                                            <span class="qa-message-who-data"><a href="./index.php?qa=user&qa_1=admin">admin</a></span>
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
</body>
</html>
