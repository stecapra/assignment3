<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ attribute name="title" fragment="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/partials/layout" %>

<html>
  <head>
  	<title>Assignment 3 <jsp:invoke fragment="title"></jsp:invoke></title>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <sb:head/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" />
  </head>
  <body>
  	<layout:navbar/>
  	
  	<main role="main" class="container">
      
	    <div id="body">
	    
	    <s:actionmessage theme="bootstrap"/>
	      <s:actionerror theme="bootstrap"/>
	      <s:fielderror theme="bootstrap"/>
	      
	      <div class="container">      
	        <jsp:doBody/>
	      </div>
	      
	    </div>
	    
	</main>
    
    <layout:footer/>
    
  </body>
</html>