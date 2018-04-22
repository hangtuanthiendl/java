package uit.edu.vn.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
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
	
		public String conn() {
			  String ret = ERROR;
			       Connection conn = null;

			       try {
			          String URL = "jdbc:mysql://localhost:3306/DOJDB";
			          Class.forName("com.mysql.jdbc.Driver");
			          conn = DriverManager.getConnection(URL, "root", "root");
			          String sql = "SELECT name FROM user WHERE";
			          sql+=" userName = ? AND password = ?";
			          PreparedStatement ps = conn.prepareStatement(sql);
			          ps.setString(1, username);
			          ps.setString(2, password);
			          ResultSet rs = ps.executeQuery();

			          while (rs.next()) {
			           username = rs.getString(1);
			           ret = SUCCESS;
			          }
			       } catch (Exception e) {
			        addActionError(getText("error.login"));  
			          ret = ERROR;
			       } finally {
			          if (conn != null) {
			             try {
			                conn.close();
			             } catch (Exception e) {
			             }
			          }
			       }
			       return ret;
			    }
	
	@Override
	public String execute() {
	
		conn();
		
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