package uit.edu.vn.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import org.apache.struts2.ServletActionContext;
 
import com.opensymphony.xwork2.ActionSupport;
 
 
public class LoginAction extends ActionSupport{
	@Override
    public String execute() {
		System.out.print("Login Action Testing ...");
		//if(1)
		{
			//return "success";
			return "error";
		}
		/*else
		{
			return "error";
		}*/
	}
}
