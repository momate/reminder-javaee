
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reminders</title>
        <style>
            a.custom-card,
a.custom-card:hover {
  color: inherit;
}
        </style>
    </head>
    <body>

        <%@include file="header.jsp" %>

        <br>
        <div class="reminders">
            <div class="container">
                <div class="col-md-12">

                    <h1 class="display-4 text-center">Reminders</h1>
                    <br>
                    <a class="btn btn-primary" href="<%=request.getContextPath()%>/add" role="button">Add Reminder</a>
                    <br>
                    <hr>

                    <div class="list-group">

                        <c:forEach var="r" items="${reminders}">                 

                            
                        <a class="list-group-item list-group-item-action flex-column align-items-start ">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1"><c:out value="${r.getTitle()}"/></h5>
                                <div class="text-center"> 
                                <form method = "get" action="edit">
                                    <input type="hidden" name="reminderId" value="${r.getId()}" />
                                    <button type="submit" class="btn btn-outline-primary">Edit</button>
                                </form>
                                     <form method = "post" action="delete">
                                    <input type="hidden" name="reminderId" value="${r.getId()}" />
                                    <button type="submit" class="btn btn-outline-danger" onclick="confirmRemove(event)">Remove</button>
                                </form>
                                </div>
                            </div>
                            <p class="mb-1"><c:out value="${r.getDescription()}"/></p>
                            <small><c:out value="${r.getTargetDate()}"/></small>
                        </a>
                         </c:forEach>
                    </div>
                </div>
            </div>
        </div>
             <script>
            function confirmRemove(e) {
                var r = confirm("Sure?");
                if (r == false) {
                    e.preventDefault();
                    e.stopPropagation();
                }
            }
        </script>

    </body>
</html>
