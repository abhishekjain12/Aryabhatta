<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="org.BG.profileDetails" %>
<%@ page errorPage="Alert/Error-found.html" %>

<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="res/cssfile.css" type="text/css" >
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="res/profile-css.css" type="text/css">
    <script type="text/javascript" src="res/jsfile.js"></script>

    <script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script type="text/javascript" src="res/chart.js"></script>

</head>
<body>

<% profileDetails pD = new profileDetails();
    String username = (String) session.getAttribute("user");
    pD.fetchDetails(username);
%>

<div class="nav-fixed">
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="logo">BrainGames</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a onclick="games()">Games</a></li>
                <li><a href="About-Us.html">About us</a></li>
                <li><a href="sign-out.jsp" class="btn-large hoverable red">Sign out</a></li>
            </ul>
        </div>
    </nav>
</div>

<div id="right-tab" class="row tab">
    <a class="btn-large hoverable" onclick="games()">play games<i class="material-icons right">&#xE5C8;</i></a>
</div>

<div id="left-tab" class="row tab left" style="display: none">
    <a class="btn-large hoverable" onclick="profile()">Back to profile<i class="material-icons left">&#xE5C4;</i></a>
</div>

<div id="profile">

    <div id="detail" class="card">
        <div class="row">
            <div class="col quarter ">
                <div class="user-image">
                    <img src="../res/user-img/<%=username%>.jpg" class="user-photo">
                </div>
            </div>
            <div class="col half-quarter">
                <h1><%=pD.getName() %>
                    <a href="update-details.html"><i class="material-icons right hoverable">&#xE3C9;</i></a>
                </h1>
                <div class="divider"></div>
                <a class="in-block"><i class="material-icons left">&#xE853;</i> <%=username%></a>
                <span class="v-divider"></span>
                <a class="in-block"><i class="material-icons left">&#xE0BE;</i> <%=pD.getEmail()%></a>
                <span class="v-divider"></span>
                <a class="in-block"><i class="material-icons left">&#xE8F6;</i> <%=pD.getBirthday()%></a>
                <span class="v-divider"></span>
                <a class="in-block"><i class="material-icons left">&#xE87C;</i> <%=pD.getGender()%></a>
                <span class="v-divider"></span>
                <a class="in-block"><i class="material-icons left">&#xE8F9;</i> <%=pD.getWork()%></a>
                <span class="v-divider"></span>
                <a class="in-block"><i class="material-icons left">&#xE01D;</i> <%=pD.getRank()%></a>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col quarter">
            <div class="card">
                <span id="problem_solving" class="chart" data-percent="<%=pD.getProbSolG()%>"><span class="percent"></span></span>
                <a class="btn green">Problem Solving</a>
                <script type="text/javaScript">
                    $(function() {
                        $('.chart#problem_solving').easyPieChart({
                            barColor: "#4CAF50",
                            trackColor:	"#f2f2f2",
                            scaleColor: false,
                            lineCap: "round",
                            lineWidth: "25",
                            size: "200",
                            easing: 'easeOutBounce',
                            onStep: function(from, to, percent) {
                                $(this.el).find('.percent').text(Math.round(percent));
                            }
                        });
                        var chart = window.chart = $('.chart').data('easyPieChart');
                        $('.js_update').on('click', function() {
                            chart.update(Math.random()*200-100);
                        });
                    });
                </script>
            </div>
        </div>
        <div class="col quarter">
            <div class="card">
                <span id="memory" class="chart" data-percent="<%=pD.getMemoryG()%>"><span class="percent"></span></span>
                <a class="btn purple">Memory</a>
                <script type="text/javaScript">
                    $(function() {
                        $('.chart#memory').easyPieChart({
                            barColor: "#8E44AD",
                            trackColor:	"#f2f2f2",
                            scaleColor: false,
                            lineCap: "round",
                            lineWidth: "25",
                            size: "200",
                            easing: 'easeOutBounce',
                            onStep: function(from, to, percent) {
                                $(this.el).find('.percent').text(Math.round(percent));
                            }
                        });
                        var chart = window.chart = $('.chart').data('easyPieChart');
                        $('.js_update').on('click', function() {
                            chart.update(Math.random()*200-100);
                        });
                    });
                </script>
            </div>
        </div>
        <div class="col quarter">
            <div class="card">
                <span id="focus" class="chart" data-percent="<%=pD.getFocusG()%>"><span class="percent"></span></span>
                <a class="btn red">Focus</a>
                <script type="text/javaScript">
                    $(function() {
                        $('.chart#focus').easyPieChart({
                            barColor: "#F44336",
                            trackColor:	"#f2f2f2",
                            scaleColor: false,
                            lineCap: "round",
                            lineWidth: "25",
                            size: "200",
                            easing: 'easeOutBounce',
                            onStep: function(from, to, percent) {
                                $(this.el).find('.percent').text(Math.round(percent));
                            }
                        });
                        var chart = window.chart = $('.chart').data('easyPieChart');
                        $('.js_update').on('click', function() {
                            chart.update(Math.random()*200-100);
                        });
                    });
                </script>
            </div>
        </div>
        <div class="col quarter">
            <div class="card">
                <span id="mental_agility" class="chart" data-percent="<%=pD.getMentalG()%>"><span class="percent"></span></span>
                <a class="btn">Mental Agility</a>
                <script type="text/javaScript">
                    $(function() {
                        $('.chart#mental_agility').easyPieChart({
                            barColor: "#0072ff",
                            trackColor:	"#f2f2f2",
                            scaleColor: false,
                            lineCap: "round",
                            lineWidth: "25",
                            size: "200",
                            easing: 'easeOutBounce',
                            onStep: function(from, to, percent) {
                                $(this.el).find('.percent').text(Math.round(percent));
                            }
                        });
                        var chart = window.chart = $('.chart').data('easyPieChart');
                        $('.js_update').on('click', function() {
                            chart.update(Math.random()*200-100);
                        });
                    });
                </script>
            </div>
        </div>
    </div>

</div>

<div id="games" style="display: none;margin-top: 75px">

    <div class="row">
        <h2 class="tab-title">Recommended for You
            <a href="#recommend-games" class="btn white black-text right"><i class="material-icons right">&#xE5DB;</i>view</a>
        </h2>
    </div>

    <div id="recommend-games" class="row">
        <div class="col quarter" style="display: <%=pD.getSizeCount()%>">
            <a href="Games/size-counts.html">
                <div class="card bg-green">
                    <img src="Games/size-counts-img/poster.png">
                    <div class="info">
                        <b><p class="g-title">Size Counts</p></b>
                        <p>Problem Solving</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col quarter" style="display: <%=pD.getLastCities()%>">
            <a href="Games/rtw.html">
                <div class="card bg-purple">
                    <img src="Games/rtw-img/Picture1.png">
                    <div class="info">
                        <b><p class="g-title">The Last Cities</p></b>
                        <p>Memory</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col quarter" style="display: <%=pD.getRushBack()%>">
            <a href="Games/rush-back.html">
                <div class="card bg-red">
                    <img src="Games/rush-back-img/Picture2.png">
                    <div class="info">
                        <b><p class="g-title">Rush Back</p></b>
                        <p>Focus</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col quarter" style="display: <%=pD.getTrueColor()%>">
            <a href="Games/true-color.html">
                <div class="card bg-blue">
                    <img src="Games/true-color-img/Picture2.png">
                    <div class="info">
                        <b><p class="g-title">True Color</p></b>
                        <p>Mental Agility</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col quarter" style="display: <%=pD.getCmplt()%>">
                <div class="card bg-green">
                    <h3>You have reached to maxmium level</h3>
                    <div class="info">
                        <b><p>Play games from <i class="material-icons right">&#xE5DB;</i></p></b>
                    </div>
                </div>
        </div>
    </div>

    <div class="row">
        <h2 class="tab-title">All Games
            <a href="#all-games" class="btn white black-text right"><i class="material-icons right">&#xE5DB;</i>view</a>
        </h2>
    </div>

    <div id="all-games" class="row">
        <div class="col quarter">
            <a href="Games/size-counts.html">
                <div class="card bg-green">
                    <img src="Games/size-counts-img/poster.png">
                    <div class="info">
                        <b><p class="g-title">Size Counts</p></b>
                        <p>Problem Solving</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col quarter">
            <a href="Games/rtw.html">
                <div class="card bg-purple">
                    <img src="Games/rtw-img/Picture1.png">
                    <div class="info">
                        <b><p class="g-title">The Last Cities</p></b>
                        <p>Memory</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col quarter">
            <a href="Games/rush-back.html">
                <div class="card bg-red">
                    <img src="Games/rush-back-img/Picture2.png">
                    <div class="info">
                        <b><p class="g-title">Rush Back</p></b>
                        <p>Focus</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col quarter">
            <a href="Games/true-color.html">
                <div class="card bg-blue">
                    <img src="Games/true-color-img/Picture2.png">
                    <div class="info">
                        <b><p class="g-title">True Color</p></b>
                        <p>Mental Agility</p>
                    </div>
                </div>
            </a>
        </div>
    </div>

</div>

<div class="divider"></div>

<footer>
    <p>Copyright &copy; 2017 <a href="/">BrainGames</a> | All rights Reserved</p>
</footer>

</body>
</html>