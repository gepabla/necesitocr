<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!doctype html>

<html xmlns:ng="http://angularjs.org" class="ng-app:necesitocr" id="ng-app" ng-app="necesitocr">
	<head>
	    <meta charset="utf-8">
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
		<link rel="SHORTCUT ICON" href="resources/images/favicon.ico" type="image/x-icon" />
	    <c:import url="/WEB-INF/views/css.jsp"></c:import>		   	    
	    
	    <!--[if lte IE 8]>
	    	<meta http-equiv="X-UA-Compatible" content="IE=edge" >
			<script src="resources/js/ie-shiv.js"></script>
			<script src="resources/js/json3.min.js"></script>
		<![endif]-->
		
		<c:import url="/WEB-INF/views/javascript.jsp"></c:import>
		
	</head>
	
	<body>
		
		<c:import url="/WEB-INF/views/header.jsp"></c:import>
		
		<div class="general-view">
		    <div ng-view class="container-fluid general-container"></div>
		</div>
		<c:import url="/WEB-INF/views/footer.jsp"></c:import>
	</body>
	
	
</html>