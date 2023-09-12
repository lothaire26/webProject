<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/loginReg.css" >
    <title>Sign up</title>
    <link rel="icon" href="../img/netflix_PNG15.png" />
    <style>
      
    </style>
    <script>
      function checkPasswords() {
        var password = document.getElementById("inputPassword").value;
        var confirmPassword = document.getElementById("confirmPassword").value;
        var errorElement = document.getElementById("passwordError");
        if (password !== confirmPassword) {
          errorElement.innerHTML = "Passwords do not match. Please make sure both passwords are the same.";
          return false;
        }
        errorElement.innerHTML = "";
        return true;
      }
    </script>
  </head>
  <body>
    <div class="container mt-5">
      <div class="row">
        <div class="col-md-6 mx-auto">
          <div class="card">
            <div class="card-header">
              <h4>Sign Up</h4>
            </div>
            <div class="card-body">
              <form action="loginRegAppl.jsp" method="get" onsubmit="return checkPasswords();">
                <div class="form-group">
                  <label for="inputName">Username</label>
                  <input type="text" name="name" class="form-control" id="inputName" placeholder="Enter your name">
                </div>
                <div class="form-group">
                  <label for="inputEmail">E-mail address</label>
                  <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Enter your E-mail address">
                </div>
                <div class="form-group">
                  <label for="inputPassword">Password</label>
                  <input type="password" name="pass" class="form-control" id="inputPassword" placeholder="Enter a password">
                </div>
                <div class="form-group">
                  <label for="confirmPassword">Confirm password</label>
                  <input type="password" name="pass2" class="form-control" id="confirmPassword" placeholder="Confirm the password">
                  <div id="passwordError" class="error-message"></div>
                </div>
                <button type="submit" class="btn btn-primary btn-block" name="registration" value="Registrieren">Sign up</button>
                <br>
                <hr>
                <button type="submit"  class="btn btn-primary btn-block" name="gastlogin" value="Gast">Continue without account</button>
                <div> <br> Do you already have an account?  <a href="enregistrement.jsp">Sign in</a></div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
