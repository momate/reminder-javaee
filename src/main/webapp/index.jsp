<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <title>Reminder Homepage</title>
    </head>
    <body>

        <%@include file="header.jsp" %>

       <c:if test="${not empty loggedUserId}">
            <div class="container">
            <br>
            <div class="row">
                <div class="col-md-12 text-center">
                    <h1 class="display-3 mb-4">Welcome to Reminder!</h1>
                    <p class="lead">Manage your reminders.</p>
                    <hr>
                    <a class="btn btn-lg btn-primary mr-2" href="<%= request.getContextPath()%>/list">Here</a>
                    
                </div>
            </div>
        </div>
       </c:if>

        <c:if test="${ empty loggedUserId}">
             <div class="container">
            <br>
            <div class="row">
                <div class="col-md-12 text-center">
                    <h1 class="display-3 mb-4">Welcome to Reminder!</h1>
                    <p class="lead">Create your account and make your first reminder.</p>
                    <hr>
                    <a class="btn btn-lg btn-primary mr-2" href="<%= request.getContextPath()%>/register">Try it!</a>
                    
                </div>
            </div>
        </div>
       </c:if>

    
       
   
        
    </body>
</html>
