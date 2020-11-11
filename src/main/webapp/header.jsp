<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css"  href="header.css">
<header>
    <div class="navbar">
        <div class="inner-navbar">
            <div class="logo_container">
                <h1>Reminder App</h1>
            </div>

            <ul class="navigation">
                <a href="<%= request.getContextPath() %>/register"> <li >Sign Up</li></a>
                <a href="<%= request.getContextPath() %>/login"><li>Login</li></a>
            </ul>        
        </div>       
    </div>
</header>