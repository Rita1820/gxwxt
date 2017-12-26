package com.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.TBanjiDAO;
import com.dao.TChengjiDAO;
import com.dao.TKechengDAO;
import com.dao.TUserDAO;
import com.model.TBanji;
import com.model.TChengji;
import com.model.TKecheng;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;
import com.util.ComparatorUser;

public class chengjiAction extends ActionSupport
{
	private Integer id;
	private Integer userId;
	private int kechengId;
	private String xueqi;
	
	private int fenshu;
	
	private TChengjiDAO chengjiDAO;
	private TUserDAO userDAO;
	private TBanjiDAO banjiDAO;
	private TKechengDAO kechengDAO;
	
	
	public String chengjiAdd()
	{
		
		String sql="from TChengji where xueqi=? and kechengId=? and userId=?";
		Object[] c={xueqi,kechengId,userId};
		List list=chengjiDAO.getHibernateTemplate().find(sql,c);
		if(list.size()>0)
		{
			Map request=(Map)ServletActionContext.getContext().get("request");
			request.put("msg", "成绩已经添加");
			return "msg";
		}
		
		TChengji chengji=new TChengji();
		
		//chengji.setId(id);
		chengji.setUserId(userId);
		chengji.setKechengId(kechengId);
		chengji.setXueqi(xueqi);
		
		chengji.setFenshu(fenshu);
		
		
		chengjiDAO.save(chengji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "成绩信息添加成功");
		return "msg";
	}
	
	public String chengjiMana()
	{
	    HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from TChengji order by xueqi,kechengId";
		Object[] c={};
		
		List chengjiList=chengjiDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<chengjiList.size();i++)
		{
			System.out.println("&&");
			TChengji chengji=(TChengji)chengjiList.get(i);
			chengji.setUser(userDAO.findById(chengji.getUserId()));
			chengji.setKecheng(kechengDAO.findById(chengji.getKechengId()));
		}
		request.setAttribute("chengjiList", chengjiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String chengjiDel()
	{
		
		TChengji chengji=chengjiDAO.findById(id);
		chengjiDAO.delete(chengji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "成绩信息删除成功");
		return "msg";
	}
	
	
	public String chengjiEdit()
	{
		
		TChengji chengji=chengjiDAO.findById(id);
		chengji.setFenshu(fenshu);
		chengjiDAO.attachDirty(chengji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息修改成功");
		return "msg";
	}
	
	
	public String chengjiMine()
	{
	    HttpServletRequest request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
	    TUser user=(TUser)session.getAttribute("user");
		
		String sql="from TChengji where userId="+user.getUserId()+"order by xueqi,kechengId";
		
		List chengjiList=chengjiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<chengjiList.size();i++)
		{
			TChengji chengji=(TChengji)chengjiList.get(i);
			chengji.setUser(userDAO.findById(chengji.getUserId()));
			chengji.setKecheng(kechengDAO.findById(chengji.getKechengId()));
		}
		request.setAttribute("chengjiList", chengjiList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String chengjiTongji()
	{
		List chengjiList=new ArrayList();
		
		String sql="from TUser where userDel='no' order by banjiId,userName";
		List userList=userDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<userList.size();i++)
		{
			TUser user=(TUser)userList.get(i);
			List chengjiList1=get_chengjiList(user.getUserId());
			for(int k=0;k<chengjiList1.size();k++)
			{
				TChengji chengji1=(TChengji)chengjiList1.get(k);
				System.out.println(chengji1+"^");
				chengjiList.add(chengji1);
			}
		}
		
		for(int j=0;j<chengjiList.size();j++)
		{
			TChengji chengji=(TChengji)chengjiList.get(j);
			TUser user=userDAO.findById(chengji.getUserId());
			TBanji banji=banjiDAO.findById(user.getBanjiId());
			user.setBanji(banji);
			
			chengji.setUser(user);
			
			TKecheng kecheng=kechengDAO.findById(chengji.getKechengId());
			chengji.setKecheng(kecheng);
		}
		
		System.out.println(chengjiList.size()+"^^");
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("chengjiList", chengjiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String chengjiTongji1()
	{
		List chengjiList=new ArrayList();
		
		String sql="from TUser where userDel='no' order by banjiId,userName";
		List userList=userDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<userList.size();i++)
		{
			TUser user=(TUser)userList.get(i);
			List chengjiList1=get_chengjiList1(user.getUserId(),xueqi);
			for(int k=0;k<chengjiList1.size();k++)
			{
				TChengji chengji1=(TChengji)chengjiList1.get(k);
				System.out.println(chengji1+"^");
				chengjiList.add(chengji1);
			}
		}
		
		for(int j=0;j<chengjiList.size();j++)
		{
			TChengji chengji=(TChengji)chengjiList.get(j);
			TUser user=userDAO.findById(chengji.getUserId());
			TBanji banji=banjiDAO.findById(user.getBanjiId());
			user.setBanji(banji);
			
			chengji.setUser(user);
			
			TKecheng kecheng=kechengDAO.findById(chengji.getKechengId());
			chengji.setKecheng(kecheng);
		}
		
		System.out.println(chengjiList.size()+"^^");
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("chengjiList", chengjiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public int get_zongfenshu(int userId)//各科目的总分
	{
		int zongfen=0;
		String sql="from TChengji where userId="+userId;
		List chengjiList=chengjiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<chengjiList.size();i++)
		{
			TChengji chengji=(TChengji)chengjiList.get(i);
			zongfen=zongfen+chengji.getFenshu();
		}
		return zongfen;
	}
	
	
	public List get_chengjiList(int userId)//各科目的总分
	{
		String sql="from TChengji where userId="+userId;
		List chengjiList=chengjiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<chengjiList.size();i++)
		{
			TChengji chengji=(TChengji)chengjiList.get(i);
			chengji.setKecheng(kechengDAO.findById(chengji.getKechengId()));
			
		}
		return chengjiList;
	}
	
	public List get_chengjiList1(int userId,String xueqi)//各科目的总分
	{
		String sql="from TChengji where userId="+userId+" and xueqi like '%"+xueqi.trim()+"%'";
		List chengjiList=chengjiDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<chengjiList.size();i++)
		{
			TChengji chengji=(TChengji)chengjiList.get(i);
			chengji.setKecheng(kechengDAO.findById(chengji.getKechengId()));
			
		}
		return chengjiList;
	}
	

	public TChengjiDAO getChengjiDAO()
	{
		return chengjiDAO;
	}

	public void setChengjiDAO(TChengjiDAO chengjiDAO)
	{
		this.chengjiDAO = chengjiDAO;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}



	public TKechengDAO getKechengDAO()
	{
		return kechengDAO;
	}

	public void setKechengDAO(TKechengDAO kechengDAO)
	{
		this.kechengDAO = kechengDAO;
	}

	public Integer getKechengId()
	{
		return kechengId;
	}

	public TBanjiDAO getBanjiDAO() {
		return banjiDAO;
	}

	public void setBanjiDAO(TBanjiDAO banjiDAO) {
		this.banjiDAO = banjiDAO;
	}

	public void setKechengId(Integer kechengId)
	{
		this.kechengId = kechengId;
	}


	public String getXueqi()
	{
		return xueqi;
	}

	public void setXueqi(String xueqi)
	{
		this.xueqi = xueqi;
	}


	public int getFenshu()
	{
		return fenshu;
	}

	public void setFenshu(int fenshu)
	{
		this.fenshu = fenshu;
	}

	public void setKechengId(int kechengId)
	{
		this.kechengId = kechengId;
	}

	
}
