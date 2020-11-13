<%-- 
    Document   : reminder-add
    Created on : Nov 11, 2020, 7:14:48 PM
    Author     : momate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>

        <h2>Sign Up</h2>
        <h5>Create Your Account</h5>

        <form method="post" action="add" >

            <div class="col-md-6 col-md-offset-3">

                <div class="form-group">
                    <input type="text" id="title" placeholder="Title" name="title" required>
                </div>

                <div class="form-group">
                    <textarea name="description" id="description" placeholder="Description.."></textarea>
                </div>

                <div class="form-group">

                    <input type="date" id="date" name="date">
                </div>

                <input type="hidden" name="userId" value="${loggedUserId}">

                <input type="submit" value="Submit">


            </div>
        </form>
    </body>
</html>
