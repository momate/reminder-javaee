<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>

        <%@include file="header.jsp" %>


    <div class="container">
        <br>
        <div class="row justify-content-center">
        
                            <div class="col-md-8">
                                <div class="card">
                                    <div class="card-header text-center"><h2>Login</h2></div>
                                    <div class="card-body">
        
                                        <form class="form-horizontal" method="post" action="login">

                                            <div class="form-group">
                                                <label for="username" class="cols-sm-2 control-label">Username</label>
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control" name="username" id="username" placeholder="Enter your Username" required/>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="password" class="cols-sm-2 control-label">Password</label>
                                                <div class="cols-sm-10">
                                                    <div class="input-group">
                                                        <input type="password" class="form-control" name="password" id="password" placeholder="Enter your Password" required/>
                                                    </div>
                                                </div>
                                            </div>
                      
                                            <div class="form-group ">
                                                <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Login</button>
                                            </div>
                                            
                                        </form>
                                    </div>
        
                                </div>
                            </div>
                        </div>
        </div>  

    </body>
</html>