<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css"  href="header.css">
<header>
    <div class="navbar">
        <div class="inner-navbar">
            <div class="logo_container">
                <h1> <a class="index" href="index.jsp" target="target">Reminder App <a/></h1>
            </div>

            <ul class="navigation">

                <c:if test="${not empty loggedUserId}">
                    <a><li> Hi <i><c:out value="${loggedUsername}"/></i></li></a>
                    <a href="<%= request.getContextPath()%>/logout"><li>Log Out</li></a>      
                        </c:if>
                        <c:if test="${empty loggedUserId}">
                    <a href="register.jsp"> <li>Sign Up</li></a>             
                    <a href="login.jsp"><li>Login</li></a>
                        </c:if>

            </ul>        
        </div>       
    </div>
</header>