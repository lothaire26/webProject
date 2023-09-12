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
    
   <jsp:getProperty property="headerAsHtml" name="getCode"/>
    
    
   <form action="../jsp/loginRegAppl.jsp" method="get">
    <div class="content2">
     
     <p>step 2 of 3</p>
      <div class="welcome-message">
        <h2>Choose the plan that's right for you</h2>
      </div>

     
      <div class="sub-section">
        <ul class="checklist">
	          <li><i class="fas fa-check"></i> Watch all you want.</li>
		      <li><i class="fas fa-check"></i> Recommendations just for you.</li>
		      <li><i class="fas fa-check"></i> Change or cancel your plan anytime.</li>
    	</ul>
        </div>
        
        <!-- tabelle zum auswahl -->
        <!-- Tabelle zur Auswahl -->
  <table class="subscription-table">
    <thead>
      
      <tr>
        <th class="empty"></th>
        <th>
                <input type="radio" id="standard_with_ads" name="subscription" value="standard_with_ads" checked="checked">
                <label for="standard_with_ads">Standard with Ads</label>
            </th>
            <th>
                <input type="radio" id="standard" name="subscription" value="standard">
                <label for="standard">Standard</label>
            </th>
            <th>
                <input type="radio" id="premium" name="subscription" value="premium">
                <label for="premium">Premium</label>
            </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="align">Monthly Price</td>
        <td>&euro;4.99</td>
        <td>&euro;12.99</td>
        <td>&euro;17.99</td>
      </tr>
      <tr>
        <td class="align">Video Quality</td>
        <td>720p</td>
        <td>1080p</td>
        <td>4K</td>
      </tr>
      <tr>
        <td class="align">Resolution</td>
        <td>HD</td>
        <td>Full HD</td>
        <td>Ultra HD</td>
      </tr>
      <tr>
        <td class="align">Watch on Your TV , Computer, mobile phone and tablet</td>
        <td><i class="fas fa-check"></i></td>
        <td><i class="fas fa-check"></i></td>
        <td><i class="fas fa-check"></i></td>
      </tr>
      <tr>
        <td class="align">Downloads</td>
        <td><i class="fa fa-minus"></i></td>
        <td><i class="fas fa-check"></i></td>
        <td><i class="fas fa-check"></i></td>
      </tr>
    </tbody>
  </table>
   <br> <br>
      <!-- Schaltfläche zum Fortfahren -->
      <button class="continue-button" type="submit" value="aboModel" name="aboModel">Next</button>

      <!-- Ende des eigentlichen Inhalts -->

    </div>
    
    
    <jsp:getProperty property="footerAsHtml" name="getCode"/>
    
    </form>

    
  </body>
</html>
    