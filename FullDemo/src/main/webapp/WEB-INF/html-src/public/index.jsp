<!DOCTYPE html>

<html data-ng-app="app">
	<head>
        <script src="resources/jquery/jquery.min.js"></script>
		<script src="resources/angular/angular.min.js"></script>
		<script src="resources/angular-route/angular-route.min.js"></script>
		<script src="resources/angular-translate/angular-translate.min.js"></script>
		<script src="resources/angular-translate-loader-static-files/angular-translate-loader-static-files.min.js"></script>
		<script src="resources/bootstrap/dist/js/bootstrap.js"></script>
		<script src="resources/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
        <script src="resources/angular-xeditable/dist/js/xeditable.min.js"></script>
		<script src="resources/custom/js/dist/main.js"></script>

		<link rel="stylesheet" type="text/css" href="resources/bootstrap/dist/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="resources/bootstrap/dist/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="resources/angular-xeditable/dist/css/xeditable.css">
		<link rel="stylesheet" type="text/css" href="resources/custom/css/styles.css">
		
		<title data-ng-bind="title">Student Library</title>
	</head>
	<body data-ng-controller="MainController">
		<div class="page-header">
		  <h1>Student Management ${successmessage}</h1>
		</div>
		
		<!-- MENU -->
		<div class="navbar navbar-default">
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
				  <li><a href='#/main'>Main</a></li>
				  <li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown">Student <span class="caret"></span></a>
				    <ul class="dropdown-menu">
				      <li><a href='#/student/search'>Search</a></li>
				    </ul>
				  </li>
				</ul>
				<ul class="nav navbar-nav navbar-right" data-ng-show="user">
				  <li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown">Welcome {{user.username}} <b class="caret"></b></a>
					<ul class="dropdown-menu">
					  <li><a data-ng-click="logout()">Logout</a></li>
					</ul>
				  </li>
				</ul>
			</div>
		</div>

        <!-- PARTIALS -->
		<div class="section">
			<div class="alert alert-danger" data-ng-show="error">{{error}}</div>
			<div data-ng-view></div>
		</div>
	</body>
</html>
