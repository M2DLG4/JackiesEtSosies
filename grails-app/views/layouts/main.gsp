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
        </div>
    </div>

    <script src="${resource(dir: 'js', file: 'jquery-1.11.3.min.js')}"></script>
    <script src="${resource(dir: 'js', file: 'bootstrap.min.js')}"></script>
    <script src="${resource(dir: 'js', file: 'search.js')}"></script>
</body>
</html>
