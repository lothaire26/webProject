<%@page import="de.hwg_lu.bw4s.beans.GetCodeAlsHtml"%>
<html>
  <head>
    <meta name="description" content="Netflix web page!." />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/headerFooter.css" />
    <link rel="stylesheet" href="../css/payment.css" />   
    <link rel="icon" href="../img/netflix_PNG15.png" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />    <title>Netflix - Creat Account</title>
   </head>
  <body>
  
   <jsp:useBean id="getCode" class="de.hwg_lu.bw4s.beans.GetCodeAlsHtml" scope="session"></jsp:useBean>
   <jsp:useBean id="abean" class="de.hwg_lu.bw4s.beans.AccountBean" scope="session"></jsp:useBean>
    
   <jsp:getProperty property="headerAsHtml" name="getCode"/>
    
    <!-- HTML -->
    
    
    <div class="content3">
    <p>step 3 of 3</p><br>
    <div class="welcome-message">
        <h1>Set up your PayPal!</h1>
    </div>

    <!-- Anzeige des Preises pro Monat in Euro -->
    <div class="price-box">
        <p class="abo"><span id="price">17.99&euro;/month</span><br> <span id="subscription">Premium</span></p>
          
        <a href="../jsp/zahlungsArt.jsp" id="changeSubscription"> <b>Change</b> </a>
    </div>

    <div class="sub-section">
        <p>To finish signup, click the<b> continue to PayPal</b> button and log in to PayPal using your email and password.</p>
    </div> <br> <br>
    <!-- Schaltfläche zum Fortfahren -->
    <a href="../jsp/user.html">
    <button class="continue-button" id="paypalButton"> <b>Continue to PayPal</b></button>
	</a>
    <!-- Ende des eigentlichen Inhalts -->
</div>

<!-- JavaScript -->
<script>
  document.getElementById('paypalButton').addEventListener('click', function () {
   
    var clientId = 'AXqc9CTkFhofggdhhr2hc9huqNqLFGWUk5Jmy7YEs4Kase2trthdfghshgtrhhhhhhn8GlBHSNZ5Dl_KAAOHzX8k3swp9IIO_faiTaryia';
    
    // Schicke eine Anfrage an PayPal zum Erstellen einer Bestellung     
    fetch('https://api.paypal.com/v2/checkout/orders', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer EJqBUdMrhzhrzjzteheekG7xcYx-OPhrthrehjzerscnva9A6hVpUc7pANrf53JgfhhsghdefhsR8aEVAl9xdECnDTl-bi5LsambD5CEc2Oq82m'
      },
      body: JSON.stringify({
        intent: 'CAPTURE',
        purchase_units: [{
          amount: {
            currency_code: 'EURO',
            value: '10.00'
          }
        }]
      })
    })
    .then(response => response.json())
    .then(data => {
      // Weiterleitung zur PayPal-Zahlungsseite
      window.location.href = data.links[1].href;
    });
  });
</script>
    
   
    <jsp:getProperty property="footerAsHtml" name="getCode"/>
    
    

    
  </body>
</html>
  