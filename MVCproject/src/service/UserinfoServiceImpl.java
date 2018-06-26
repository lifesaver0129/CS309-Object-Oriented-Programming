package service;
import bean.UserinfoBean;
import dao.UserinfoDao;
import dao.UserinfoDaolmpl;
public class UserinfoServiceImpl implements UserinfoService{

	
	UserinfoDao	userinfoDao =	new UserinfoDaolmpl();
	@Override
	public int login(String	username,	String	password)	{
	int result =	0;
	try{
		result=userinfoDao.login(username,password);
	}catch(Exception	e){
	e.printStackTrace();
	}
	return result;
	}
	@Override
	public int registerUserinfo(UserinfoBean userinfoBean) {
		// TODO Auto-generated method stub
		int result=0;
		try{
			result=userinfoDao.registerUserinfo(userinfoBean);
			
		}catch(Exception e){
		e.printStackTrace();
		}
		return result;
	}
	 
	}

