package uit.edu.vn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import uit.edu.vn.model.SanPhamModel;
import uit.edu.vn.entities.Book;

public class SanPhamAction  extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	
	private SanPhamModel sanphamModel = new SanPhamModel();
	private List<Book> lstSanPham;
	
	public List<Book> getLstSanPham() {
		return lstSanPham;
	}
	public void setLstSanPham(List<Book> lstSanPham) {
		this.lstSanPham = lstSanPham;
	}
	@Override
    public String execute() throws Exception{
		this.lstSanPham = sanphamModel.getSanPham();
		return SUCCESS;
		
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.setRequest(request);
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
