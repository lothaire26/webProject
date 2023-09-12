
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/loginReg.css" >
    <link rel="icon" href="../img/netflix_PNG15.png" />
    <title>Login Page</title>
   
    
  </head>
  
  <body>
    <div class="container mt-5">
      <div class="row">
        <div class="col-md-6 mx-auto">
          <div class="card">
            <div class="card-header">
              <h4>Sign in</h4>
            </div>
            <div class="card-body">
        <form action="loginRegAppl.jsp" method="get">
          <div class="form-group">
            <label for="username">Email address</label>
            <input type="text" name="emaillogin"  class="form-control" id="username" placeholder="Enter username">
          </div>
          <div class="form-group">
            <label for="password">Your password</label>
            <input type="password" class="form-control" id="password" name="passlogin" placeholder="Password">
          </div>
                 <button name="simpleLogin" value="simpleLogin" type="submit" class="btn btn-primary btn-block" >Se connecter</button>
                 
                <br> 
                <hr>
                 <button name="adminLogin" value="adminLogin" type="submit" class="btn btn-primary btn-block">continuer comme Admin</button>       
   
   <div class="help">
                <div>
                    <input type="radio" id="me">
                    <label for="me">Remember me</label>
                </div>
                    
                <a href="https://www.netflix.com/de/LoginHelp">Need help?</a>
            </div>
   
   <div > <br> You don't have an account?  <a href="../jsp/connection.jsp">Sign up here</a></div>
       <div class="help">
                

            
            <div class="connect">
                <p>This page is protected by Google reCAPTCHA to ensure you're not a robot. <span id="span02"> <a href="https://policies.google.com/privacy"> Learn more.</a></span></p>
            </div>
            </div>
           
        </form>
         </div>
          
        </div>
      </div>
            
      
    </div>
    </div>

      <footer>
            <div class="container-footer">
                <p>Questions? <a href="">Call 0800-761-4631</a></p>
    
                <div class="listas">
                    <ul>
                        <li><a href="">Frequently Asked Questions</a></li>
                        <li><a href="">Corporate Information</a></li>
                        <li><a href="">Cookie Preferences</a></li>
                        <li><a href="">Help Center</a></li>
                        <li><a href="">Privacy</a></li>
                        <li><a href="">Terms of Use</a></li>
                    </ul>
                </div>
    
                <select>
                    <option>Deutsch</option>
                    <option>English</option>
                </select>
            </div>
        </footer>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
