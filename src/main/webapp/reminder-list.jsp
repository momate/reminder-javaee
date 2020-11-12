
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reminders</title>
    </head>
    <body>

        <%@include file="header.jsp" %>

        <br>
        <div class="reminders">
            <div class="container">
                <div class="col-md-12">

                    <h1 class="display-4 text-center">Reminders</h1>
                    <br>
                    <a class="btn btn-primary" role="button" href="<%= request.getContextPath()%>/add">Add Reminder</a>
                    <br>
                    <hr>

                    <div class="list-group">

                        <c:forEach var="r" items="${reminders}">                 

                            <a class="list-group-item list-group-item-action flex-column align-items-start ">
                                <div class="d-flex w-100 justify-content-between">
                                    <h5 class="mb-1"><c:out value="${r.getTitle()}"/></h5>
                                    <small href="#">Edit</small>
                                </div>
                                <p class="mb-1"><c:out value="${r.getDescription()}"/></p>
                                <small><c:out value="${r.getTargetDate()}"/></small>
                            </a>
                 </c:forEach>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
