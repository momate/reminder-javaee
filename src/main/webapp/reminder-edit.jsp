
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%@include file="header.jsp" %>

        <form method="post" action="edit" >

            <div class="col-md-6 col-md-offset-3">


                <div class="form-group">
                    <input type="text" id="title" value="${reminder.getTitle()}" name="title" required>
                </div>

                <div class="form-group">
                    <textarea name="description" id="description"><c:out value="${reminder.getDescription()}"/></textarea>
                </div>

                <div class="form-group">

                    <input type="date" id="date" name="date" value="${reminder.getTargetDate()}">
                </div>

                <input type="submit" value="Submit">


            </div>
        </form>
    </body>
</html>
