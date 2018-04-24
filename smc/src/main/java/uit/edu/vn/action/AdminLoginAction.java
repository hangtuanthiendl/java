package uit.edu.vn.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport {
	private String username, password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();

		if (this.username.equals("admin@smc.com") && this.password.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", this.username);
			session.setMaxInactiveInterval(30 * 60);// tinh bang giay 30 phut
			return "success";
		} else {
			return "error";
		}
	}
}