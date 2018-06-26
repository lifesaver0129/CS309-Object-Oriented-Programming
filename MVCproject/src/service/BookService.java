package service;

import java.util.List;

import bean.BookBean;
import bean.UserinfoBean;

public interface BookService {
	List<BookBean> fetchBookList();
	int deleteBookById(int id) ;
	int AddBookinfo(BookBean bookBean);

	
}
