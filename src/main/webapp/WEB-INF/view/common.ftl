<#import "/spring.ftl" as spring>
<#macro commonPage pageName>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="<@spring.url '/resources/uui/fonts/font-awesome/css/font-awesome.min.css'/>"/>
        <link rel="stylesheet"
              href="<@spring.url '/resources/uui/js/lib/components/DataTables-1.10.2/css/jquery.dataTables.css'/>"/>
        <link rel="stylesheet" href="<@spring.url '/resources/uui/bootstrap/css/bootstrap.css'/>">
        <link rel="stylesheet" href="<@spring.url '/resources/uui/bootstrap/css/bootstrap-grid.css'/>">
        <link href="<@spring.url '/resources/uui/bootstrap/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet"/>
        <link href="<@spring.url '/resources/uui/css/uui-all.css'/>" type="text/css" rel="stylesheet"/>
        <link href="<@spring.url '/resources/uui/css/lib/components/jquery.mCustomScrollbar.min.css'/>" type="text/css"
              rel="stylesheet"/>
        <link href="<@spring.url '/resources/uui/fonts/font-awesome/css/font-awesome.min.css'/>" type="text/css"
              rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/my/css/style.css'/>">
        <title>${pageName}</title>
    </head>
    <body>
    <header>
        <div class="uui-header">
            <nav>
                <div class="uui-responsive-header">
                    <div class="responsive-header">
                        <div class="responsive-toggle-box">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                        <div class="responsive-hide-menu">
                            <span></span>
                            <span></span>
                        </div>
                        <a href="<@spring.url'/'/>" class="responsive-brand-logo">
                            <span class="arrow fa fa-angle-left"></span>
                            <span class="logo">
                              <img src="<@spring.url '/resources/uui/images/ic_logo_UUi.svg'/>"
                                   alt=""/>
                          </span>
                            <span class="title">Navitex</span>
                        </a>
                        <ul class="responsive-header-tools nav navbar-nav">
                            <li class="responsive-header-icon search-icon">
                                <a href="#" onclick="return false">
                                    <i class="fa fa-search"></i>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="responsive-global-search">
                        <div class="search-header">
                            <div class="header-wrapper">
                                <div class="search-field">
                                    <label></label>
                                    <input type="search" class="uui-search" placeholder="Search"/>
                                </div>
                                <div class="hide-search">
                                    <span></span>
                                    <span></span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="responsive-menu">
                        <div class="menu-wrapper">
                            <div class="menu-scroll">
                                <ul class="nav navbar-nav">
                                    <li class="sub-menu profile-menu">
                                        <a href="#"><span>Profile</span></a>
                                        <ul class="sub">
                                            <li class="login"><a href="#"><span><@spring.message 'log_in'/></span></a>
                                            </li>
                                            <li><a href="?lang=ru"><span><@spring.message 'change_language'/> Ru</span></a>
                                            </li>
                                            <li><a href="?lang=en"><span><@spring.message 'change_language'/> En</span></a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <a href="<@spring.url'/'/>" class="brand-logo">
                  <span class="logo">
                      <img src="<@spring.url '/resources/uui/images/ic_logo_UUi.svg'/>"
                           alt=""/>
                  </span>
                    Navitex
                </a>
                <ul class="uui-header-tools nav navbar-nav">
                    <li class="uui-global-search">
                        <div class="search-field">
                            <label></label>
                            <input type="search" class="uui-search" placeholder="Search"/>
                        </div>
                    </li>

                    <li class="dropdown uui-profile-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <div class="profile-photo">
                                <img src="<@spring.url '/resources/uui/images/icons/no_photo.png'/>" alt=""/>
                            </div>
                        </a>
                        <div class="dropdown-menu" role="menu">
                            <span class="menu-arrow"></span>
                            <ul class="profile-links">
                                <li class="login"><a href="#popup1"
                                                     data-toggle="modal"><span><@spring.message 'log_in'/></span></a>
                                </li>
                                <li><a href="#"><span><@spring.message 'change_language'/> Ru</span></a></li>
                                <li><a href="#"><span><@spring.message 'change_language'/> En</span></a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
                <ul class="uui-navigation nav navbar-nav">
                    <li><a href="<@spring.url '/sensor/all/'/>"><span><@spring.message 'sensors'/></span></a></li>
                    <li><a href="<@spring.url '/sensor/all/'/>"><span><@spring.message 'create'/></span></a></li>
                    <li><a href="<@spring.url '/sensor/all/'/>"><span><@spring.message 'edit'/></span></a></li>
                </ul>
            </nav>
        </div>
    </header>
    <section>
        <div class="modal uui-modal fade" id="popup1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <form method="post" href="<@spring.url '/login/'/>">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Login</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                <span></span><span></span></button>
                        </div>
                        <div class="modal-body">
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="login"></label><@spring.message 'login'/> :
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="login" type="text" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label><@spring.message 'password'/> :
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="password" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" data-dismiss="modal"
                                    class="uui-button transparent"><@spring.message 'cancel'/></button>
                            <button type="submit" class="uui-button lime-green"><@spring.message 'login'/></button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <section>
        <div class="modal uui-modal fade" id="popup2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <form method="post" href="<@spring.url '/login/'/>">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Sensor</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                <span></span><span></span></button>
                        </div>
                        <div class="modal-body">
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="login"></label>Name :
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="login" type="text" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label>Co2:
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="number" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label>Co:
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="number" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label>Lpg:
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="number" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label>Ch4:
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="number" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label>Dust:
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="number" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label>Temp:
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="number" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label>Hum:
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="number" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                            <div class="row justify-content-center">
                                <div class="col-2"><label for="password"></label>Pressure:
                                </div>
                                <div class="col-6">
                                    <label>
                                        <input name="password" type="number" class="uui-form-element"/>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" data-dismiss="modal"
                                    class="uui-button transparent"><@spring.message 'cancel'/></button>
                            <button type="submit" class="uui-button lime-green">Create</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <div class="uui-main-container">
        <main>
            <#nested/>
        </main>
    </div>
    <footer class="fixed-bottom">
        <div class="uui-footer container-fluid">
            <div class="footer-logo-copyright">
                <div class="epam-logo">
                    <img src="<@spring.url '/resources/uui/images/Logo_Epam_Color.svg'/>"/>
                </div>
                <p class="copyright">© 2019 EPAM Systems. All Rights Reserved.</p>
            </div>
            <div class="footer-build">
                <p class="build">Build version v <span>2.0.0.1</span></p>
            </div>
        </div>
    </footer>
    <script src="<@spring.url '/resources/uui/js/lib/jquery-1.12.0.min.js'/>"></script>
    <script src="<@spring.url '/resources/uui/js/uui-core.min.js'/>"></script>
    <script src="<@spring.url '/resources/uui/js/uui-global-search.min.js'/>"></script>
    <script src="<@spring.url '/resources/uui/bootstrap/js/bootstrap.min.js'/>"></script>
    <script src="<@spring.url '/resources/uui/js/lib/components/jquery.mCustomScrollbar.concat.min.js'/>"></script>
    </body>
    </html>
</#macro>
