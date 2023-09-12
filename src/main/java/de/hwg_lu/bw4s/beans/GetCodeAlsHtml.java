package de.hwg_lu.bw4s.beans;

public class GetCodeAlsHtml {
	public GetCodeAlsHtml() {
		// TODO Auto-generated constructor stub
		System.out.println("html expresion abgerufen...");
	}
	/**
	 * login zustand der Anwendung
	 */
	String login="LOGIN";
	
	public String getLogin() {
		return login;
	}

	/**
	 * setzt der wert wenn der Login erfogricht ist
	 * @param   login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	public String getFooterAsHtml(){
		String html="<footer>\r\n"
				+ "      <div class=\"footer__row__1\">\r\n"
				+ "        <h4>Questions? Call 000-800-040-1843</h4>\r\n"
				+ "      </div>\r\n"
				+ "      <div class=\"footer__row__2\">\r\n"
				+ "        <div class=\"column__1\">\r\n"
				+ "          <p>FAQ</p>\r\n"
				+ "          <p>Investor Relations</p>\r\n"
				+ "          <p>Privacy</p>\r\n"
				+ "          <p>Speed Test</p>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"column__2\">\r\n"
				+ "          <p>Help Centre</p>\r\n"
				+ "          <p>Jobs</p>\r\n"
				+ "          <p>Cookie Preferences</p>\r\n"
				+ "          <p>Legal Notices</p>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"column__3\">\r\n"
				+ "          <p>Account</p>\r\n"
				+ "          <p>Ways to Watch</p>\r\n"
				+ "          <p>Corporate Information</p>\r\n"
				+ "          <p>Only on Netflix</p>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"column__4\">\r\n"
				+ "          <p>Media Centre</p>\r\n"
				+ "          <p>Terms of Use</p>\r\n"
				+ "          <p>Contact Us</p>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "      <div class=\"footer__row__3\">\r\n"
				+ "        <div class=\"dropdown__container\">\r\n"
				+ "          <i class=\"fas fa-globe\"></i>\r\n"
				+ "          <select\r\n"
				+ "            name=\"languages\"\r\n"
				+ "            id=\"languagesSelect\"\r\n"
				+ "            class=\"language__drop__down\"\r\n"
				+ "          >\r\n"
				+ "            <option value=\"english\" selected>English</option>\r\n"
				+ "            <option value=\"French\">French</option>\r\n"
				+ "          </select>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "      <div class=\"footer__row__4\">\r\n"
				+ "        <p>Netflix </p>\r\n"
				+ "      </div>\r\n"
				+ "    </footer>";
		return html;
	}
	public String getHeaderAsHtml(){
		String html=" <header>\r\n"
				+ "      <nav class=\"navbar\">\r\n"
				+ "        <div class=\"navbar__brand\">\r\n"
				+ "          <img\r\n"
				+ "            src=\"../img/netflix-logo.png\"\r\n"
				+ "            alt=\"logo\"\r\n"
				+ "            class=\"brand__logo\"\r\n"
				+ "          />\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div class=\"navbar__nav__items\">\r\n"
				+ "          <div class=\"nav__item\">\r\n"
				+ "            <div class=\"dropdown__container\">\r\n"
				+ "              <i class=\"fas fa-globe\"></i>\r\n"
				+ "              <select\r\n"
				+ "                name=\"languages\"\r\n"
				+ "                id=\"languagesSelect\"\r\n"
				+ "                class=\"language__drop__down\"\r\n"
				+ "              >\r\n"
				+ "                <option value=\"english\" selected style=\"color: black;\">English</option>\r\n"
				+ "                <option value=\"French\" style=\"color: black;\">French</option>\r\n"
				+ "              </select>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "          <div class=\"nav__item\">\r\n"
				+ "            <button class=\"signin__button\">Sign in</button>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </nav>\r\n"
				+ "    </header>\r\n"
				+ "";
		return html;
	}

}
