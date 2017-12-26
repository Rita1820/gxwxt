package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBanjiDAO;
import com.model.TBanji;
import com.opensymphony.xwork2.ActionSupport;

public class banjiAction extends ActionSupport
{
	private Integer id;
	private String mingcheng;
	private String banzhuren;
	private String loginname;
	
	private String loginpw;
	private String del;
	
	private TBanjiDAO banjiDAO;
	
	
	public String banjiAdd()
	{
		TBanji banji=new TBanji();
		
		//banji.setId(id);
		banji.setMingcheng(mingcheng);
		banji.setBanzhuren(banzhuren);
		banji.setLoginname(loginname);
		
		banji.setLoginpw(loginpw);
		banji.setDel("no");
		
		
		banjiDAO.save(banji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "专业信息添加成功");
		return "msg";
	}
	
	public String banjiMana()
	{
		String sql="from TBanji where del='no'";
		List banjiList=banjiDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("banjiList", banjiList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String banjiDel()
	{
		
		TBanji banji=banjiDAO.findById(id);
		banji.setDel("yes");
		banjiDAO.attachDirty(banji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "专业信息删除成功");
		return "msg";
	}
	
	
	public String banjiPre()
	{
		
		TBanji banji=banjiDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("banji", banji);
		return ActionSupport.SUCCESS;
	}
	
	public String banjiEdit()
	{
		
		TBanji banji=banjiDAO.findById(id);
		
		banji.setMingcheng(mingcheng);
		banji.setDel("no");
		
		
		banjiDAO.attachDirty(banji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息修改成功");
		return "msg";
	}
	
	
	public String banjiEditMe()
	{
		
		TBanji banji=banjiDAO.findById(id);
		
		//banji.setId(id);
		banji.setMingcheng(mingcheng);
		banji.setBanzhuren(banzhuren);
		banji.setLoginname(loginname);
		
		banji.setLoginpw(loginpw);
		banji.setDel("no");
		
		
		banjiDAO.attachDirty(banji);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息修改成功，重新登陆后生效");
		return "msg";
	}
	
	

	public TBanjiDAO getBanjiDAO()
	{
		return banjiDAO;
	}

	public void setBanjiDAO(TBanjiDAO banjiDAO)
	{
		this.banjiDAO = banjiDAO;
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

	public String getBanzhuren() {
		return banzhuren;
	}

	public void setBanzhuren(String banzhuren) {
		this.banzhuren = banzhuren;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpw() {
		return loginpw;
	}

	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
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
