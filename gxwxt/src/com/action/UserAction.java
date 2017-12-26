package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBanjiDAO;
import com.dao.TUserDAO;
import com.model.TBanji;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport
{
	private Integer userId;
	private Integer banjiId;
	private String userName;
	private String userPw;
	
	private String userRealname;
	private String userSex;
	private String userAddress;
	private String userTel;
	
	private String userDel;
   
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;
	private TBanjiDAO banjiDAO;
	
	
	public String userAdd()
	{
		TUser user=new TUser();
		
		//user.setUserId(userId);
		user.setBanjiId(banjiId);
		user.setUserName(userName);
		user.setUserPw(userPw);
		
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserRealname(userRealname);
		user.setUserSex(userSex);
		
		user.setUserDel("no");
		
		userDAO.save(user);
		
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	
	
	
	public String userMana()
	{
		Map session=ActionContext.getContext().getSession();
		TBanji banji=(TBanji)session.get("banji");
		
		String sql="from TUser where userDel='no' order by banjiId";
		List userList=userDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<userList.size();i++)
		{
			TUser user=(TUser)userList.get(i);
			user.setBanji(banjiDAO.findById(user.getBanjiId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userDel()
	{
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String userAll()
	{
		Map session=ActionContext.getContext().getSession();
		TBanji banji=(TBanji)session.get("banji");
		
		String sql="from TUser where userDel='no' order by banjiId";
		List userList=userDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<userList.size();i++)
		{
			TUser user=(TUser)userList.get(i);
			user.setBanji(banjiDAO.findById(user.getBanjiId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String userEditMe()
	{
		TUser user=userDAO.findById(userId);
		
		//user.setUserId(userId);
		//user.setBanjiId(banjiId);
		user.setUserName(userName);
		user.setUserPw(userPw);
		
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserRealname(userRealname);
		user.setUserSex(userSex);
		
		user.setUserDel("no");
		
		userDAO.save(user);
		
		userDAO.attachDirty(user);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "修改成功，重新登录后生效");
		return "msg";
	}
	
	
	
	
	
	
	
	
	public String getUserAddress()
	{
		return userAddress;
	}

	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}




	public String getUserRealname()
	{
		return userRealname;
	}

	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}

	public String getUserSex()
	{
		return userSex;
	}

	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}

	public String getUserTel()
	{
		return userTel;
	}

	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}

	public int getUserId()
	{
		return userId;
	}


	public Integer getBanjiId() {
		return banjiId;
	}



	public void setBanjiId(Integer banjiId) {
		this.banjiId = banjiId;
	}



	public String getUserDel() {
		return userDel;
	}



	public void setUserDel(String userDel) {
		this.userDel = userDel;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public void setUserId(int userId)
	{
		this.userId = userId;
	}


	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public TUserDAO getUserDAO()
	{
		return userDAO;
	}




	public TBanjiDAO getBanjiDAO() {
		return banjiDAO;
	}



	public void setBanjiDAO(TBanjiDAO banjiDAO) {
		this.banjiDAO = banjiDAO;
	}



	public String getMessage()
	{
		return message;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}

	
}
