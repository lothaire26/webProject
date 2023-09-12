<%@page import="de.hwg_lu.bw4s.beans.AccountBean"%>
<%@page import="de.hwg_lu.bw4s.beans.GetCodeAlsHtml"%>
<%@page import="de.hwg_lu.bw4s.beans.LoginBean"%>
<%@page import="java.sql.SQLException"%>
<%@page import="de.hwg_lu.bw.jdbc.NoConnectionException"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="accountBean" class="de.hwg_lu.bw4s.beans.AccountBean"></jsp:useBean>
<jsp:useBean id="loginBean" class="de.hwg_lu.bw4s.beans.LoginBean"></jsp:useBean>
<jsp:useBean id="htmlexprexion" class="de.hwg_lu.bw4s.beans.GetCodeAlsHtml"></jsp:useBean>

<%!
public String denullify(String inputString){
	if (inputString == null) return ""; else return inputString;
//	return (inputString == null)?"":inputString;
}
public String[] denullify(String[] inputStringArray){
	if (inputStringArray == null) return new String[0]; else return inputStringArray;
}
%>
	<%
//Eingabefelder

String emailLogin = request.getParameter("emaillogin");
String passwordlogin = request.getParameter("passlogin");
String password = request.getParameter("pass");
String password2 = request.getParameter("pass2");
String email = request.getParameter("email");
String name = request.getParameter("name");
String subscription = request.getParameter("subscription");



//Buttons
// testen outlogen
	loginBean.setMail("nx");
	loginBean.setPassword("");
	htmlexprexion.setLogin("LOGIN");
	



String adminLogin = this.denullify(request.getParameter("adminLogin"));
String simpleLogin = this.denullify(request.getParameter("simpleLogin"));
String registration = this.denullify(request.getParameter("registration"));
String gastlogin = this.denullify(request.getParameter("gastlogin"));
String aboModel = this.denullify(request.getParameter("aboModel"));


 if (registration.equals("Registrieren")){
	System.out.println("Registrieren-Button wurde geklickt");

	
	accountBean.setPassword(password);
	accountBean.setUsername(name);
	accountBean.setEmail(email);
	accountBean.setActive("Y");
	accountBean.setAdmin("N");
	

	try{
		boolean insertOk = accountBean.insertAccountIfNotExists();
		if (insertOk){//Nickname wurde geschrieben
			
			response.sendRedirect("./step1.jsp");	
		}else{
			
			response.sendRedirect("./connection.jsp");	
		}
	}catch(NoConnectionException exc){
		exc.printStackTrace();
		
		response.sendRedirect("./connection.jsp");	
	}catch(SQLException exc){
		exc.printStackTrace();
		//messageBean.setSQLError();
		response.sendRedirect("./connection.jsp");	
	}
}

else if (adminLogin.equals("adminLogin")){
	
	loginBean.setMail(emailLogin);
	loginBean.setPassword(passwordlogin);
	htmlexprexion.setLogin("LOGOUT");
	
	System.out.println("versuch einzulogen eingelietet");
	try{
		boolean useridPasswordOk = loginBean.checkUseridPassword();
		boolean useridPassword = loginBean.checkUseridPassword2();
		if (useridPasswordOk){
			//messageBean.setLoginSuccessful();
			loginBean.setLoggedIn(true);
			System.out.println(" versuch einzulogen erfolgreich");
			response.sendRedirect("../html/index.html");
		}else{
		//	messageBean.setLoginFailed();
			loginBean.setLoggedIn(false);
			System.out.println(" versuch einzulogen fehlgesclagen");
			response.sendRedirect("./regundlog.jsp");
		}
	}catch(NoConnectionException nce){
		//messageBean.setConnectionError();
		response.sendRedirect("./enregistrement.jsp");
	}catch(SQLException se){
		//messageBean.setSQLError();
		response.sendRedirect("./enregistrement.jsp");
	}
}
else if (simpleLogin.equals("simpleLogin")){
	
	loginBean.setMail(emailLogin);
	loginBean.setPassword(passwordlogin);
	htmlexprexion.setLogin("LOGOUT");
	
	System.out.println(" versuch einzulogen eingelietet");
	try{
		boolean useridPasswordOk = loginBean.checkUseridPassword();
		System.out.println(useridPasswordOk);
		
		if (useridPasswordOk){
			//messageBean.setLoginSuccessful();
			loginBean.setLoggedIn(true);
			System.out.println(useridPasswordOk+" versuch einzulogen erfolgreich");
			response.sendRedirect("../jsp/user.html");
		}else{
		//	messageBean.setLoginFailed();
			loginBean.setLoggedIn(false);
			System.out.println(useridPasswordOk+ " versuch einzulogen fehlgesclagen");
			response.sendRedirect("./enregistrement.jsp");
		}
	}catch(NoConnectionException nce){
		//messageBean.setConnectionError();
		response.sendRedirect("./enregistrement.jsp");
	}catch(SQLException se){
		//messageBean.setSQLError();
		response.sendRedirect("./enregistrement.jsp");
	}
}
else if (gastlogin.equals("Gast")){
	
	
	htmlexprexion.setLogin("Login");
	
	System.out.println(" versuch einzulogen als gast  eingelietet");
	
		response.sendRedirect("../jsp/home-user.html");
	
}
else if (aboModel.equals("aboModel")){
	
	
	
	
	System.out.println("Abonement ausgewählt");
	
		response.sendRedirect("../jsp/zahlungsArt.jsp");
	
}

else{
	System.out.println("kein Button gedrückt auch ");
	//messageBean.setGeneralWelcome();
	
	accountBean.setAccoutcheck(false);
	accountBean.setUpdat("");
	loginBean.setAdmin(false);
	
	response.sendRedirect("../html/index.html");
}


%>
</body>
</html>