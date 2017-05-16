<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Restaurant</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


    <link rel="stylesheet" href="css/myFormCss.css">


</head>

<body>
<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="#login">Log In</a></li>
        <li class="tab"><a href="#signup">Sign Up</a></li>
    </ul>

    <div class="tab-content">
        <div id="login">
            <%--<h1>gondolle</h1>--%>

                <div id="logo">
                    <img src="img\gondola.png" width="50%" />
                </div>

                <form action="admin" method="post">

                <div class="field-wrap">
                    <label>
                        Login<span class="req">*</span>
                    </label>
                    <input name="login" type="text" required autocomplete="off"/>
                </div>

                <div class="field-wrap">
                    <label>
                        Password<span class="req">*</span>
                    </label>
                    <input name="password" type="password"required autocomplete="off"/>
                </div>

                <button class="button button-block"/>Log In</button>

            </form>

        </div>

        <div id="signup">
            <h1>Sign Up</h1>

            <form action="admin" method="post">
                <div class="field-wrap">
                    <label>
                        Login<span class="req">*</span>
                    </label>
                    <input name="login" type="text" required autocomplete="off" />
                </div>

                <div class="field-wrap">
                    <label>
                        Email Address<span class="req">*</span>
                    </label>
                    <input name="email" type="email" required autocomplete="off"/>
                </div>

                <div class="field-wrap">
                    <label>
                        Phone nomber<span class="req">*</span>
                    </label>
                    <input name="phone" type="tel" required autocomplete="off"/>
                </div>

                <div class="field-wrap">
                    <label>
                        Set A Password<span class="req">*</span>
                    </label>
                    <input name="password" type="password"required autocomplete="off"/>
                </div>

                <div class="field-wrap">
                    <label>
                        Confirm Password<span class="req">*</span>
                    </label>
                    <input name="confirm_password" type="password" required autocomplete="off"/>
                </div>

                <button type="submit" class="button button-block"/>Get Started</button>

            </form>

        </div>

    </div><!-- tab-content -->

</div> <!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/index.js"></script>

</body>
</html>
