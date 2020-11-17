
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>

        <%@include file="header.jsp" %>

        <div class="container">
            <br>
          <div class="row justify-content-center">
                              <div class="col-lg-10">
                                  <div class="card">
                                      <div class="card-header text-center"><h2>Edit Reminder</h2></div>
                                      <div class="card-body">
          
                                          <form class="form-horizontal" method="post" action="edit">
          
                                              <div class="form-group">
                                                  <div class="cols-sm-10">
                                                      <div class="input-group">
                                                          <input type="text" class="form-control" name="title" id="title" value="${reminder.getTitle()}" />
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="form-group">
                                                  <div class="cols-sm-10">
                                                      <div class="input-group">
                                                          <textarea type="text" class="form-control" name="description" id="description"><c:out value="${reminder.getDescription()}"/></textarea>
                                                      </div>
                                                  </div>
                                              </div>
                                              <div class="form-group">
                                                  <div class="cols-sm-10">
                                                      <div class="input-group">
                                                          <input type="date" class="form-control" name="date" id="date" value="${reminder.getTargetDate()}" />
                                                      </div>
                                                  </div>
                                              </div>    
                                              
                                              <input type="hidden" name="userId" value="${loggedUserId}">
  
                                              <div class="form-group ">
                                                  <button type="submit" class="btn btn-primary btn-lg btn-block">Edit</button>
                                              </div>
                  
                                          </form>
                                      </div>
          
                                  </div>
                              </div>
                          </div>
          </div>       
    </body>
</html>
