package service;
import dao.BookDao;
import dao.BookDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import bean.BookBean;
import util.DBUtil;
public class BookServicelmpl implements BookService{
	BookDao bookDao=new BookDaoImpl();
	@Override
	public List<BookBean> fetchBookList() {
	List<BookBean> bookList=null;
	try{
		bookList=bookDao.fetchBookList();
	}catch(Exception e){
	e.printStackTrace();
	}
	return bookList;
	}
	public int deleteBookById(int id) {
		int id1 = 0;
		try 
		{
			id1 = bookDao.deleteBookById(id); 
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		 return id1;
		}
	@Override
	public int AddBookinfo(BookBean bookBean) {
		// TODO Auto-generated method stub
		int result=0;
		try{
			result=bookDao.AddBookInfo(bookBean);
			
		}catch(Exception e){
		e.printStackTrace();
		}
		return result;
	}
	}
	


