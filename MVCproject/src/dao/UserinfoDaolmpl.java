package dao;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import bean.UserinfoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import util.DBUtil;
public class UserinfoDaolmpl implements UserinfoDao{
	DBUtil dbutil = new DBUtil();
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	UserinfoDao userinfoDao;
	Connection connection;
	
	public int login(String	username,String	password)throws Exception{
//		TODO Auto-generated	method	stub
		
		int result = 0;
		connection =	dbutil.getConnection();
		String	sql = "select	count(*)	from	userinfo	where	username=?	and	password=?";
	    preparedStatement =	connection.prepareStatement(sql);
		preparedStatement.setString(1,	username);
		preparedStatement.setString(2,	password);
		resultSet =	preparedStatement.executeQuery();
		while (resultSet.next())	{
		result = resultSet.getInt(1);
		}
		dbutil.closeDBResource(connection, preparedStatement, resultSet);
		return result;
		}

	public int registerUserinfo(UserinfoBean userinfoBean) throws Exception {
		int result = 0;
		Connection connection = dbutil.getConnection();
		String sql = "insert into userinfo (username, password) values (?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userinfoBean.getUsername());
		preparedStatement.setString(2, userinfoBean.getPassword());
		result = preparedStatement.executeUpdate();
		dbutil.closeDBResource(connection, preparedStatement, resultSet);
		return result;
		}
		

	
}
