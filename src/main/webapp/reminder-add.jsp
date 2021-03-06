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
        <title>Add</title>
    </head>
    <body>
        <%@include file="header.jsp" %>

    
      <div class="container">
          <br>
        <div class="row justify-content-center">
                            <div class="col-lg-10">
                                <div class="card">
                                    <div class="card-header text-center"><h2>Add Reminder</h2></div>
                                    <div class="card-body">
        
                                        <form class="form-horizontal" method="post" action="add">
        
                                            <div class="form-group">
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control" name="title" id="title" placeholder="Title" required/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <textarea type="text" class="form-control" name="description" id="description" placeholder="Description" required></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <input type="datetime-local" class="form-control" name="date" id="date" required/>
                                                    </div>
                                                </div>
                                            </div>    
                                            
                                            <input type="hidden" name="userId" value="${loggedUserId}">

                                            <div class="form-group ">
                                                <button type="submit" class="btn btn-primary btn-lg btn-block">Add</button>
                                            </div>
                
                                        </form>
                                    </div>
        
                                </div>
                            </div>
                        </div>
        </div>       
    </body>
</html>
