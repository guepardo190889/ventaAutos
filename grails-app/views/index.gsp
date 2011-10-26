<!doctype html>
<html>
  <div style="visibility: hidden">
    <br />
    <a href="http://apycom.com/">Apycom jQuery Menus</a><br />
  </div>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
                <link type="text/css" href="menu.css" rel="stylesheet" />
        	<script type="text/javascript" src="jquery.js"></script>
                <script type="text/javascript" src="menu.js"></script>
	</head>
	<body>

          <div id="menu">
		<ul class="menu">
			<li><a href="#" class="parent"><span>Home</span></a>
				<div><ul>
					<li><a href="#" class="parent"><span>Sub Item 1</span></a>
						<div><ul>
							<li><a href="#" class="parent"><span>Sub Item 1.1</span></a>
								<div><ul>
								<li><a href="#"><span>Sub Item 1.1.1</span></a></li>
								<li><a href="#"><span>Sub Item 1.1.2</span></a></li>
								</ul></div>
							</li>
							<li><a href="#"><span>Sub Item 1.2</span></a></li>
							<li><a href="#"><span>Sub Item 1.3</span></a></li>
							<li><a href="#"><span>Sub Item 1.4</span></a></li>
							<li><a href="#"><span>Sub Item 1.5</span></a></li>
							<li><a href="#"><span>Sub Item 1.6</span></a></li>
							<li><a href="#" class="parent"><span>Sub Item 1.7</span></a>
								<div><ul>
								<li><a href="#"><span>Sub Item 1.7.1</span></a></li>
								<li><a href="#"><span>Sub Item 1.7.2</span></a></li>
								</ul></div>
							</li>
						</ul></div>
					</li>
					<li><a href="#"><span>Sub Item 2</span></a></li>
					<li><a href="#"><span>Sub Item 3</span></a></li>
				</ul></div>
			</li>
			<li><a href="#"><span>Product Info</span></a>
				<div><ul>
					<li><a href="#" class="parent"><span>Sub Item 1</span></a>
						<div><ul>
						<li><a href="#"><span>Sub Item 1.1</span></a></li>
						<li><a href="#"><span>Sub Item 1.2</span></a></li>
						</ul></div>
					</li>
					<li><a href="#" class="parent"><span>Sub Item 2</span></a>
						<div><ul>
						<li><a href="#"><span>Sub Item 2.1</span></a></li>
						<li><a href="#"><span>Sub Item 2.2</span></a></li>
						</ul></div>
					</li>
					<li><a href="#"><span>Sub Item 3</span></a></li>
					<li><a href="#"><span>Sub Item 4</span></a></li>
					<li><a href="#"><span>Sub Item 5</span></a></li>
					<li><a href="#"><span>Sub Item 6</span></a></li>
					<li><a href="#"><span>Sub Item 7</span></a></li>
				</ul></div>
			</li>
			<li><a href="#"><span>Help</span></a></li>
			<li class="last"><a href="#"><span>Contacts</span></a></li>
		</ul>
	</div>

		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="page-body" role="main">
			<h1>Welcome to Grails</h1>
			<p>Congratulations, you have successfully started your first Grails application! At the moment
			   this is the default page, feel free to modify it to either redirect to a controller or display whatever
			   content you may choose. Below is a list of controllers that are currently deployed in this application,
			   click on each to execute its default action:</p>

<!--			<div id="controller-list" role="navigation">
				<h2>Available Controllers:</h2>
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>
				</ul>
			</div>-->
		</div>
	</body>
</html>