<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Reminder App</title>

        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>

</head>
<body>

    <%@include file="header.jsp" %>

    <div class="container">

        <h2>Sign Up</h2>
        <h5>Create Your Account</h5>
        <div class="col-md-6 col-md-offset-3">
            

            <form action="<%=request.getContextPath()%>/register" method="post">

                <div class="form-group">
                   <input type="text" class="form-control" id="uname" placeholder="First Name"
                                                                  name="firstName" required>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" id="uname" placeholder="Last Name"
                                                                 name="lastName" required>
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" id="username" placeholder="Username"
                                                                name="username" required>
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" placeholder="Password"
                                                                name="password" required>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>

            </form>
        </div>
    </div>

</body>
</html>