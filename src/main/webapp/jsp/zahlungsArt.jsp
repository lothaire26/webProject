<%@page import="de.hwg_lu.bw4s.beans.GetCodeAlsHtml"%>
<html>
  <head>
    <meta name="description" content="Netflix web page!." />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/headerFooter.css" />
    <link rel="stylesheet" href="../css/zahlungsArt.css" />   
    <link rel="icon" href="../img/netflix_PNG15.png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />    <title>Netflix - Creat Account</title>
   </head>
  <body>
  
   <jsp:useBean id="getCode" class="de.hwg_lu.bw4s.beans.GetCodeAlsHtml" scope="session"></jsp:useBean>
   <jsp:useBean id="abean" class="de.hwg_lu.bw4s.beans.AccountBean" scope="session"></jsp:useBean>
    
   <jsp:getProperty property="headerAsHtml" name="getCode"/>
    
    
   
    <div class="container">
        <div class="title">
      
           <img class="keyImg" alt="key" src="../img/keys.svg"> <!-- Schloss-Logo -->
       
        <p class="step">Step 3 of 3</p>
            <h2>Choose how to pay</h2> <br>
            <p>Your payment is encrypted and you can change how you pay anytime </p> <br>
            <b> Secure for peace of mind.</b> <br>
            <b>cancel easily online.</b> <br>
            <p class="key">End-to end encripted &nbsp; <i class="fas fa-lock"></i></p>
        </div>

        <form action="../jsp/payPay.jsp">
            <input type="radio" name="payment" id="visa">
            <input type="radio" name="payment" id="mastercard">
            <input type="radio" name="payment" id="paypal">
            <input type="radio" name="payment" id="AMEX">
            <input type="radio" name="payment" id="gift">


            <div class="category">
                <label for="visa" class="visaMethod">
                    <div class="imgName">
                        <div class="imgContainer visa">
                            <img src="../img/Visa-Card.png" alt="">
                        </div>
                        <span class="name">VISA</span>
                    </div>
                    <span class="check"><i class="fas fa-check-circle" style="color: red;"></i></span>
                </label>

                <label for="mastercard" class="mastercardMethod">
                    <div class="imgName">
                        <div class="imgContainer mastercard">
                            <img src="../img/mastercard.jpg" alt="">
                        </div>
                        <span class="name">Mastercard</span>
                    </div>
                    <span class="check"><i class="fas fa-check-circle" style="color: red;"></i></span>
                </label>

                <label for="paypal" class="paypalMethod">
                    <div class="imgName">
                        <div class="imgContainer paypal">
                            <img src="../img/paypal.png" alt="">
                        </div>
                        <span class="name">Paypal</span>
                    </div>
                    <span class="check"><i class="fas fa-check-circle" style="color: red;"></i></span>
                </label>

                <label for="AMEX" class="amexMethod">
                    <div class="imgName">
                        <div class="imgContainer AMEX">
                            <img src="../img/American-Express.jpg" alt="">
                        </div>
                        <span class="name">AMEX</span>
                    </div>
                    <span class="check"><i class="fas fa-check-circle" style="color: red;"></i></span>
                </label>
                <br>
                <label for="gift" class="giftMethod">
                    <div class="imgName">
                        <div class="imgContainer gift">
                            <img src="../img/netflix-logo.png" alt="">
                        </div>
                        <span class="name">Netflix Gift</span>
                    </div>
                    <span class="check"><i class="fas fa-check-circle" style="color: red;"></i></span>
                </label>
                <br>
                <br>
                 
                     <a href="../jsp/payPay.jsp"><button class="continue-button">Next</button></a> 
                
            </div>
        </form>
    </div>
    
    <jsp:getProperty property="footerAsHtml" name="getCode"/>
    
    

    
  </body>
</html>
    