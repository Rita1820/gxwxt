package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TKechengDAO;
import com.model.TKecheng;
import com.opensymphony.xwork2.ActionSupport;

public class kechengAction extends ActionSupport
{

	private Integer id;
	private String mingcheng;
	private String del;
	
	private TKechengDAO kechengDAO;
	
	
	public String kechengAdd()
	{
		TKecheng kecheng=new TKecheng();
		
		kecheng.setMingcheng(mingcheng);
		kecheng.setDel("no");
		
		kechengDAO.save(kecheng);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	public String kechengMana()
	{
		String sql="from TKecheng where del='no'";
		List kechengList=kechengDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kechengList", kechengList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String kechengDel()
	{
		TKecheng kecheng=kechengDAO.findById(id);
		
		kecheng.setDel("yes");
		kechengDAO.attachDirty(kecheng);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String kechengAll()
	{
		String sql="from TKecheng where del='no'";
		List kechengList=kechengDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("kechengList", kechengList);
		return ActionSupport.SUCCESS;
	}

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
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

	public String getMingcheng()
	{
		return mingcheng;
	}

	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}
	
}
