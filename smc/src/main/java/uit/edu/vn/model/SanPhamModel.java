package uit.edu.vn.model;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import uit.edu.vn.entities.Book;

import uit.edu.vn.util.HibernateUtil;

public class SanPhamModel {
	public List<Book> getSanPham(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null ;
		try {
			transaction = session.beginTransaction();
			Query<Book> query = session.createQuery("FROM Book");
			List<Book> lstSanPham = query.list();
			transaction.commit();
			return lstSanPham;
		}catch(Exception e) {
			if(!(transaction ==null)) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
		return null;
	}
}
