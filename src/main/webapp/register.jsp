<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Registration</title>

        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>

</head>
<body>

    <%@include file="header.jsp" %>


    <div class="container">
        <br>
        <div class="row justify-content-center">

            <div class="col-md-8">
                <div class="card">
                    <div class="card-header text-center"><h2>Create Your Account</h2></div>
                    <div class="card-body">
                        <h2 style="color:green;text-align:center;"><c:out value="${succes}"/></h2>

                            <form class="form-horizontal" method="post" action="register">

                            <div class="form-group">
                                <label for="name" class="cols-sm-2 control-label">Your First Name</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Enter your First Name" required />
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="confirm" class="cols-sm-2 control-label">Your Last Name</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Confirm your Last Name" required/>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">

                                <label for="email" class="cols-sm-2 control-label">Your Email</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="email" id="email" placeholder="Enter your Email" required/>
                                    </div>
                                    <p style="color:red;"><c:out value="${wrongEmail}"/></p>
                                </div>
                            </div>

                            <div class="form-group">

                                <label for="username" class="cols-sm-2 control-label">Username</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="username" id="username" placeholder="Enter your Username" required/>
                                    </div>
                                    <p style="color:red;"><c:out value="${wrongUsername}"/></p> 
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Password</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">
                                        <input type="password" class="form-control" name="password" id="password" placeholder="Enter your Password" required/>         
                                    </div>
                                    <p style="color:red;"><c:out value="${wrongPassword}"/></p>
                                </div>
                            </div>

                            <div class="form-group ">
                                <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Sign Up</button>
                            </div>
                            <div class="login-register text-center">
                                <p>Already have an account? <a href="login.jsp">LOGIN</a></p>

                            </div>
                            </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!---OLD-->



</body>
</html>