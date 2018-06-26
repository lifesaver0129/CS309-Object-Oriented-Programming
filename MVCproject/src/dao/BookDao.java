package dao;

import java.util.List;
import bean.BookBean;
import bean.UserinfoBean;
public interface BookDao {
	List<BookBean> fetchBookList() throws Exception;

	int deleteBookById(int id) throws Exception;
	
	int AddBookInfo(BookBean userinfoBean) throws Exception;

}
