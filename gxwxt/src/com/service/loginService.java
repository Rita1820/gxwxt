package com.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TBanjiDAO;
import com.dao.TLaoshiDAO;
import com.dao.TUserDAO;
import com.model.TAdmin;
import com.model.TBanji;
import com.model.TLaoshi;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class loginService {
	private TAdminDAO adminDAO;
	private TUserDAO userDAO;
	private TBanjiDAO banjiDAO;
	private TLaoshiDAO laoshiDAO;

	public TLaoshiDAO getLaoshiDAO() {
		return laoshiDAO;
	}

	public void setLaoshiDAO(TLaoshiDAO laoshiDAO) {
		this.laoshiDAO = laoshiDAO;
	}

	public TBanjiDAO getBanjiDAO() {
		return banjiDAO;
	}

	public void setBanjiDAO(TBanjiDAO banjiDAO) {
		this.banjiDAO = banjiDAO;
	}

	public TAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String login(String userName, String userPw, int userType) {
		System.out.println("userType" + userType);
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = "no";

		if (userType == 0)
		{
			String sql = "from TAdmin where userName=? and userPw=?";
			Object[] con = { userName, userPw };
			List adminList = adminDAO.getHibernateTemplate().find(sql, con);
			if (adminList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TAdmin admin = (TAdmin) adminList.get(0);
				session.setAttribute("userType", 0);
				session.setAttribute("admin", admin);
				result = "yes";
			}
		}
		if (userType == 1) {
			String sql = "from TUser where userDel='no' and userName=? and userPw=?";
			Object[] con = { userName.trim(), userPw.trim() };
			List userList = userDAO.getHibernateTemplate().find(sql, con);
			if (userList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TUser user = (TUser) userList.get(0);
				session.setAttribute("userType", 1);
				session.setAttribute("user", user);
				result = "yes";
			}
		}
		if (userType == 2) {
			String sql = "from TLaoshi where bianhao=? and loginpw=?";
			Object[] con = { userName.trim(), userPw.trim() };

			List laoshiList = laoshiDAO.getHibernateTemplate().find(sql, con);
			if (laoshiList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TLaoshi laoshi = (TLaoshi) laoshiList.get(0);
				session.setAttribute("userType", 2);
				session.setAttribute("laoshi", laoshi);
				result = "yes";
			}
		}
		return result;
	}

	public String adminPwEdit(String userPwNew) {
		System.out.println("DDDD");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();

		TAdmin admin = (TAdmin) session.getAttribute("admin");
		admin.setUserPw(userPwNew);

		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);

		return "yes";
	}

	public String jiance(String userName) {
		System.out.println("DDDD");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "from TUser where userName='" + userName + "'";
		List list = userDAO.getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			return "no";
		} else {
			return "yes";
		}
	}

	public List banjiSelect() {
		String sql = "from TBanji where del='no'";
		List banjiList = banjiDAO.getHibernateTemplate().find(sql);

		return banjiList;
	}

}
