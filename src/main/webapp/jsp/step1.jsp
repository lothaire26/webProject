<%@page import="de.hwg_lu.bw4s.beans.GetCodeAlsHtml"%>
<html>
  <head>
    <meta name="description" content="Netflix web page!." />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/headerFooter.css" />
    <link rel="stylesheet" href="../css/payment.css" />
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
      integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
      crossorigin="anonymous"
    />
    <link rel="icon" href="../img/netflix_PNG15.png" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"/>
    <title>Netflix - Creat Account</title>
   
  </head>
  <body>
  
   <jsp:useBean id="getCode" class="de.hwg_lu.bw4s.beans.GetCodeAlsHtml" scope="session"></jsp:useBean>
   <jsp:useBean id="abean" class="de.hwg_lu.bw4s.beans.AccountBean" scope="session"></jsp:useBean>
    
   <jsp:getProperty property="headerAsHtml" name="getCode"/>
    
    
   
    <div class="content">
     <img class="divice" alt="divice" src="../img/divice (2).png">
     <p>step 1 of 3</p>
      <div class="welcome-message">
        <h2>Hey, finish setting up your account!</h2>
      </div>

     
      <div class="sub-section">
        <p>Use this email to access your account:</p>
        </div>
        <h3 style="color:blue;">  <jsp:getProperty property="email" name="abean"/></h3><br>
      <!-- Schaltfläche zum Fortfahren -->
     <a href="../jsp/aboAuswahl.jsp"><button class="continue-button">Next</button></a> 

      <!-- Ende des eigentlichen Inhalts -->

    </div>
    
    
    <jsp:getProperty property="footerAsHtml" name="getCode"/>
    
    

    
  </body>
</html>
    